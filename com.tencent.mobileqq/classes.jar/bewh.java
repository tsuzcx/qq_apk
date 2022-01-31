import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class bewh
  implements AsyncResult
{
  bewh(bewf parambewf) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      long l = paramJSONObject.optLong("retCode");
      Object localObject = paramJSONObject.optString("errMsg");
      besl.a("MiniAppInfoLoadTask", "getAppInfoByLink, retCode = " + l + ",errMsg = " + (String)localObject);
      if (l != 0L)
      {
        if ((TextUtils.isEmpty((CharSequence)localObject)) && (bffr.a())) {
          new StringBuilder().append("请求失败").append(", retCode = ").append(l).toString();
        }
        this.a.f();
      }
      localObject = (MiniAppInfo)paramJSONObject.opt("appInfo");
      paramJSONObject = paramJSONObject.optString("shareTicket", "");
      if ((l == 0L) && (localObject != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject).appId)))
      {
        ((MiniAppInfo)localObject).launchParam.a(bewf.a(this.a).launchParam);
        ((MiniAppInfo)localObject).apkgInfo = bewf.a(this.a).apkgInfo;
        ((MiniAppInfo)localObject).launchParam.jdField_a_of_type_JavaLangString = ((MiniAppInfo)localObject).appId;
        ((MiniAppInfo)localObject).launchParam.h = paramJSONObject;
        ((MiniAppInfo)localObject).launchParam.e = ((MiniAppInfo)localObject).extraData;
        if (!TextUtils.isEmpty(((MiniAppInfo)localObject).launchParam.h)) {
          ((MiniAppInfo)localObject).launchParam.jdField_a_of_type_Int = 1044;
        }
        if (((MiniAppInfo)localObject).launchParam.jdField_a_of_type_JavaUtilMap == null) {
          ((MiniAppInfo)localObject).launchParam.jdField_a_of_type_JavaUtilMap = new HashMap();
        }
        if (((MiniAppInfo)localObject).reportData != null) {
          ((MiniAppInfo)localObject).launchParam.jdField_a_of_type_JavaUtilMap.putAll(((MiniAppInfo)localObject).reportData);
        }
        if (((MiniAppInfo)localObject).verType != 3) {
          ((MiniAppInfo)localObject).forceReroad = 3;
        }
        bewf.a(this.a, (MiniAppInfo)localObject);
        this.a.c();
        return;
      }
      beyu.a(bewf.a(this.a), "1", null, "load_fail", "shortcut_request_fail");
      bexz.a("2launch_fail", "shotcut_request_fail", null, bewf.a(this.a));
      if (localObject == null) {
        besl.d("MiniAppInfoLoadTask", "getAppInfoByLink  onCmdListener appinfo==null retCode= " + l);
      }
      for (;;)
      {
        this.a.f();
        return;
        besl.d("MiniAppInfoLoadTask", "getAppInfoByLink  onCmdListener retCode= " + l + " appid=" + ((MiniAppInfo)localObject).appId);
      }
    }
    beyu.a(bewf.a(this.a), "1", null, "load_fail", "shortcut_request_fail");
    bexz.a("2launch_fail", "shotcut_request_fail", null, bewf.a(this.a));
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewh
 * JD-Core Version:    0.7.0.1
 */