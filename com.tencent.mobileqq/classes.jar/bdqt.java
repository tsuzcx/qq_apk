import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class bdqt
  implements AsyncResult
{
  bdqt(bdqs parambdqs) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      long l = paramJSONObject.optLong("retCode");
      String str = paramJSONObject.optString("errMsg");
      bdnw.b("MiniAppInfoLoadTask", "getAppInfoById, retCode = " + l + ",errMsg = " + str);
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null)
      {
        paramJSONObject.launchParam.a(bdqs.a(this.a).launchParam);
        paramJSONObject.apkgInfo = bdqs.a(this.a).apkgInfo;
        paramJSONObject.launchParam.a = paramJSONObject.appId;
        if (!TextUtils.isEmpty(bdqs.a(this.a).launchParam.d)) {
          paramJSONObject.extendData = bdqs.a(this.a).launchParam.d;
        }
        if (paramJSONObject.verType != 3) {
          paramJSONObject.forceReroad = 3;
        }
        bdqs.a(this.a, paramJSONObject);
        this.a.c();
        return;
      }
      bdsx.a(bdqs.a(this.a), "1", null, "load_fail", "shortcut_request_fail");
      bdsc.a("2launch_fail", "shotcut_request_fail", null, bdqs.a(this.a));
      this.a.f();
      return;
    }
    bdsx.a(bdqs.a(this.a), "1", null, "load_fail", "shortcut_request_fail");
    bdsc.a("2launch_fail", "shotcut_request_fail", null, bdqs.a(this.a));
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdqt
 * JD-Core Version:    0.7.0.1
 */