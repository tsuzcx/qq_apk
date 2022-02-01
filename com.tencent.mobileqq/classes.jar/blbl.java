import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;
import mqq.app.MobileQQ;

public class blbl
  implements blcl, IRuntimeInterface
{
  private static volatile blbl a;
  
  private blbl()
  {
    QSecFramework.a(4L, new blbm(this));
  }
  
  public static blbl a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new blbl();
      }
      return a;
    }
    finally {}
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, blcm paramblcm)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (paramblcm != null)
      {
        nkm.a(localQQAppInterface, new blbo(paramArrayOfByte, paramblcm), paramArrayOfByte, paramString);
        return;
      }
      nkm.a(localQQAppInterface, new blbn(this), paramArrayOfByte, paramString);
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
 * Qualified Name:     blbl
 * JD-Core Version:    0.7.0.1
 */