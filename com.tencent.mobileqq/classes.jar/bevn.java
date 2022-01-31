import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class bevn
{
  private static MiniAppInfo a;
  private static MiniAppInfo b;
  
  public static void a()
  {
    besl.a("JsApiUpdateManager", "handleUpdateApp() called");
    if ((a != null) && (b != null) && (a.launchParam != null) && (b.launchParam != null))
    {
      b.forceReroad = 3;
      b.launchParam.a = a.launchParam.a;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("key_app_info", b);
      beot.a().a("cmd_update_app_for_mini_game", localBundle, null);
      return;
    }
    besl.d("JsApiUpdateManager", "handleUpdateApp olderMiniAppInfo = " + a + " newerMiniAppInfo = " + b);
  }
  
  public static void a(beue parambeue, boolean paramBoolean)
  {
    try
    {
      besl.a("JsApiUpdateManager", "handleUpdateCheckResult() called with: gameJsPluginEngine = [" + parambeue + "], hasUpdate = [" + paramBoolean + "]");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("hasUpdate", paramBoolean);
      if (parambeue != null) {
        parambeue.getJsRuntime(1).evaluateSubscribeJs("onUpdateCheckResult", localJSONObject.toString());
      }
      return;
    }
    catch (JSONException parambeue)
    {
      besl.d("JsApiUpdateManager", "handleNativeRequest", parambeue);
    }
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, beue parambeue)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      a = paramMiniAppInfo;
      besl.a("JsApiUpdateManager", "checkUpdate() called with: oldMiniAppConfig = [" + paramMiniAppInfo + "], gameJsPluginEngine = [" + parambeue + "]");
      if (paramMiniAppInfo.verType != 3)
      {
        besl.c("JsApiUpdateManager", "checkForUpdate skip check for not online version");
        a(parambeue, false);
        return;
      }
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoById(paramMiniAppInfo.appId, "", "", new bevo(paramMiniAppInfo, parambeue));
      return;
    }
    besl.d("JsApiUpdateManager", "checkUpdate() called with: oldMiniAppConfig = [" + paramMiniAppInfo + "], gameJsPluginEngine = [" + parambeue + "]");
  }
  
  private static void b(beue parambeue, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      besl.a("JsApiUpdateManager", "handleUpdateDownload() called with: gameJsPluginEngine = [" + parambeue + "], miniAppConfig = [" + paramMiniAppInfo + "]");
      beut.a(paramMiniAppInfo, new bevp(parambeue));
    }
  }
  
  private static void c(beue parambeue, boolean paramBoolean)
  {
    try
    {
      besl.a("JsApiUpdateManager", "handleUpdateDownloadResult() called with: gameJsPluginEngine = [" + parambeue + "], success = [" + paramBoolean + "]");
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {}
      for (String str = "success";; str = "failed")
      {
        localJSONObject.put("updateResult", str);
        if (parambeue == null) {
          break;
        }
        parambeue.getJsRuntime(1).evaluateSubscribeJs("onUpdateDownloadResult", localJSONObject.toString());
        return;
      }
      return;
    }
    catch (JSONException parambeue)
    {
      besl.d("JsApiUpdateManager", "handleUpdateDownloadResult", parambeue);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevn
 * JD-Core Version:    0.7.0.1
 */