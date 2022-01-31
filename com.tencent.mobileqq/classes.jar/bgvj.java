import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class bgvj
  implements AsyncResult
{
  bgvj(bgvi parambgvi) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      long l = paramJSONObject.optLong("retCode");
      String str = paramJSONObject.optString("errMsg");
      QMLog.i("MiniAppInfoLoadTask", "getAppInfoById, retCode = " + l + ",errMsg = " + str);
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null)
      {
        paramJSONObject.launchParam.clone(bgvi.a(this.a).launchParam);
        paramJSONObject.apkgInfo = bgvi.a(this.a).apkgInfo;
        paramJSONObject.launchParam.miniAppId = paramJSONObject.appId;
        if (!TextUtils.isEmpty(bgvi.a(this.a).launchParam.extendData)) {
          paramJSONObject.extendData = bgvi.a(this.a).launchParam.extendData;
        }
        if (paramJSONObject.verType != 3) {
          paramJSONObject.forceReroad = 3;
        }
        bgyd.a(paramJSONObject, 1028, "main_loading", bgyd.a(paramJSONObject));
        bgvi.a(this.a, paramJSONObject);
        this.a.c();
        return;
      }
      bgyg.a(bgvi.a(this.a), "1", null, "load_fail", "shortcut_request_fail");
      bgxl.a("2launch_fail", "shotcut_request_fail", null, bgvi.a(this.a));
      this.a.e();
      return;
    }
    bgyg.a(bgvi.a(this.a), "1", null, "load_fail", "shortcut_request_fail");
    bgxl.a("2launch_fail", "shotcut_request_fail", null, bgvi.a(this.a));
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvj
 * JD-Core Version:    0.7.0.1
 */