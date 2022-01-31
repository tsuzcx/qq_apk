import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;
import mqq.app.MobileQQ;

public class bfhh
  implements bfih, IRuntimeInterface
{
  private static volatile bfhh a;
  
  private bfhh()
  {
    QSecFramework.a(4L, new bfhi(this));
  }
  
  public static bfhh a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bfhh();
      }
      return a;
    }
    finally {}
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, bfii parambfii)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (parambfii != null)
      {
        mxi.a(localQQAppInterface, new bfhk(paramArrayOfByte, parambfii), paramArrayOfByte, paramString);
        return;
      }
      mxi.a(localQQAppInterface, new bfhj(this), paramArrayOfByte, paramString);
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
 * Qualified Name:     bfhh
 * JD-Core Version:    0.7.0.1
 */