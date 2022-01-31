import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class bewe
{
  private static MiniAppInfo a;
  private static MiniAppInfo b;
  
  public static void a()
  {
    betc.a("JsApiUpdateManager", "handleUpdateApp() called");
    if ((a != null) && (b != null) && (a.launchParam != null) && (b.launchParam != null))
    {
      b.forceReroad = 3;
      b.launchParam.a = a.launchParam.a;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("key_app_info", b);
      bepk.a().a("cmd_update_app_for_mini_game", localBundle, null);
      return;
    }
    betc.d("JsApiUpdateManager", "handleUpdateApp olderMiniAppInfo = " + a + " newerMiniAppInfo = " + b);
  }
  
  public static void a(beuv parambeuv, boolean paramBoolean)
  {
    try
    {
      betc.a("JsApiUpdateManager", "handleUpdateCheckResult() called with: gameJsPluginEngine = [" + parambeuv + "], hasUpdate = [" + paramBoolean + "]");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("hasUpdate", paramBoolean);
      if (parambeuv != null) {
        parambeuv.getJsRuntime(1).evaluateSubscribeJs("onUpdateCheckResult", localJSONObject.toString());
      }
      return;
    }
    catch (JSONException parambeuv)
    {
      betc.d("JsApiUpdateManager", "handleNativeRequest", parambeuv);
    }
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, beuv parambeuv)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      a = paramMiniAppInfo;
      betc.a("JsApiUpdateManager", "checkUpdate() called with: oldMiniAppConfig = [" + paramMiniAppInfo + "], gameJsPluginEngine = [" + parambeuv + "]");
      if (paramMiniAppInfo.verType != 3)
      {
        betc.c("JsApiUpdateManager", "checkForUpdate skip check for not online version");
        a(parambeuv, false);
        return;
      }
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoById(paramMiniAppInfo.appId, "", "", new bewf(paramMiniAppInfo, parambeuv));
      return;
    }
    betc.d("JsApiUpdateManager", "checkUpdate() called with: oldMiniAppConfig = [" + paramMiniAppInfo + "], gameJsPluginEngine = [" + parambeuv + "]");
  }
  
  private static void b(beuv parambeuv, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      betc.a("JsApiUpdateManager", "handleUpdateDownload() called with: gameJsPluginEngine = [" + parambeuv + "], miniAppConfig = [" + paramMiniAppInfo + "]");
      bevk.a(paramMiniAppInfo, new bewg(parambeuv));
    }
  }
  
  private static void c(beuv parambeuv, boolean paramBoolean)
  {
    try
    {
      betc.a("JsApiUpdateManager", "handleUpdateDownloadResult() called with: gameJsPluginEngine = [" + parambeuv + "], success = [" + paramBoolean + "]");
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {}
      for (String str = "success";; str = "failed")
      {
        localJSONObject.put("updateResult", str);
        if (parambeuv == null) {
          break;
        }
        parambeuv.getJsRuntime(1).evaluateSubscribeJs("onUpdateDownloadResult", localJSONObject.toString());
        return;
      }
      return;
    }
    catch (JSONException parambeuv)
    {
      betc.d("JsApiUpdateManager", "handleUpdateDownloadResult", parambeuv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewe
 * JD-Core Version:    0.7.0.1
 */