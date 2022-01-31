import com.tencent.qphone.base.util.QLog;

public class asdr
{
  private asda jdField_a_of_type_Asda;
  private asdb jdField_a_of_type_Asdb;
  private asdd jdField_a_of_type_Asdd;
  private asdg jdField_a_of_type_Asdg;
  private asds jdField_a_of_type_Asds;
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfacePlayManager", 2, "func init begins, magicfaceDecoder:" + this.jdField_a_of_type_Asdb);
    }
    if (this.jdField_a_of_type_Asdb == null)
    {
      boolean bool = bbdh.d();
      long l = Math.min(bbdh.g(), bbdh.h());
      if ((!bool) || (l < 720L)) {
        break label118;
      }
      this.jdField_a_of_type_Asdb = new ascy();
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init, use [SuperBigDecoder]");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Asdb.a(this.jdField_a_of_type_Asdd);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init ends.");
      }
      return;
      label118:
      if ("xbig".equalsIgnoreCase(asdg.a()))
      {
        this.jdField_a_of_type_Asdb = new asdh();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [XBigDecoder]");
        }
      }
      else
      {
        this.jdField_a_of_type_Asdb = new asde();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [FFMepgDecoder]");
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Asdb != null) {
      this.jdField_a_of_type_Asdb.a(paramInt);
    }
  }
  
  public void a(asdc paramasdc)
  {
    if (this.jdField_a_of_type_Asdb != null) {
      this.jdField_a_of_type_Asdb.a(paramasdc);
    }
  }
  
  public void a(asdd paramasdd)
  {
    this.jdField_a_of_type_Asdd = paramasdd;
  }
  
  public void a(asdf paramasdf)
  {
    if ((this.jdField_a_of_type_Asda != null) && (paramasdf.a.equalsIgnoreCase(this.jdField_a_of_type_Asda.a))) {}
    for (;;)
    {
      this.jdField_a_of_type_Asdb.a(this.jdField_a_of_type_Asda);
      this.jdField_a_of_type_Asdb.d();
      return;
      this.jdField_a_of_type_Asda = this.jdField_a_of_type_Asdg.a(paramasdf.a, paramasdf.b);
      this.jdField_a_of_type_Asda.a = paramasdf.a;
      this.jdField_a_of_type_Asda.b = paramasdf.b;
    }
  }
  
  public void a(asdg paramasdg)
  {
    this.jdField_a_of_type_Asdg = paramasdg;
  }
  
  public void a(asds paramasds)
  {
    this.jdField_a_of_type_Asds = paramasds;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Asds != null) {
      this.jdField_a_of_type_Asds.a(this.jdField_a_of_type_Asdg.b(paramString));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Asds != null) {
      this.jdField_a_of_type_Asds.a(this.jdField_a_of_type_Asdg.b(paramString), paramInt, 3);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Asdb != null) {
      this.jdField_a_of_type_Asdb.e();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Asdb != null) {
      this.jdField_a_of_type_Asdb.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asdr
 * JD-Core Version:    0.7.0.1
 */