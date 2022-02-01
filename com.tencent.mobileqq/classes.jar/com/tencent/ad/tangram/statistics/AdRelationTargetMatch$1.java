package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.device.AdDeviceInfo;
import com.tencent.ad.tangram.device.AdDeviceInfo.Params;
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
    try
    {
      Object localObject = new AdDeviceInfo.Params();
      ((AdDeviceInfo.Params)localObject).businessIdForAidTicketAndTaidTicket = "d61533";
      AdDeviceInfo.Result localResult = AdDeviceInfo.INSTANCE.create((Context)this.val$context.get(), (AdDeviceInfo.Params)localObject);
      if ((localResult != null) && (localResult.deviceInfo != null))
      {
        localObject = null;
        if (localResult.deviceInfo.muid_type == 1) {
          localObject = "imei";
        } else if (localResult.deviceInfo.muid_type == 3) {
          localObject = "mac";
        }
        JSONObject localJSONObject = new JSONObject();
        boolean bool = TextUtils.isEmpty(localResult.deviceInfo.muid);
        if ((!bool) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          localJSONObject.put("muidtype", localObject);
          localJSONObject.put("muid", localResult.deviceInfo.muid);
        }
        localJSONObject.put("muidtype", localObject);
        localJSONObject.put("muid", localResult.deviceInfo.muid);
        localJSONObject.put("package_name", this.val$ad.getAppPackageName());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        ((StringBuilder)localObject).append("");
        localJSONObject.put("timestamp", ((StringBuilder)localObject).toString());
        localJSONObject.put("install_status", this.val$installStatus);
        localJSONObject.put("od", localResult.deviceInfo.aid_ticket);
        localJSONObject.put("td", localResult.deviceInfo.taid_ticket);
        d.reportMsg(this.val$context, this.val$ad, 1006, localJSONObject);
        return;
      }
      AdLog.e("AdRelationTargetMatch", "report failed. getDeviceInfo null");
      return;
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("AdRelationTargetMatch", "report failed", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.AdRelationTargetMatch.1
 * JD-Core Version:    0.7.0.1
 */