import com.tencent.qphone.base.util.QLog;

public class asdp
{
  private ascy jdField_a_of_type_Ascy;
  private ascz jdField_a_of_type_Ascz;
  private asdb jdField_a_of_type_Asdb;
  private asde jdField_a_of_type_Asde;
  private asdq jdField_a_of_type_Asdq;
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfacePlayManager", 2, "func init begins, magicfaceDecoder:" + this.jdField_a_of_type_Ascz);
    }
    if (this.jdField_a_of_type_Ascz == null)
    {
      boolean bool = bbct.d();
      long l = Math.min(bbct.g(), bbct.h());
      if ((!bool) || (l < 720L)) {
        break label118;
      }
      this.jdField_a_of_type_Ascz = new ascw();
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init, use [SuperBigDecoder]");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ascz.a(this.jdField_a_of_type_Asdb);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init ends.");
      }
      return;
      label118:
      if ("xbig".equalsIgnoreCase(asde.a()))
      {
        this.jdField_a_of_type_Ascz = new asdf();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [XBigDecoder]");
        }
      }
      else
      {
        this.jdField_a_of_type_Ascz = new asdc();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [FFMepgDecoder]");
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Ascz != null) {
      this.jdField_a_of_type_Ascz.a(paramInt);
    }
  }
  
  public void a(asda paramasda)
  {
    if (this.jdField_a_of_type_Ascz != null) {
      this.jdField_a_of_type_Ascz.a(paramasda);
    }
  }
  
  public void a(asdb paramasdb)
  {
    this.jdField_a_of_type_Asdb = paramasdb;
  }
  
  public void a(asdd paramasdd)
  {
    if ((this.jdField_a_of_type_Ascy != null) && (paramasdd.a.equalsIgnoreCase(this.jdField_a_of_type_Ascy.a))) {}
    for (;;)
    {
      this.jdField_a_of_type_Ascz.a(this.jdField_a_of_type_Ascy);
      this.jdField_a_of_type_Ascz.d();
      return;
      this.jdField_a_of_type_Ascy = this.jdField_a_of_type_Asde.a(paramasdd.a, paramasdd.b);
      this.jdField_a_of_type_Ascy.a = paramasdd.a;
      this.jdField_a_of_type_Ascy.b = paramasdd.b;
    }
  }
  
  public void a(asde paramasde)
  {
    this.jdField_a_of_type_Asde = paramasde;
  }
  
  public void a(asdq paramasdq)
  {
    this.jdField_a_of_type_Asdq = paramasdq;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Asdq != null) {
      this.jdField_a_of_type_Asdq.a(this.jdField_a_of_type_Asde.b(paramString));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Asdq != null) {
      this.jdField_a_of_type_Asdq.a(this.jdField_a_of_type_Asde.b(paramString), paramInt, 3);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ascz != null) {
      this.jdField_a_of_type_Ascz.e();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ascz != null) {
      this.jdField_a_of_type_Ascz.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asdp
 * JD-Core Version:    0.7.0.1
 */