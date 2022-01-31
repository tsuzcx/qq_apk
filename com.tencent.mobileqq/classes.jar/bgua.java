import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class bgua
  implements AsyncResult
{
  public bgua(AppBrandLaunchManager paramAppBrandLaunchManager) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.i("minisdk-start_AppBrandLaunchManager", "---startApp---- useUserApp isSuccess = " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgua
 * JD-Core Version:    0.7.0.1
 */