import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;

public class beca
  implements IRuntimeInterface
{
  private static volatile beca a;
  
  private beca()
  {
    QSecFramework.a(3, new becb(this));
  }
  
  public static beca a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new beca();
      }
      return a;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1) {
      bdzm.a(paramString, paramInt2);
    }
    while (paramInt1 != 2) {
      return;
    }
    bdzm.b(paramString, paramInt2);
  }
  
  public String getInterfaceName()
  {
    return "Rpt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     beca
 * JD-Core Version:    0.7.0.1
 */