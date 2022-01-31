import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import org.json.JSONObject;

class bgvk
  implements AsyncResult
{
  bgvk(bgvi parambgvi) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      long l = paramJSONObject.optLong("retCode");
      Object localObject = paramJSONObject.optString("errMsg");
      QMLog.d("MiniAppInfoLoadTask", "getAppInfoByLink, retCode = " + l + ",errMsg = " + (String)localObject);
      if (l != 0L)
      {
        if ((TextUtils.isEmpty((CharSequence)localObject)) && (DebugUtil.isDebugVersion())) {
          new StringBuilder().append("请求失败").append(", retCode = ").append(l).toString();
        }
        this.a.e();
      }
      localObject = (MiniAppInfo)paramJSONObject.opt("appInfo");
      paramJSONObject = paramJSONObject.optString("shareTicket", "");
      if ((l == 0L) && (localObject != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject).appId)))
      {
        ((MiniAppInfo)localObject).launchParam.clone(bgvi.a(this.a).launchParam);
        ((MiniAppInfo)localObject).apkgInfo = bgvi.a(this.a).apkgInfo;
        ((MiniAppInfo)localObject).launchParam.miniAppId = ((MiniAppInfo)localObject).appId;
        ((MiniAppInfo)localObject).launchParam.shareTicket = paramJSONObject;
        ((MiniAppInfo)localObject).launchParam.navigateExtData = ((MiniAppInfo)localObject).extraData;
        if (!TextUtils.isEmpty(((MiniAppInfo)localObject).launchParam.shareTicket)) {
          ((MiniAppInfo)localObject).launchParam.scene = 1044;
        }
        if (TextUtils.isEmpty(((MiniAppInfo)localObject).launchParam.reportData)) {
          ((MiniAppInfo)localObject).launchParam.reportData = ((MiniAppInfo)localObject).reportData;
        }
        for (;;)
        {
          if (((MiniAppInfo)localObject).verType != 3) {
            ((MiniAppInfo)localObject).forceReroad = 3;
          }
          bgvi.a(this.a, (MiniAppInfo)localObject);
          this.a.c();
          return;
          if (!TextUtils.isEmpty(((MiniAppInfo)localObject).reportData)) {
            ((MiniAppInfo)localObject).launchParam.reportData = (((MiniAppInfo)localObject).launchParam.reportData + "&" + ((MiniAppInfo)localObject).reportData);
          }
        }
      }
      bgyg.a(bgvi.a(this.a), "1", null, "load_fail", "shortcut_request_fail");
      bgxl.a("2launch_fail", "shotcut_request_fail", null, bgvi.a(this.a));
      if (localObject == null) {
        QMLog.e("MiniAppInfoLoadTask", "getAppInfoByLink  onCmdListener appinfo==null retCode= " + l);
      }
      for (;;)
      {
        this.a.e();
        return;
        QMLog.e("MiniAppInfoLoadTask", "getAppInfoByLink  onCmdListener retCode= " + l + " appid=" + ((MiniAppInfo)localObject).appId);
      }
    }
    bgyg.a(bgvi.a(this.a), "1", null, "load_fail", "shortcut_request_fail");
    bgxl.a("2launch_fail", "shotcut_request_fail", null, bgvi.a(this.a));
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvk
 * JD-Core Version:    0.7.0.1
 */