import android.os.Build.VERSION;
import android.os.Process;

public class azmx
{
  private static Boolean a;
  
  public static boolean a()
  {
    if (a == null)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        break label28;
      }
      a = Boolean.valueOf(false);
    }
    for (;;)
    {
      return a.booleanValue();
      label28:
      if (Build.VERSION.SDK_INT >= 23) {
        a = Boolean.valueOf(Process.is64Bit());
      } else {
        a = Boolean.valueOf(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmx
 * JD-Core Version:    0.7.0.1
 */