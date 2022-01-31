import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;
import mqq.app.MobileQQ;

public class bdzr
  implements bear, IRuntimeInterface
{
  private static volatile bdzr a;
  
  private bdzr()
  {
    QSecFramework.a(4, new bdzs(this));
  }
  
  public static bdzr a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bdzr();
      }
      return a;
    }
    finally {}
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, beas parambeas)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (parambeas != null)
      {
        mmj.a(localQQAppInterface, new bdzu(paramArrayOfByte, parambeas), paramArrayOfByte, paramString);
        return;
      }
      mmj.a(localQQAppInterface, new bdzt(this), paramArrayOfByte, paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String getInterfaceName()
  {
    return "CSP";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdzr
 * JD-Core Version:    0.7.0.1
 */