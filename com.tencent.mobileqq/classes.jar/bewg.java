import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class bewg
  implements AsyncResult
{
  bewg(bewf parambewf) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      long l = paramJSONObject.optLong("retCode");
      String str = paramJSONObject.optString("errMsg");
      besl.b("MiniAppInfoLoadTask", "getAppInfoById, retCode = " + l + ",errMsg = " + str);
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null)
      {
        paramJSONObject.launchParam.a(bewf.a(this.a).launchParam);
        paramJSONObject.apkgInfo = bewf.a(this.a).apkgInfo;
        paramJSONObject.launchParam.a = paramJSONObject.appId;
        if (!TextUtils.isEmpty(bewf.a(this.a).launchParam.d)) {
          paramJSONObject.extendData = bewf.a(this.a).launchParam.d;
        }
        if (paramJSONObject.verType != 3) {
          paramJSONObject.forceReroad = 3;
        }
        beyr.a(paramJSONObject, 1028, "main_loading", beyr.a(paramJSONObject));
        bewf.a(this.a, paramJSONObject);
        this.a.c();
        return;
      }
      beyu.a(bewf.a(this.a), "1", null, "load_fail", "shortcut_request_fail");
      bexz.a("2launch_fail", "shotcut_request_fail", null, bewf.a(this.a));
      this.a.f();
      return;
    }
    beyu.a(bewf.a(this.a), "1", null, "load_fail", "shortcut_request_fail");
    bexz.a("2launch_fail", "shotcut_request_fail", null, bewf.a(this.a));
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewg
 * JD-Core Version:    0.7.0.1
 */