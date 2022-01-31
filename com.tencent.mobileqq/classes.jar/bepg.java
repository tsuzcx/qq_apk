import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager;
import org.json.JSONObject;

public class bepg
  implements AsyncResult
{
  public bepg(AppBrandLaunchManager paramAppBrandLaunchManager) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    besl.b("minisdk-start_AppBrandLaunchManager", "---startApp---- useUserApp isSuccess = " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bepg
 * JD-Core Version:    0.7.0.1
 */