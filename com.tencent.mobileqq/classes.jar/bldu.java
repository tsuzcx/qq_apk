import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;

public class bldu
  implements IRuntimeInterface
{
  private static volatile bldu a;
  
  private bldu()
  {
    QSecFramework.a(3L, new bldv(this));
  }
  
  public static bldu a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bldu();
      }
      return a;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1) {
      blbg.a(paramString, paramInt2);
    }
    while (paramInt1 != 2) {
      return;
    }
    blbg.b(paramString, paramInt2);
  }
  
  public String getInterfaceName()
  {
    return "Rpt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldu
 * JD-Core Version:    0.7.0.1
 */