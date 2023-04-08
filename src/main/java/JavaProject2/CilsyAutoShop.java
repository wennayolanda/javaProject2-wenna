package JavaProject2;

class Motor{
    String nama;
    int speed;
    double regularPrice;
    String color;
    public double getSalePrice(){
        return regularPrice - (regularPrice * 0.2);
    }
    public void getInfo(){
        System.out.println("Nama: " + nama);
        System.out.println("Speed: " + speed);
        System.out.println("Regular Price: Rp " + regularPrice);
        System.out.println("Color: " + color);
    }
}
class Harley extends Motor{
    int weight;
    public double getSalePrice(){
        if(weight > 2000) {
            return regularPrice - (regularPrice * 0.10);
        } else {
            return regularPrice - (regularPrice * 0.20);
        }
    }
}
class Honda extends Motor{
    int year;
    int manufacturerDiscount;

    public double getSalePrice() {
//        double hargaHonda = super.getSalePrice();
//
//        hargaHonda = hargaHonda - manufacturerDiscount;
//        return hargaHonda;
        return super.getSalePrice() - manufacturerDiscount;
    }
    public Honda(String nama, int speed, double regularPrice, String color, int year, int manufacturerDiscount){
        super.nama = nama;
        super.speed = speed;
        super.regularPrice = regularPrice;
        super.color = color;
        this.year = year;
        this.manufacturerDiscount = manufacturerDiscount;
    }

    public void getInfo() {
        super.getInfo();
        System.out.println("Year: " + year);
        System.out.println("Manufacturer Discount: Rp " + manufacturerDiscount);
        System.out.println("Harga " + nama + " (setelah diskon) sebesar Rp " + getSalePrice());
    }
}
class Yamaha extends Motor{
    int cc;
    public double getSalePrice(){
        if(cc > 250) {
            return regularPrice - (regularPrice * 0.15);
        } else {
            return regularPrice - (regularPrice * 0.10);
        }
    }
    public Yamaha(String nama, int speed, double regularPrice, String color, int cc){
        super.nama = nama;
        super.speed = speed;
        super.regularPrice = regularPrice;
        super.color = color;
        this.cc = cc;
    }

    public void getInfo() {
        super.getInfo();
        System.out.println("cc sebesar: " + cc + " cc");
        System.out.println("Harga " + nama + " (setelah diskon) sebesar Rp " + getSalePrice());
    }
}

public class CilsyAutoShop {
    public static void main(String[] args) {
        // instance dari class Yamaha
        Yamaha mio = new Yamaha("Yamaha Mio Soul",10,5000,"black",110);

        // 2 buah instance dari class Honda
        Honda scoopy = new Honda("Honda Scoopy",5,5000,"red",2010,1000);
        Honda beat = new Honda("Honda Beat", 8,7000,"orange",2014,2000);

        // instance dari class Motor
        Motor motor1 = new Motor();

        motor1.nama = "Vespa";
        motor1.speed = 10;
        motor1.regularPrice = 8000;
        motor1.color = "yellow";

        System.out.println();
        System.out.println("_____Data Motor YAMAHA_____");
        mio.getInfo();
        System.out.println();

        System.out.println("_____Data Motor HONDA_____");
        scoopy.getInfo();
        System.out.println();
        beat.getInfo();
        System.out.println();

        System.out.println("_____Data Motor Merek Lain_____");
        motor1.getInfo();
        System.out.println("Harga " + motor1.nama + " adalah Rp " + motor1.getSalePrice());
    }
}
