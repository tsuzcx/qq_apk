import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;
import mqq.app.MobileQQ;

public class bjhp
  implements bjip, IRuntimeInterface
{
  private static volatile bjhp a;
  
  private bjhp()
  {
    QSecFramework.a(4L, new bjhq(this));
  }
  
  public static bjhp a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bjhp();
      }
      return a;
    }
    finally {}
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, bjiq parambjiq)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (parambjiq != null)
      {
        nmb.a(localQQAppInterface, new bjhs(paramArrayOfByte, parambjiq), paramArrayOfByte, paramString);
        return;
      }
      nmb.a(localQQAppInterface, new bjhr(this), paramArrayOfByte, paramString);
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
 * Qualified Name:     bjhp
 * JD-Core Version:    0.7.0.1
 */