import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;
import mqq.app.MobileQQ;

public class bhmz
  implements bhnz, IRuntimeInterface
{
  private static volatile bhmz a;
  
  private bhmz()
  {
    QSecFramework.a(4L, new bhna(this));
  }
  
  public static bhmz a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bhmz();
      }
      return a;
    }
    finally {}
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, bhoa parambhoa)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (parambhoa != null)
      {
        mzy.a(localQQAppInterface, new bhnc(paramArrayOfByte, parambhoa), paramArrayOfByte, paramString);
        return;
      }
      mzy.a(localQQAppInterface, new bhnb(this), paramArrayOfByte, paramString);
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
 * Qualified Name:     bhmz
 * JD-Core Version:    0.7.0.1
 */