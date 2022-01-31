import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class bewy
  implements AsyncResult
{
  bewy(beww parambeww) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      long l = paramJSONObject.optLong("retCode");
      Object localObject = paramJSONObject.optString("errMsg");
      betc.a("MiniAppInfoLoadTask", "getAppInfoByLink, retCode = " + l + ",errMsg = " + (String)localObject);
      if (l != 0L)
      {
        if ((TextUtils.isEmpty((CharSequence)localObject)) && (bfgi.a())) {
          new StringBuilder().append("请求失败").append(", retCode = ").append(l).toString();
        }
        this.a.f();
      }
      localObject = (MiniAppInfo)paramJSONObject.opt("appInfo");
      paramJSONObject = paramJSONObject.optString("shareTicket", "");
      if ((l == 0L) && (localObject != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject).appId)))
      {
        ((MiniAppInfo)localObject).launchParam.a(beww.a(this.a).launchParam);
        ((MiniAppInfo)localObject).apkgInfo = beww.a(this.a).apkgInfo;
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
        beww.a(this.a, (MiniAppInfo)localObject);
        this.a.c();
        return;
      }
      bezl.a(beww.a(this.a), "1", null, "load_fail", "shortcut_request_fail");
      beyq.a("2launch_fail", "shotcut_request_fail", null, beww.a(this.a));
      if (localObject == null) {
        betc.d("MiniAppInfoLoadTask", "getAppInfoByLink  onCmdListener appinfo==null retCode= " + l);
      }
      for (;;)
      {
        this.a.f();
        return;
        betc.d("MiniAppInfoLoadTask", "getAppInfoByLink  onCmdListener retCode= " + l + " appid=" + ((MiniAppInfo)localObject).appId);
      }
    }
    bezl.a(beww.a(this.a), "1", null, "load_fail", "shortcut_request_fail");
    beyq.a("2launch_fail", "shotcut_request_fail", null, beww.a(this.a));
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewy
 * JD-Core Version:    0.7.0.1
 */