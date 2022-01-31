import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class bewx
  implements AsyncResult
{
  bewx(beww parambeww) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      long l = paramJSONObject.optLong("retCode");
      String str = paramJSONObject.optString("errMsg");
      betc.b("MiniAppInfoLoadTask", "getAppInfoById, retCode = " + l + ",errMsg = " + str);
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null)
      {
        paramJSONObject.launchParam.a(beww.a(this.a).launchParam);
        paramJSONObject.apkgInfo = beww.a(this.a).apkgInfo;
        paramJSONObject.launchParam.a = paramJSONObject.appId;
        if (!TextUtils.isEmpty(beww.a(this.a).launchParam.d)) {
          paramJSONObject.extendData = beww.a(this.a).launchParam.d;
        }
        if (paramJSONObject.verType != 3) {
          paramJSONObject.forceReroad = 3;
        }
        bezi.a(paramJSONObject, 1028, "main_loading", bezi.a(paramJSONObject));
        beww.a(this.a, paramJSONObject);
        this.a.c();
        return;
      }
      bezl.a(beww.a(this.a), "1", null, "load_fail", "shortcut_request_fail");
      beyq.a("2launch_fail", "shotcut_request_fail", null, beww.a(this.a));
      this.a.f();
      return;
    }
    bezl.a(beww.a(this.a), "1", null, "load_fail", "shortcut_request_fail");
    beyq.a("2launch_fail", "shotcut_request_fail", null, beww.a(this.a));
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewx
 * JD-Core Version:    0.7.0.1
 */