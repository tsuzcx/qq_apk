import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;

public final class bkup
  implements bkts
{
  public void a()
  {
    if (QSecFramework.a()) {
      return;
    }
    try
    {
      if (!QSecFramework.b()) {
        System.loadLibrary("QSec");
      }
      QSecFramework.a(true);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QSecFramework", 2, "Something wrong when load native so.");
    }
    bkss.a(1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkup
 * JD-Core Version:    0.7.0.1
 */