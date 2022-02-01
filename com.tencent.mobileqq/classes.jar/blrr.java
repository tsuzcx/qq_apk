import android.app.Activity;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.ArrayMap;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class blrr
{
  public static void a(Activity paramActivity)
  {
    if (Build.MANUFACTURER.contains("samsung")) {
      if (QLog.isColorLevel()) {
        QLog.i("LeakUtil", 2, "removeLeakOn_SpenGestureManager samsung device");
      }
    }
    try
    {
      paramActivity = Class.forName("com.samsung.android.smartclip.SpenGestureManager").getDeclaredField("mContext");
      paramActivity.setAccessible(true);
      paramActivity.set(null, null);
      return;
    }
    catch (ClassNotFoundException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    catch (NoSuchFieldException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void b(Activity paramActivity)
  {
    if ((Build.VERSION.SDK_INT < 19) || (Build.VERSION.SDK_INT >= 28) || (paramActivity == null)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject2 = Class.forName("android.app.ActivityThread");
        Object localObject1 = ((Class)localObject2).getMethod("currentActivityThread", new Class[0]).invoke(localObject2, new Object[0]);
        if (localObject1 != null)
        {
          localObject2 = ((Class)localObject2).getDeclaredField("mOnPauseListeners");
          ((Field)localObject2).setAccessible(true);
          localObject1 = ((Field)localObject2).get(localObject1);
          if ((localObject1 instanceof ArrayMap))
          {
            ((ArrayMap)localObject1).remove(paramActivity);
            return;
          }
        }
      }
      catch (Exception paramActivity)
      {
        QLog.d("LeakUtil", 4, "fixOnPauseListenersLeak", paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrr
 * JD-Core Version:    0.7.0.1
 */