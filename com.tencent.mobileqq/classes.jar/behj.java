import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.ui.MiniTranslucentFragmentActivity;

public class behj
{
  private static bera a = new bera();
  
  public static void a(Activity paramActivity, MiniAppInfo paramMiniAppInfo)
  {
    a(paramActivity, paramMiniAppInfo, null, null);
  }
  
  public static void a(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    betc.b("minisdk-start_MiniSDK", "startMiniApp miniappInfo:" + paramMiniAppInfo);
    bera localbera = a;
    if (paramActivity != null) {}
    for (Context localContext = paramActivity.getApplicationContext();; localContext = null)
    {
      localbera.a(localContext);
      a.a(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, ResultReceiver paramResultReceiver)
  {
    a(paramActivity, paramString, paramInt, new LaunchParam(), paramResultReceiver);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, LaunchParam paramLaunchParam, ResultReceiver paramResultReceiver)
  {
    a(paramActivity, paramString, paramInt, null, null, paramLaunchParam, paramResultReceiver);
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, LaunchParam paramLaunchParam, ResultReceiver paramResultReceiver)
  {
    betc.b("minisdk-start_MiniSDK", "startMiniApp appId:" + paramString1);
    bera localbera = a;
    if (paramActivity != null) {}
    for (Object localObject = paramActivity.getApplicationContext();; localObject = null)
    {
      localbera.a((Context)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("mini_appid", paramString1);
      paramLaunchParam.a = paramInt;
      ((Intent)localObject).putExtra("mini_entryPath", paramString2);
      ((Intent)localObject).putExtra("mini_envVersion", paramString3);
      ((Intent)localObject).putExtra("mini_launch_param", paramLaunchParam);
      ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
      ((Intent)localObject).putExtra("mini_receiver", paramResultReceiver);
      MiniTranslucentFragmentActivity.a(paramActivity, (Intent)localObject, a.a());
      paramActivity.overridePendingTransition(0, 0);
      return;
    }
  }
  
  public static void a(Context paramContext)
  {
    a.a(paramContext);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    betc.b("minisdk-start_MiniSDK", "preloadMiniApp");
    a.a(paramContext);
    a.a(paramContext, paramBundle);
  }
  
  public static void b(Context paramContext)
  {
    betc.b("minisdk-start_MiniSDK", "preloadMiniApp");
    a(paramContext, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     behj
 * JD-Core Version:    0.7.0.1
 */