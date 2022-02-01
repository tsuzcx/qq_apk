import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;

public class bjjy
  implements IRuntimeInterface
{
  private static volatile bjjy a;
  
  private bjjy()
  {
    QSecFramework.a(3L, new bjjz(this));
  }
  
  public static bjjy a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bjjy();
      }
      return a;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1) {
      bjhk.a(paramString, paramInt2);
    }
    while (paramInt1 != 2) {
      return;
    }
    bjhk.b(paramString, paramInt2);
  }
  
  public String getInterfaceName()
  {
    return "Rpt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjjy
 * JD-Core Version:    0.7.0.1
 */