import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;

public class bkvj
  implements IRuntimeInterface
{
  private static volatile bkvj a;
  
  private bkvj()
  {
    QSecFramework.a(3L, new bkvk(this));
  }
  
  public static bkvj a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bkvj();
      }
      return a;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1) {
      bksv.a(paramString, paramInt2);
    }
    while (paramInt1 != 2) {
      return;
    }
    bksv.b(paramString, paramInt2);
  }
  
  public String getInterfaceName()
  {
    return "Rpt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvj
 * JD-Core Version:    0.7.0.1
 */