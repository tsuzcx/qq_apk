import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;

public class bfjq
  implements IRuntimeInterface
{
  private static volatile bfjq a;
  
  private bfjq()
  {
    QSecFramework.a(3L, new bfjr(this));
  }
  
  public static bfjq a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bfjq();
      }
      return a;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1) {
      bfhc.a(paramString, paramInt2);
    }
    while (paramInt1 != 2) {
      return;
    }
    bfhc.b(paramString, paramInt2);
  }
  
  public String getInterfaceName()
  {
    return "Rpt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfjq
 * JD-Core Version:    0.7.0.1
 */