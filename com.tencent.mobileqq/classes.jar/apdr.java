import android.annotation.TargetApi;
import android.content.Context;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class apdr
{
  @TargetApi(23)
  public static void a(AppActivity paramAppActivity, int paramInt, QQPermissionCallback paramQQPermissionCallback)
  {
    if (paramAppActivity != null) {
      paramAppActivity.requestPermissions(paramQQPermissionCallback, paramInt, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
    }
  }
  
  @TargetApi(23)
  public static boolean a(Context paramContext)
  {
    return (paramContext != null) && (paramContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (paramContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdr
 * JD-Core Version:    0.7.0.1
 */