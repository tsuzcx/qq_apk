import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;

public class bhlb
  implements IRuntimeInterface
{
  private static volatile bhlb a;
  
  private bhlb()
  {
    QSecFramework.a(3L, new bhlc(this));
  }
  
  public static bhlb a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bhlb();
      }
      return a;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1) {
      bhin.a(paramString, paramInt2);
    }
    while (paramInt1 != 2) {
      return;
    }
    bhin.b(paramString, paramInt2);
  }
  
  public String getInterfaceName()
  {
    return "Rpt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhlb
 * JD-Core Version:    0.7.0.1
 */