import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bgzg
{
  private static MiniAppInfo a;
  private static MiniAppInfo b;
  
  public static void a()
  {
    QMLog.d("JsApiUpdateManager", "handleUpdateApp() called");
    if ((a != null) && (b != null) && (a.launchParam != null) && (b.launchParam != null))
    {
      b.forceReroad = 3;
      b.launchParam.scene = a.launchParam.scene;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("key_app_info", b);
      bgtu.a().a("cmd_update_app_for_mini_game", localBundle, null);
      return;
    }
    QMLog.e("JsApiUpdateManager", "handleUpdateApp olderMiniAppInfo = " + a + " newerMiniAppInfo = " + b);
  }
  
  public static void a(bgxn parambgxn, boolean paramBoolean)
  {
    try
    {
      QMLog.d("JsApiUpdateManager", "handleUpdateCheckResult() called with: gameJsPluginEngine = [" + parambgxn + "], hasUpdate = [" + paramBoolean + "]");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("hasUpdate", paramBoolean);
      if (parambgxn != null) {
        parambgxn.getJsRuntime(1).evaluateSubscribeJs("onUpdateCheckResult", localJSONObject.toString());
      }
      return;
    }
    catch (JSONException parambgxn)
    {
      QMLog.e("JsApiUpdateManager", "handleNativeRequest", parambgxn);
    }
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, bgxn parambgxn)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      a = paramMiniAppInfo;
      QMLog.d("JsApiUpdateManager", "checkUpdate() called with: oldMiniAppConfig = [" + paramMiniAppInfo + "], gameJsPluginEngine = [" + parambgxn + "]");
      if (paramMiniAppInfo.verType != 3)
      {
        QMLog.w("JsApiUpdateManager", "checkForUpdate skip check for not online version");
        a(parambgxn, false);
        return;
      }
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoById(paramMiniAppInfo.appId, "", "", new bgzh(paramMiniAppInfo, parambgxn));
      return;
    }
    QMLog.e("JsApiUpdateManager", "checkUpdate() called with: oldMiniAppConfig = [" + paramMiniAppInfo + "], gameJsPluginEngine = [" + parambgxn + "]");
  }
  
  private static void b(bgxn parambgxn, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      QMLog.d("JsApiUpdateManager", "handleUpdateDownload() called with: gameJsPluginEngine = [" + parambgxn + "], miniAppConfig = [" + paramMiniAppInfo + "]");
      bgyk.a(paramMiniAppInfo, new bgzi(parambgxn));
    }
  }
  
  private static void c(bgxn parambgxn, boolean paramBoolean)
  {
    try
    {
      QMLog.d("JsApiUpdateManager", "handleUpdateDownloadResult() called with: gameJsPluginEngine = [" + parambgxn + "], success = [" + paramBoolean + "]");
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {}
      for (String str = "success";; str = "failed")
      {
        localJSONObject.put("updateResult", str);
        if (parambgxn == null) {
          break;
        }
        parambgxn.getJsRuntime(1).evaluateSubscribeJs("onUpdateDownloadResult", localJSONObject.toString());
        return;
      }
      return;
    }
    catch (JSONException parambgxn)
    {
      QMLog.e("JsApiUpdateManager", "handleUpdateDownloadResult", parambgxn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgzg
 * JD-Core Version:    0.7.0.1
 */