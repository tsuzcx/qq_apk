package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
final class ActivityRecreator
{
  private static final String LOG_TAG = "ActivityRecreator";
  protected static final Class<?> activityThreadClass;
  private static final Handler mainHandler = new Handler(Looper.getMainLooper());
  protected static final Field mainThreadField;
  protected static final Method performStopActivity2ParamsMethod = getPerformStopActivity2Params(activityThreadClass);
  protected static final Method performStopActivity3ParamsMethod;
  protected static final Method requestRelaunchActivityMethod = getRequestRelaunchActivityMethod(activityThreadClass);
  protected static final Field tokenField;
  
  static
  {
    activityThreadClass = getActivityThreadClass();
    mainThreadField = getMainThreadField();
    tokenField = getTokenField();
    performStopActivity3ParamsMethod = getPerformStopActivity3Params(activityThreadClass);
  }
  
  private static Class<?> getActivityThreadClass()
  {
    try
    {
      Class localClass = Class.forName("android.app.ActivityThread");
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      label8:
      break label8;
    }
    return null;
  }
  
  private static Field getMainThreadField()
  {
    try
    {
      Field localField = Activity.class.getDeclaredField("mMainThread");
      localField.setAccessible(true);
      return localField;
    }
    catch (Throwable localThrowable)
    {
      label15:
      break label15;
    }
    return null;
  }
  
  private static Method getPerformStopActivity2Params(Class<?> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod("performStopActivity", new Class[] { IBinder.class, Boolean.TYPE });
      paramClass.setAccessible(true);
      return paramClass;
    }
    catch (Throwable paramClass) {}
    return null;
  }
  
  private static Method getPerformStopActivity3Params(Class<?> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod("performStopActivity", new Class[] { IBinder.class, Boolean.TYPE, String.class });
      paramClass.setAccessible(true);
      return paramClass;
    }
    catch (Throwable paramClass) {}
    return null;
  }
  
  private static Method getRequestRelaunchActivityMethod(Class<?> paramClass)
  {
    if (needsRelaunchCall()) {
      if (paramClass == null) {
        return null;
      }
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod("requestRelaunchActivity", new Class[] { IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE });
      paramClass.setAccessible(true);
      return paramClass;
    }
    catch (Throwable paramClass) {}
    return null;
    return null;
  }
  
  private static Field getTokenField()
  {
    try
    {
      Field localField = Activity.class.getDeclaredField("mToken");
      localField.setAccessible(true);
      return localField;
    }
    catch (Throwable localThrowable)
    {
      label15:
      break label15;
    }
    return null;
  }
  
  private static boolean needsRelaunchCall()
  {
    return (Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27);
  }
  
  protected static boolean queueOnStopIfNecessary(Object paramObject, Activity paramActivity)
  {
    try
    {
      Object localObject = tokenField.get(paramActivity);
      if (localObject != paramObject) {
        return false;
      }
      paramObject = mainThreadField.get(paramActivity);
      mainHandler.postAtFrontOfQueue(new ActivityRecreator.3(paramObject, localObject));
      return true;
    }
    catch (Throwable paramObject)
    {
      Log.e("ActivityRecreator", "Exception while fetching field values", paramObject);
    }
    return false;
  }
  
  static boolean recreate(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramActivity.recreate();
      return true;
    }
    if ((needsRelaunchCall()) && (requestRelaunchActivityMethod == null)) {
      return false;
    }
    if ((performStopActivity2ParamsMethod == null) && (performStopActivity3ParamsMethod == null)) {
      return false;
    }
    try
    {
      Object localObject1 = tokenField.get(paramActivity);
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = mainThreadField.get(paramActivity);
      if (localObject2 == null) {
        return false;
      }
      Application localApplication = paramActivity.getApplication();
      ActivityRecreator.LifecycleCheckCallbacks localLifecycleCheckCallbacks = new ActivityRecreator.LifecycleCheckCallbacks(paramActivity);
      localApplication.registerActivityLifecycleCallbacks(localLifecycleCheckCallbacks);
      mainHandler.post(new ActivityRecreator.1(localLifecycleCheckCallbacks, localObject1));
      try
      {
        if (needsRelaunchCall()) {
          requestRelaunchActivityMethod.invoke(localObject2, new Object[] { localObject1, null, null, Integer.valueOf(0), Boolean.valueOf(false), null, null, Boolean.valueOf(false), Boolean.valueOf(false) });
        } else {
          paramActivity.recreate();
        }
        return true;
      }
      finally
      {
        mainHandler.post(new ActivityRecreator.2(localApplication, localLifecycleCheckCallbacks));
      }
      return false;
    }
    catch (Throwable paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.ActivityRecreator
 * JD-Core Version:    0.7.0.1
 */