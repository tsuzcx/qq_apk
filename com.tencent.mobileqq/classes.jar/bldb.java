import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import mqq.app.MobileQQ;

public class bldb
  implements blcd
{
  public bldb(QSecFramework paramQSecFramework) {}
  
  public void a()
  {
    if ((!QSecFramework.a()) || (QSecFramework.a(this.a))) {}
    for (;;)
    {
      return;
      try
      {
        Object[] arrayOfObject = new Object[1];
        if ((QSecFramework.a(1L, 33751040L, blbf.a(), 0L, QSecFramework.a(this.a), MobileQQ.sMobileQQ, null, arrayOfObject) == 0) && (arrayOfObject[0] != null) && ((arrayOfObject[0] instanceof Integer)))
        {
          QSecFramework.a(this.a, ((Integer)arrayOfObject[0]).intValue());
          blbf.a = QSecFramework.a(this.a);
          QSecFramework.a(this.a, true);
        }
        if (QLog.isColorLevel())
        {
          QLog.d("QSecFramework", 2, String.format("Native ver: %d(%s)", new Object[] { Integer.valueOf(QSecFramework.a(this.a)), blbf.a(QSecFramework.a(this.a)) }));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QSecFramework", 2, "Something wrong when init native.");
    }
    blbd.a(1, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldb
 * JD-Core Version:    0.7.0.1
 */