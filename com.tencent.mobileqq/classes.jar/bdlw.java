import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment;
import com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment.2.1;
import com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment.2.2;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bdlw
  implements AsyncResult
{
  public bdlw(MiniAppInfoLoadingFragment paramMiniAppInfoLoadingFragment) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l;
    Object localObject;
    if ((paramBoolean) && (paramJSONObject != null))
    {
      l = paramJSONObject.optLong("retCode");
      localObject = paramJSONObject.optString("errMsg");
      bdnw.a("MiniAppInfoLoadingFragment", "getAppInfoByLink, retCode = " + l + ",errMsg = " + (String)localObject);
      if (l != 0L)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label652;
        }
        paramJSONObject = "请求失败";
        if (!bdyl.a()) {}
      }
    }
    label652:
    for (paramJSONObject = "请求失败" + ", retCode = " + l;; paramJSONObject = (JSONObject)localObject)
    {
      if (MiniAppInfoLoadingFragment.a(this.a) != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putLong("retCode", l);
        ((Bundle)localObject).putString("errMsg", paramJSONObject);
        MiniAppInfoLoadingFragment.a(this.a).send(1, (Bundle)localObject);
      }
      MiniAppInfoLoadingFragment.a(this.a, paramJSONObject);
      MiniAppInfoLoadingFragment.a(this.a);
      return;
      MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramJSONObject.opt("appInfo");
      String str = paramJSONObject.optString("shareTicket", "");
      if ((l == 0L) && (localMiniAppInfo != null) && (!TextUtils.isEmpty(localMiniAppInfo.appId)))
      {
        localMiniAppInfo.launchParam.jdField_a_of_type_JavaLangString = localMiniAppInfo.appId;
        localMiniAppInfo.launchParam.h = str;
        localMiniAppInfo.launchParam.e = localMiniAppInfo.extraData;
        if (!TextUtils.isEmpty(localMiniAppInfo.launchParam.h)) {
          localMiniAppInfo.launchParam.jdField_a_of_type_Int = 1044;
        }
        if (localMiniAppInfo.launchParam.jdField_a_of_type_JavaUtilMap == null) {
          localMiniAppInfo.launchParam.jdField_a_of_type_JavaUtilMap = new HashMap();
        }
        if (localMiniAppInfo.reportData != null) {
          localMiniAppInfo.launchParam.jdField_a_of_type_JavaUtilMap.putAll(localMiniAppInfo.reportData);
        }
        if (localMiniAppInfo.verType != 3) {
          localMiniAppInfo.forceReroad = 3;
        }
      }
      for (;;)
      {
        try
        {
          MiniAppInfoLoadingFragment.a(this.a, localMiniAppInfo);
          if (MiniAppInfoLoadingFragment.a(this.a) != null)
          {
            paramJSONObject = new Bundle();
            paramJSONObject.putLong("retCode", l);
            paramJSONObject.putString("errMsg", (String)localObject);
            MiniAppInfoLoadingFragment.a(this.a).send(0, paramJSONObject);
          }
          MiniAppInfoLoadingFragment.a(this.a);
          return;
        }
        catch (Throwable paramJSONObject)
        {
          bdnw.d("MiniAppInfoLoadingFragment", "MiniAppController.startApp exception ", paramJSONObject);
          continue;
        }
        if (localMiniAppInfo == null) {
          bdnw.d("MiniAppInfoLoadingFragment", "getAppInfoByLink  onCmdListener appinfo==null retCode= " + l);
        }
        for (;;)
        {
          bdew.c().post(new MiniAppInfoLoadingFragment.2.1(this, paramJSONObject));
          if (MiniAppInfoLoadingFragment.a(this.a) == null) {
            break;
          }
          paramJSONObject = new Bundle();
          paramJSONObject.putLong("retCode", l);
          paramJSONObject.putString("errMsg", (String)localObject);
          MiniAppInfoLoadingFragment.a(this.a).send(1, paramJSONObject);
          break;
          bdnw.d("MiniAppInfoLoadingFragment", "getAppInfoByLink  onCmdListener retCode= " + l + " appid=" + localMiniAppInfo.appId);
        }
        bdew.c().post(new MiniAppInfoLoadingFragment.2.2(this, paramJSONObject));
        if (MiniAppInfoLoadingFragment.a(this.a) != null)
        {
          localObject = new Bundle();
          if (paramJSONObject != null)
          {
            ((Bundle)localObject).putLong("retCode", paramJSONObject.optLong("retCode"));
            ((Bundle)localObject).putString("errMsg", paramJSONObject.optString("errMsg"));
          }
          MiniAppInfoLoadingFragment.a(this.a).send(1, (Bundle)localObject);
        }
        bdnw.d("MiniAppInfoLoadingFragment", "GetAppInfoByLink failed. isSuc=" + paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdlw
 * JD-Core Version:    0.7.0.1
 */