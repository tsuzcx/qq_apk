import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public class awsn
{
  private awrw jdField_a_of_type_Awrw;
  private awrx jdField_a_of_type_Awrx;
  private awrz jdField_a_of_type_Awrz;
  private awsc jdField_a_of_type_Awsc;
  private awso jdField_a_of_type_Awso;
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfacePlayManager", 2, "func init begins, magicfaceDecoder:" + this.jdField_a_of_type_Awrx);
    }
    if (this.jdField_a_of_type_Awrx == null)
    {
      boolean bool = DeviceInfoUtil.isSupportOpenGlES20();
      long l = Math.min(DeviceInfoUtil.getDispalyWidth(), DeviceInfoUtil.getDispalyHeight());
      if ((!bool) || (l < 720L)) {
        break label118;
      }
      this.jdField_a_of_type_Awrx = new awru();
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init, use [SuperBigDecoder]");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Awrx.a(this.jdField_a_of_type_Awrz);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init ends.");
      }
      return;
      label118:
      if ("xbig".equalsIgnoreCase(awsc.a()))
      {
        this.jdField_a_of_type_Awrx = new awsd();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [XBigDecoder]");
        }
      }
      else
      {
        this.jdField_a_of_type_Awrx = new awsa();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [FFMepgDecoder]");
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Awrx != null) {
      this.jdField_a_of_type_Awrx.a(paramInt);
    }
  }
  
  public void a(awry paramawry)
  {
    if (this.jdField_a_of_type_Awrx != null) {
      this.jdField_a_of_type_Awrx.a(paramawry);
    }
  }
  
  public void a(awrz paramawrz)
  {
    this.jdField_a_of_type_Awrz = paramawrz;
  }
  
  public void a(awsb paramawsb)
  {
    if ((this.jdField_a_of_type_Awrw != null) && (paramawsb.a.equalsIgnoreCase(this.jdField_a_of_type_Awrw.a))) {}
    for (;;)
    {
      this.jdField_a_of_type_Awrx.a(this.jdField_a_of_type_Awrw);
      this.jdField_a_of_type_Awrx.d();
      return;
      this.jdField_a_of_type_Awrw = this.jdField_a_of_type_Awsc.a(paramawsb.a, paramawsb.b);
      this.jdField_a_of_type_Awrw.a = paramawsb.a;
      this.jdField_a_of_type_Awrw.b = paramawsb.b;
    }
  }
  
  public void a(awsc paramawsc)
  {
    this.jdField_a_of_type_Awsc = paramawsc;
  }
  
  public void a(awso paramawso)
  {
    this.jdField_a_of_type_Awso = paramawso;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Awso != null) {
      this.jdField_a_of_type_Awso.a(this.jdField_a_of_type_Awsc.b(paramString));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Awso != null) {
      this.jdField_a_of_type_Awso.a(this.jdField_a_of_type_Awsc.b(paramString), paramInt, 3);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Awrx != null) {
      this.jdField_a_of_type_Awrx.e();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Awrx != null) {
      this.jdField_a_of_type_Awrx.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsn
 * JD-Core Version:    0.7.0.1
 */