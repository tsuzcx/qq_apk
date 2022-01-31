import com.tencent.qphone.base.util.QLog;

public class atur
{
  private atua jdField_a_of_type_Atua;
  private atub jdField_a_of_type_Atub;
  private atud jdField_a_of_type_Atud;
  private atug jdField_a_of_type_Atug;
  private atus jdField_a_of_type_Atus;
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfacePlayManager", 2, "func init begins, magicfaceDecoder:" + this.jdField_a_of_type_Atub);
    }
    if (this.jdField_a_of_type_Atub == null)
    {
      boolean bool = bdcb.d();
      long l = Math.min(bdcb.g(), bdcb.h());
      if ((!bool) || (l < 720L)) {
        break label118;
      }
      this.jdField_a_of_type_Atub = new atty();
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init, use [SuperBigDecoder]");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Atub.a(this.jdField_a_of_type_Atud);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init ends.");
      }
      return;
      label118:
      if ("xbig".equalsIgnoreCase(atug.a()))
      {
        this.jdField_a_of_type_Atub = new atuh();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [XBigDecoder]");
        }
      }
      else
      {
        this.jdField_a_of_type_Atub = new atue();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [FFMepgDecoder]");
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Atub != null) {
      this.jdField_a_of_type_Atub.a(paramInt);
    }
  }
  
  public void a(atuc paramatuc)
  {
    if (this.jdField_a_of_type_Atub != null) {
      this.jdField_a_of_type_Atub.a(paramatuc);
    }
  }
  
  public void a(atud paramatud)
  {
    this.jdField_a_of_type_Atud = paramatud;
  }
  
  public void a(atuf paramatuf)
  {
    if ((this.jdField_a_of_type_Atua != null) && (paramatuf.a.equalsIgnoreCase(this.jdField_a_of_type_Atua.a))) {}
    for (;;)
    {
      this.jdField_a_of_type_Atub.a(this.jdField_a_of_type_Atua);
      this.jdField_a_of_type_Atub.d();
      return;
      this.jdField_a_of_type_Atua = this.jdField_a_of_type_Atug.a(paramatuf.a, paramatuf.b);
      this.jdField_a_of_type_Atua.a = paramatuf.a;
      this.jdField_a_of_type_Atua.b = paramatuf.b;
    }
  }
  
  public void a(atug paramatug)
  {
    this.jdField_a_of_type_Atug = paramatug;
  }
  
  public void a(atus paramatus)
  {
    this.jdField_a_of_type_Atus = paramatus;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Atus != null) {
      this.jdField_a_of_type_Atus.a(this.jdField_a_of_type_Atug.b(paramString));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Atus != null) {
      this.jdField_a_of_type_Atus.a(this.jdField_a_of_type_Atug.b(paramString), paramInt, 3);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Atub != null) {
      this.jdField_a_of_type_Atub.e();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Atub != null) {
      this.jdField_a_of_type_Atub.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atur
 * JD-Core Version:    0.7.0.1
 */