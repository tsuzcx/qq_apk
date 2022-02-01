import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;
import mqq.app.MobileQQ;

public class bkah
  implements bkbh, IRuntimeInterface
{
  private static volatile bkah a;
  
  private bkah()
  {
    QSecFramework.a(4L, new bkai(this));
  }
  
  public static bkah a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bkah();
      }
      return a;
    }
    finally {}
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, bkbi parambkbi)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (parambkbi != null)
      {
        nir.a(localQQAppInterface, new bkak(paramArrayOfByte, parambkbi), paramArrayOfByte, paramString);
        return;
      }
      nir.a(localQQAppInterface, new bkaj(this), paramArrayOfByte, paramString);
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
 * Qualified Name:     bkah
 * JD-Core Version:    0.7.0.1
 */