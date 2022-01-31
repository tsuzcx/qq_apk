import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;
import mqq.app.MobileQQ;

public class bhis
  implements bhjs, IRuntimeInterface
{
  private static volatile bhis a;
  
  private bhis()
  {
    QSecFramework.a(4L, new bhit(this));
  }
  
  public static bhis a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bhis();
      }
      return a;
    }
    finally {}
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, bhjt parambhjt)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (parambhjt != null)
      {
        mzy.a(localQQAppInterface, new bhiv(paramArrayOfByte, parambhjt), paramArrayOfByte, paramString);
        return;
      }
      mzy.a(localQQAppInterface, new bhiu(this), paramArrayOfByte, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhis
 * JD-Core Version:    0.7.0.1
 */