package androidx.core.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
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
    catch (Throwable localThrowable) {}
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
    catch (Throwable localThrowable) {}
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
    if ((!needsRelaunchCall()) || (paramClass == null)) {
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod("requestRelaunchActivity", new Class[] { IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE });
      paramClass.setAccessible(true);
      return paramClass;
    }
    catch (Throwable paramClass) {}
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
    catch (Throwable localThrowable) {}
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
  
  /* Error */
  static boolean recreate(@androidx.annotation.NonNull Activity paramActivity)
  {
    // Byte code:
    //   0: getstatic 142	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 28
    //   5: if_icmplt +9 -> 14
    //   8: aload_0
    //   9: invokevirtual 170	android/app/Activity:recreate	()V
    //   12: iconst_1
    //   13: ireturn
    //   14: invokestatic 125	androidx/core/app/ActivityRecreator:needsRelaunchCall	()Z
    //   17: ifeq +11 -> 28
    //   20: getstatic 73	androidx/core/app/ActivityRecreator:requestRelaunchActivityMethod	Ljava/lang/reflect/Method;
    //   23: ifnonnull +5 -> 28
    //   26: iconst_0
    //   27: ireturn
    //   28: getstatic 68	androidx/core/app/ActivityRecreator:performStopActivity2ParamsMethod	Ljava/lang/reflect/Method;
    //   31: ifnonnull +11 -> 42
    //   34: getstatic 63	androidx/core/app/ActivityRecreator:performStopActivity3ParamsMethod	Ljava/lang/reflect/Method;
    //   37: ifnonnull +5 -> 42
    //   40: iconst_0
    //   41: ireturn
    //   42: getstatic 57	androidx/core/app/ActivityRecreator:tokenField	Ljava/lang/reflect/Field;
    //   45: aload_0
    //   46: invokevirtual 148	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnonnull +5 -> 56
    //   54: iconst_0
    //   55: ireturn
    //   56: getstatic 52	androidx/core/app/ActivityRecreator:mainThreadField	Ljava/lang/reflect/Field;
    //   59: aload_0
    //   60: invokevirtual 148	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: astore 4
    //   65: aload 4
    //   67: ifnonnull +5 -> 72
    //   70: iconst_0
    //   71: ireturn
    //   72: aload_0
    //   73: invokevirtual 174	android/app/Activity:getApplication	()Landroid/app/Application;
    //   76: astore_1
    //   77: new 176	androidx/core/app/ActivityRecreator$LifecycleCheckCallbacks
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 179	androidx/core/app/ActivityRecreator$LifecycleCheckCallbacks:<init>	(Landroid/app/Activity;)V
    //   85: astore_2
    //   86: aload_1
    //   87: aload_2
    //   88: invokevirtual 185	android/app/Application:registerActivityLifecycleCallbacks	(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   91: getstatic 40	androidx/core/app/ActivityRecreator:mainHandler	Landroid/os/Handler;
    //   94: new 187	androidx/core/app/ActivityRecreator$1
    //   97: dup
    //   98: aload_2
    //   99: aload_3
    //   100: invokespecial 190	androidx/core/app/ActivityRecreator$1:<init>	(Landroidx/core/app/ActivityRecreator$LifecycleCheckCallbacks;Ljava/lang/Object;)V
    //   103: invokevirtual 193	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   106: pop
    //   107: invokestatic 125	androidx/core/app/ActivityRecreator:needsRelaunchCall	()Z
    //   110: ifeq +89 -> 199
    //   113: getstatic 73	androidx/core/app/ActivityRecreator:requestRelaunchActivityMethod	Ljava/lang/reflect/Method;
    //   116: aload 4
    //   118: bipush 9
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload_3
    //   126: aastore
    //   127: dup
    //   128: iconst_1
    //   129: aconst_null
    //   130: aastore
    //   131: dup
    //   132: iconst_2
    //   133: aconst_null
    //   134: aastore
    //   135: dup
    //   136: iconst_3
    //   137: iconst_0
    //   138: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: aastore
    //   142: dup
    //   143: iconst_4
    //   144: iconst_0
    //   145: invokestatic 200	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   148: aastore
    //   149: dup
    //   150: iconst_5
    //   151: aconst_null
    //   152: aastore
    //   153: dup
    //   154: bipush 6
    //   156: aconst_null
    //   157: aastore
    //   158: dup
    //   159: bipush 7
    //   161: iconst_0
    //   162: invokestatic 200	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   165: aastore
    //   166: dup
    //   167: bipush 8
    //   169: iconst_0
    //   170: invokestatic 200	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   173: aastore
    //   174: invokevirtual 204	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   177: pop
    //   178: getstatic 40	androidx/core/app/ActivityRecreator:mainHandler	Landroid/os/Handler;
    //   181: new 206	androidx/core/app/ActivityRecreator$2
    //   184: dup
    //   185: aload_1
    //   186: aload_2
    //   187: invokespecial 209	androidx/core/app/ActivityRecreator$2:<init>	(Landroid/app/Application;Landroidx/core/app/ActivityRecreator$LifecycleCheckCallbacks;)V
    //   190: invokevirtual 193	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   193: pop
    //   194: iconst_1
    //   195: ireturn
    //   196: astore_0
    //   197: iconst_0
    //   198: ireturn
    //   199: aload_0
    //   200: invokevirtual 170	android/app/Activity:recreate	()V
    //   203: goto -25 -> 178
    //   206: astore_0
    //   207: getstatic 40	androidx/core/app/ActivityRecreator:mainHandler	Landroid/os/Handler;
    //   210: new 206	androidx/core/app/ActivityRecreator$2
    //   213: dup
    //   214: aload_1
    //   215: aload_2
    //   216: invokespecial 209	androidx/core/app/ActivityRecreator$2:<init>	(Landroid/app/Application;Landroidx/core/app/ActivityRecreator$LifecycleCheckCallbacks;)V
    //   219: invokevirtual 193	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   222: pop
    //   223: aload_0
    //   224: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramActivity	Activity
    //   76	139	1	localApplication	android.app.Application
    //   85	131	2	localLifecycleCheckCallbacks	ActivityRecreator.LifecycleCheckCallbacks
    //   49	77	3	localObject1	Object
    //   63	54	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   42	50	196	java/lang/Throwable
    //   56	65	196	java/lang/Throwable
    //   72	107	196	java/lang/Throwable
    //   178	194	196	java/lang/Throwable
    //   207	225	196	java/lang/Throwable
    //   107	178	206	finally
    //   199	203	206	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.app.ActivityRecreator
 * JD-Core Version:    0.7.0.1
 */