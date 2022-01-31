import android.app.Activity;
import java.lang.reflect.Method;

public abstract class bkaz
{
  public static bkaz a;
  
  public static void a()
  {
    try
    {
      Method localMethod = Class.forName("cooperation.vip.common.VipClass").getMethod("getInstance", new Class[0]);
      localMethod.setAccessible(true);
      a = (bkaz)localMethod.invoke(null, new Object[0]);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void b(Activity paramActivity, String paramString)
  {
    bkaz localbkaz = a;
    if (localbkaz != null) {
      localbkaz.a(paramActivity, paramString);
    }
  }
  
  public abstract void a(Activity paramActivity, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bkaz
 * JD-Core Version:    0.7.0.1
 */