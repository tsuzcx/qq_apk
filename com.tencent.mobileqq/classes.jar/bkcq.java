import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;

public class bkcq
  implements IRuntimeInterface
{
  private static volatile bkcq a;
  
  private bkcq()
  {
    QSecFramework.a(3L, new bkcr(this));
  }
  
  public static bkcq a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bkcq();
      }
      return a;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1) {
      bkac.a(paramString, paramInt2);
    }
    while (paramInt1 != 2) {
      return;
    }
    bkac.b(paramString, paramInt2);
  }
  
  public String getInterfaceName()
  {
    return "Rpt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkcq
 * JD-Core Version:    0.7.0.1
 */