package com.tencent.ad.tangram.statistics;

import android.content.Context;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.device.AdDeviceInfo;
import com.tencent.ad.tangram.device.AdDeviceInfo.Result;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class AdRelationTargetMatch$1
  implements Runnable
{
  AdRelationTargetMatch$1(WeakReference paramWeakReference, Ad paramAd, String paramString) {}
  
  public void run()
  {
    AdDeviceInfo.Result localResult;
    try
    {
      localResult = AdDeviceInfo.INSTANCE.create((Context)this.val$context.get());
      if ((localResult == null) || (localResult.deviceInfo == null))
      {
        AdLog.e("AdRelationTargetMatch", "report failed. getDeviceInfo null");
        return;
      }
      if ((localResult.deviceInfo.muid == null) || (localResult.deviceInfo.muid_type == 0))
      {
        AdLog.i("AdRelationTargetMatch", "report stop. muid is null");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("AdRelationTargetMatch", "report failed", localThrowable);
      return;
    }
    String str = "imei";
    if (localResult.deviceInfo.muid_type == 3) {
      str = "mac";
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("muidtype", str);
    localJSONObject.put("muid", localResult.deviceInfo.muid);
    localJSONObject.put("package_name", this.val$ad.getAppPackageName());
    localJSONObject.put("timestamp", System.currentTimeMillis() + "");
    localJSONObject.put("install_status", this.val$installStatus);
    c.reportMsg(this.val$context, this.val$ad, 1006, localJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.AdRelationTargetMatch.1
 * JD-Core Version:    0.7.0.1
 */