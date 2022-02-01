import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;
import mqq.app.MobileQQ;

public class bkta
  implements bkua, IRuntimeInterface
{
  private static volatile bkta a;
  
  private bkta()
  {
    QSecFramework.a(4L, new bktb(this));
  }
  
  public static bkta a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bkta();
      }
      return a;
    }
    finally {}
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, bkub parambkub)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (parambkub != null)
      {
        ntb.a(localQQAppInterface, new bktd(paramArrayOfByte, parambkub), paramArrayOfByte, paramString);
        return;
      }
      ntb.a(localQQAppInterface, new bktc(this), paramArrayOfByte, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkta
 * JD-Core Version:    0.7.0.1
 */