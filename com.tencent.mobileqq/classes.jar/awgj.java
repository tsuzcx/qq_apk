import com.tencent.qphone.base.util.QLog;

public class awgj
{
  private awfs jdField_a_of_type_Awfs;
  private awft jdField_a_of_type_Awft;
  private awfv jdField_a_of_type_Awfv;
  private awfy jdField_a_of_type_Awfy;
  private awgk jdField_a_of_type_Awgk;
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfacePlayManager", 2, "func init begins, magicfaceDecoder:" + this.jdField_a_of_type_Awft);
    }
    if (this.jdField_a_of_type_Awft == null)
    {
      boolean bool = bgln.d();
      long l = Math.min(bgln.g(), bgln.h());
      if ((!bool) || (l < 720L)) {
        break label118;
      }
      this.jdField_a_of_type_Awft = new awfq();
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init, use [SuperBigDecoder]");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Awft.a(this.jdField_a_of_type_Awfv);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init ends.");
      }
      return;
      label118:
      if ("xbig".equalsIgnoreCase(awfy.a()))
      {
        this.jdField_a_of_type_Awft = new awfz();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [XBigDecoder]");
        }
      }
      else
      {
        this.jdField_a_of_type_Awft = new awfw();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [FFMepgDecoder]");
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Awft != null) {
      this.jdField_a_of_type_Awft.a(paramInt);
    }
  }
  
  public void a(awfu paramawfu)
  {
    if (this.jdField_a_of_type_Awft != null) {
      this.jdField_a_of_type_Awft.a(paramawfu);
    }
  }
  
  public void a(awfv paramawfv)
  {
    this.jdField_a_of_type_Awfv = paramawfv;
  }
  
  public void a(awfx paramawfx)
  {
    if ((this.jdField_a_of_type_Awfs != null) && (paramawfx.a.equalsIgnoreCase(this.jdField_a_of_type_Awfs.a))) {}
    for (;;)
    {
      this.jdField_a_of_type_Awft.a(this.jdField_a_of_type_Awfs);
      this.jdField_a_of_type_Awft.d();
      return;
      this.jdField_a_of_type_Awfs = this.jdField_a_of_type_Awfy.a(paramawfx.a, paramawfx.b);
      this.jdField_a_of_type_Awfs.a = paramawfx.a;
      this.jdField_a_of_type_Awfs.b = paramawfx.b;
    }
  }
  
  public void a(awfy paramawfy)
  {
    this.jdField_a_of_type_Awfy = paramawfy;
  }
  
  public void a(awgk paramawgk)
  {
    this.jdField_a_of_type_Awgk = paramawgk;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Awgk != null) {
      this.jdField_a_of_type_Awgk.a(this.jdField_a_of_type_Awfy.b(paramString));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Awgk != null) {
      this.jdField_a_of_type_Awgk.a(this.jdField_a_of_type_Awfy.b(paramString), paramInt, 3);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Awft != null) {
      this.jdField_a_of_type_Awft.e();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Awft != null) {
      this.jdField_a_of_type_Awft.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awgj
 * JD-Core Version:    0.7.0.1
 */