import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.lang.reflect.Method;

public abstract class aqba
{
  public static aqba a;
  
  public static void a()
  {
    try
    {
      Method localMethod = Class.forName("com.tencent.mobileqq.haoliyou.JefsClass").getMethod("getInstance", new Class[0]);
      localMethod.setAccessible(true);
      a = (aqba)localMethod.invoke(null, new Object[0]);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    aqba localaqba = a;
    if (localaqba != null) {
      localaqba.b(paramActivity, paramIntent, paramInt, paramBundle);
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, Runnable paramRunnable)
  {
    aqba localaqba = a;
    if (localaqba != null) {
      localaqba.b(paramContext, paramIntent, paramRunnable);
    }
  }
  
  public abstract void b(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle);
  
  public abstract void b(Context paramContext, Intent paramIntent, Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqba
 * JD-Core Version:    0.7.0.1
 */