import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;
import mqq.app.MobileQQ;

public class bfhy
  implements bfiy, IRuntimeInterface
{
  private static volatile bfhy a;
  
  private bfhy()
  {
    QSecFramework.a(4L, new bfhz(this));
  }
  
  public static bfhy a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bfhy();
      }
      return a;
    }
    finally {}
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, bfiz parambfiz)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (parambfiz != null)
      {
        mxf.a(localQQAppInterface, new bfib(paramArrayOfByte, parambfiz), paramArrayOfByte, paramString);
        return;
      }
      mxf.a(localQQAppInterface, new bfia(this), paramArrayOfByte, paramString);
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
 * Qualified Name:     bfhy
 * JD-Core Version:    0.7.0.1
 */