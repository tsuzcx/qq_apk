import android.app.Activity;
import android.os.Build.VERSION;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.IPluginActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import mqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

public class bjqu
{
  public static boolean a(Activity paramActivity)
  {
    return a(paramActivity, new bjqv(paramActivity), 0);
  }
  
  public static boolean a(Activity paramActivity, QQPermissionCallback paramQQPermissionCallback, int paramInt)
  {
    if (paramActivity == null) {}
    do
    {
      return false;
      if ((paramActivity instanceof BasePluginActivity)) {
        return a((BasePluginActivity)paramActivity, paramQQPermissionCallback, paramInt);
      }
      if ((paramActivity instanceof QzonePluginProxyActivity)) {
        return a((QzonePluginProxyActivity)paramActivity, paramQQPermissionCallback, paramInt);
      }
      if ((paramActivity instanceof BaseActivity)) {
        return a((BaseActivity)paramActivity, paramQQPermissionCallback, paramInt);
      }
    } while (!(paramActivity instanceof Activity));
    return b(paramActivity);
  }
  
  public static boolean a(BasePluginActivity paramBasePluginActivity, QQPermissionCallback paramQQPermissionCallback, int paramInt)
  {
    if (paramBasePluginActivity == null) {
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && ((paramBasePluginActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (paramBasePluginActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)))
    {
      paramBasePluginActivity.requestPermissions(paramQQPermissionCallback, paramInt, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return false;
    }
    return true;
  }
  
  private static boolean a(QzonePluginProxyActivity paramQzonePluginProxyActivity, QQPermissionCallback paramQQPermissionCallback, int paramInt)
  {
    if (paramQzonePluginProxyActivity == null) {}
    do
    {
      return false;
      if ((Build.VERSION.SDK_INT < 23) || ((paramQzonePluginProxyActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (paramQzonePluginProxyActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0))) {
        break;
      }
      paramQzonePluginProxyActivity = paramQzonePluginProxyActivity.a();
    } while (paramQzonePluginProxyActivity == null);
    paramQzonePluginProxyActivity.requestPermissions(paramQQPermissionCallback, paramInt, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
    return false;
    return true;
  }
  
  private static boolean a(BaseActivity paramBaseActivity, QQPermissionCallback paramQQPermissionCallback, int paramInt)
  {
    if (paramBaseActivity == null) {
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && ((paramBaseActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (paramBaseActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)))
    {
      paramBaseActivity.requestPermissions(paramQQPermissionCallback, paramInt, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return false;
    }
    return true;
  }
  
  private static Activity b(Activity paramActivity)
  {
    Activity localActivity;
    if (paramActivity == null) {
      localActivity = null;
    }
    do
    {
      return localActivity;
      localActivity = paramActivity;
    } while (!(paramActivity instanceof BasePluginActivity));
    return ((BasePluginActivity)paramActivity).getOutActivity();
  }
  
  private static boolean b(Activity paramActivity)
  {
    if (paramActivity == null) {
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && ((paramActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (paramActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)))
    {
      bdcd.b(b(paramActivity));
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjqu
 * JD-Core Version:    0.7.0.1
 */