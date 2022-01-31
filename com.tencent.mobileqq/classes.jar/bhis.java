import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.reflect.Method;

public class bhis
{
  private static final int[] a = { 35, 36 };
  private static final int[] b = { 26, 27 };
  
  private static boolean a()
  {
    return "Meizu".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  public static boolean a(int paramInt)
  {
    return a(paramInt, AppLoaderFactory.g().getContext());
  }
  
  public static boolean a(int paramInt, Context paramContext)
  {
    if ((!a()) || (Build.VERSION.SDK_INT < 17)) {}
    do
    {
      return false;
      paramContext = paramContext.getSystemService("appops");
    } while ((paramContext == null) || (!paramContext.getClass().getSimpleName().equals("AppOpsManager")));
    try
    {
      Method localMethod = paramContext.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
      int i = b[paramInt];
      if (Build.VERSION.SDK_INT < 19) {
        i = a[paramInt];
      }
      ApplicationInfo localApplicationInfo = AppLoaderFactory.g().getContext().getApplicationInfo();
      paramInt = ((Integer)localMethod.invoke(paramContext, new Object[] { Integer.valueOf(i), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
      QMLog.d("AudioHelper", "isForbidByRubbishMeizu(), result = " + paramInt);
      if (paramInt != 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      QMLog.e("AudioHelper", paramContext.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhis
 * JD-Core Version:    0.7.0.1
 */