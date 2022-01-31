import com.tencent.qphone.base.util.QLog;

public class arhn
{
  private argw jdField_a_of_type_Argw;
  private argx jdField_a_of_type_Argx;
  private argz jdField_a_of_type_Argz;
  private arhc jdField_a_of_type_Arhc;
  private arho jdField_a_of_type_Arho;
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfacePlayManager", 2, "func init begins, magicfaceDecoder:" + this.jdField_a_of_type_Argx);
    }
    if (this.jdField_a_of_type_Argx == null)
    {
      boolean bool = babp.d();
      long l = Math.min(babp.g(), babp.h());
      if ((!bool) || (l < 720L)) {
        break label118;
      }
      this.jdField_a_of_type_Argx = new argu();
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init, use [SuperBigDecoder]");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Argx.a(this.jdField_a_of_type_Argz);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init ends.");
      }
      return;
      label118:
      if ("xbig".equalsIgnoreCase(arhc.a()))
      {
        this.jdField_a_of_type_Argx = new arhd();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [XBigDecoder]");
        }
      }
      else
      {
        this.jdField_a_of_type_Argx = new arha();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [FFMepgDecoder]");
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Argx != null) {
      this.jdField_a_of_type_Argx.a(paramInt);
    }
  }
  
  public void a(argy paramargy)
  {
    if (this.jdField_a_of_type_Argx != null) {
      this.jdField_a_of_type_Argx.a(paramargy);
    }
  }
  
  public void a(argz paramargz)
  {
    this.jdField_a_of_type_Argz = paramargz;
  }
  
  public void a(arhb paramarhb)
  {
    if ((this.jdField_a_of_type_Argw != null) && (paramarhb.a.equalsIgnoreCase(this.jdField_a_of_type_Argw.a))) {}
    for (;;)
    {
      this.jdField_a_of_type_Argx.a(this.jdField_a_of_type_Argw);
      this.jdField_a_of_type_Argx.d();
      return;
      this.jdField_a_of_type_Argw = this.jdField_a_of_type_Arhc.a(paramarhb.a, paramarhb.b);
      this.jdField_a_of_type_Argw.a = paramarhb.a;
      this.jdField_a_of_type_Argw.b = paramarhb.b;
    }
  }
  
  public void a(arhc paramarhc)
  {
    this.jdField_a_of_type_Arhc = paramarhc;
  }
  
  public void a(arho paramarho)
  {
    this.jdField_a_of_type_Arho = paramarho;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Arho != null) {
      this.jdField_a_of_type_Arho.a(this.jdField_a_of_type_Arhc.b(paramString));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Arho != null) {
      this.jdField_a_of_type_Arho.a(this.jdField_a_of_type_Arhc.b(paramString), paramInt, 3);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Argx != null) {
      this.jdField_a_of_type_Argx.e();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Argx != null) {
      this.jdField_a_of_type_Argx.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arhn
 * JD-Core Version:    0.7.0.1
 */