import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;

public class bhpi
  implements IRuntimeInterface
{
  private static volatile bhpi a;
  
  private bhpi()
  {
    QSecFramework.a(3L, new bhpj(this));
  }
  
  public static bhpi a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bhpi();
      }
      return a;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1) {
      bhmu.a(paramString, paramInt2);
    }
    while (paramInt1 != 2) {
      return;
    }
    bhmu.b(paramString, paramInt2);
  }
  
  public String getInterfaceName()
  {
    return "Rpt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhpi
 * JD-Core Version:    0.7.0.1
 */