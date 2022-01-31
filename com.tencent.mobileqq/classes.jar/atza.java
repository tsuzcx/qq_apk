import com.tencent.qphone.base.util.QLog;

public class atza
{
  private atyj jdField_a_of_type_Atyj;
  private atyk jdField_a_of_type_Atyk;
  private atym jdField_a_of_type_Atym;
  private atyp jdField_a_of_type_Atyp;
  private atzb jdField_a_of_type_Atzb;
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfacePlayManager", 2, "func init begins, magicfaceDecoder:" + this.jdField_a_of_type_Atyk);
    }
    if (this.jdField_a_of_type_Atyk == null)
    {
      boolean bool = bdgk.d();
      long l = Math.min(bdgk.g(), bdgk.h());
      if ((!bool) || (l < 720L)) {
        break label118;
      }
      this.jdField_a_of_type_Atyk = new atyh();
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init, use [SuperBigDecoder]");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Atyk.a(this.jdField_a_of_type_Atym);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init ends.");
      }
      return;
      label118:
      if ("xbig".equalsIgnoreCase(atyp.a()))
      {
        this.jdField_a_of_type_Atyk = new atyq();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [XBigDecoder]");
        }
      }
      else
      {
        this.jdField_a_of_type_Atyk = new atyn();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [FFMepgDecoder]");
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Atyk != null) {
      this.jdField_a_of_type_Atyk.a(paramInt);
    }
  }
  
  public void a(atyl paramatyl)
  {
    if (this.jdField_a_of_type_Atyk != null) {
      this.jdField_a_of_type_Atyk.a(paramatyl);
    }
  }
  
  public void a(atym paramatym)
  {
    this.jdField_a_of_type_Atym = paramatym;
  }
  
  public void a(atyo paramatyo)
  {
    if ((this.jdField_a_of_type_Atyj != null) && (paramatyo.a.equalsIgnoreCase(this.jdField_a_of_type_Atyj.a))) {}
    for (;;)
    {
      this.jdField_a_of_type_Atyk.a(this.jdField_a_of_type_Atyj);
      this.jdField_a_of_type_Atyk.d();
      return;
      this.jdField_a_of_type_Atyj = this.jdField_a_of_type_Atyp.a(paramatyo.a, paramatyo.b);
      this.jdField_a_of_type_Atyj.a = paramatyo.a;
      this.jdField_a_of_type_Atyj.b = paramatyo.b;
    }
  }
  
  public void a(atyp paramatyp)
  {
    this.jdField_a_of_type_Atyp = paramatyp;
  }
  
  public void a(atzb paramatzb)
  {
    this.jdField_a_of_type_Atzb = paramatzb;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Atzb != null) {
      this.jdField_a_of_type_Atzb.a(this.jdField_a_of_type_Atyp.b(paramString));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Atzb != null) {
      this.jdField_a_of_type_Atzb.a(this.jdField_a_of_type_Atyp.b(paramString), paramInt, 3);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Atyk != null) {
      this.jdField_a_of_type_Atyk.e();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Atyk != null) {
      this.jdField_a_of_type_Atyk.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atza
 * JD-Core Version:    0.7.0.1
 */