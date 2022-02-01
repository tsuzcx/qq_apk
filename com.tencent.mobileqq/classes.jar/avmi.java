import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public class avmi
{
  private avlr jdField_a_of_type_Avlr;
  private avls jdField_a_of_type_Avls;
  private avlu jdField_a_of_type_Avlu;
  private avlx jdField_a_of_type_Avlx;
  private avmj jdField_a_of_type_Avmj;
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfacePlayManager", 2, "func init begins, magicfaceDecoder:" + this.jdField_a_of_type_Avls);
    }
    if (this.jdField_a_of_type_Avls == null)
    {
      boolean bool = DeviceInfoUtil.isSupportOpenGlES20();
      long l = Math.min(DeviceInfoUtil.getDispalyWidth(), DeviceInfoUtil.getDispalyHeight());
      if ((!bool) || (l < 720L)) {
        break label118;
      }
      this.jdField_a_of_type_Avls = new avlp();
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init, use [SuperBigDecoder]");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Avls.a(this.jdField_a_of_type_Avlu);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init ends.");
      }
      return;
      label118:
      if ("xbig".equalsIgnoreCase(avlx.a()))
      {
        this.jdField_a_of_type_Avls = new avly();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [XBigDecoder]");
        }
      }
      else
      {
        this.jdField_a_of_type_Avls = new avlv();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [FFMepgDecoder]");
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Avls != null) {
      this.jdField_a_of_type_Avls.a(paramInt);
    }
  }
  
  public void a(avlt paramavlt)
  {
    if (this.jdField_a_of_type_Avls != null) {
      this.jdField_a_of_type_Avls.a(paramavlt);
    }
  }
  
  public void a(avlu paramavlu)
  {
    this.jdField_a_of_type_Avlu = paramavlu;
  }
  
  public void a(avlw paramavlw)
  {
    if ((this.jdField_a_of_type_Avlr != null) && (paramavlw.a.equalsIgnoreCase(this.jdField_a_of_type_Avlr.a))) {}
    for (;;)
    {
      this.jdField_a_of_type_Avls.a(this.jdField_a_of_type_Avlr);
      this.jdField_a_of_type_Avls.d();
      return;
      this.jdField_a_of_type_Avlr = this.jdField_a_of_type_Avlx.a(paramavlw.a, paramavlw.b);
      this.jdField_a_of_type_Avlr.a = paramavlw.a;
      this.jdField_a_of_type_Avlr.b = paramavlw.b;
    }
  }
  
  public void a(avlx paramavlx)
  {
    this.jdField_a_of_type_Avlx = paramavlx;
  }
  
  public void a(avmj paramavmj)
  {
    this.jdField_a_of_type_Avmj = paramavmj;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Avmj != null) {
      this.jdField_a_of_type_Avmj.a(this.jdField_a_of_type_Avlx.b(paramString));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Avmj != null) {
      this.jdField_a_of_type_Avmj.a(this.jdField_a_of_type_Avlx.b(paramString), paramInt, 3);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Avls != null) {
      this.jdField_a_of_type_Avls.e();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Avls != null) {
      this.jdField_a_of_type_Avls.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmi
 * JD-Core Version:    0.7.0.1
 */