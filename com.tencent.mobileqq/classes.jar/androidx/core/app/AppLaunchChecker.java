package androidx.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.annotation.NonNull;

public class AppLaunchChecker
{
  private static final String KEY_STARTED_FROM_LAUNCHER = "startedFromLauncher";
  private static final String SHARED_PREFS_NAME = "android.support.AppLaunchChecker";
  
  public static boolean hasStartedFromLauncher(@NonNull Context paramContext)
  {
    return paramContext.getSharedPreferences("android.support.AppLaunchChecker", 0).getBoolean("startedFromLauncher", false);
  }
  
  public static void onActivityCreate(@NonNull Activity paramActivity)
  {
    SharedPreferences localSharedPreferences = paramActivity.getSharedPreferences("android.support.AppLaunchChecker", 0);
    if (localSharedPreferences.getBoolean("startedFromLauncher", false)) {}
    do
    {
      return;
      paramActivity = paramActivity.getIntent();
    } while ((paramActivity == null) || (!"android.intent.action.MAIN".equals(paramActivity.getAction())) || ((!paramActivity.hasCategory("android.intent.category.LAUNCHER")) && (!paramActivity.hasCategory("android.intent.category.LEANBACK_LAUNCHER"))));
    localSharedPreferences.edit().putBoolean("startedFromLauncher", true).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.app.AppLaunchChecker
 * JD-Core Version:    0.7.0.1
 */