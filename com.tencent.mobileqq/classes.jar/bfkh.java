import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;

public class bfkh
  implements IRuntimeInterface
{
  private static volatile bfkh a;
  
  private bfkh()
  {
    QSecFramework.a(3L, new bfki(this));
  }
  
  public static bfkh a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bfkh();
      }
      return a;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1) {
      bfht.a(paramString, paramInt2);
    }
    while (paramInt1 != 2) {
      return;
    }
    bfht.b(paramString, paramInt2);
  }
  
  public String getInterfaceName()
  {
    return "Rpt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfkh
 * JD-Core Version:    0.7.0.1
 */