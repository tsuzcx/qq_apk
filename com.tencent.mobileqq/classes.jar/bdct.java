import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class bdct
{
  private static bdlz a = new bdlz();
  
  public static void a(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    bdnw.b("minisdk-start_MiniSDK", "startMiniApp miniappInfo:" + paramMiniAppInfo);
    bdlz localbdlz = a;
    if (paramActivity != null) {}
    for (Context localContext = paramActivity.getApplicationContext();; localContext = null)
    {
      localbdlz.a(localContext);
      a.a(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
      return;
    }
  }
  
  public static void a(Context paramContext)
  {
    bdnw.b("minisdk-start_MiniSDK", "preloadMiniApp");
    a(paramContext, new Bundle());
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    bdnw.b("minisdk-start_MiniSDK", "preloadMiniApp");
    a.a(paramContext);
    a.a(paramContext, paramBundle);
  }
  
  public static void a(Context paramContext, bdcq parambdcq)
  {
    a.a(paramContext, parambdcq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdct
 * JD-Core Version:    0.7.0.1
 */