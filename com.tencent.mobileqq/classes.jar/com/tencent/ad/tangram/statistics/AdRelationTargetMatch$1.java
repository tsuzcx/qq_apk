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
    for (;;)
    {
      AdDeviceInfo.Result localResult;
      try
      {
        Object localObject = new AdDeviceInfo.Params();
        ((AdDeviceInfo.Params)localObject).businessIdForAidTicketAndTaidTicket = "d61533";
        localResult = AdDeviceInfo.INSTANCE.create((Context)this.val$context.get(), (AdDeviceInfo.Params)localObject);
        if ((localResult == null) || (localResult.deviceInfo == null))
        {
          AdLog.e("AdRelationTargetMatch", "report failed. getDeviceInfo null");
          return;
        }
        localObject = null;
        if (localResult.deviceInfo.muid_type == 1)
        {
          localObject = "imei";
          JSONObject localJSONObject = new JSONObject();
          if ((!TextUtils.isEmpty(localResult.deviceInfo.muid)) && (!TextUtils.isEmpty((CharSequence)localObject)))
          {
            localJSONObject.put("muidtype", localObject);
            localJSONObject.put("muid", localResult.deviceInfo.muid);
          }
          localJSONObject.put("muidtype", localObject);
          localJSONObject.put("muid", localResult.deviceInfo.muid);
          localJSONObject.put("package_name", this.val$ad.getAppPackageName());
          localJSONObject.put("timestamp", System.currentTimeMillis() + "");
          localJSONObject.put("install_status", this.val$installStatus);
          localJSONObject.put("od", localResult.deviceInfo.aid_ticket);
          localJSONObject.put("td", localResult.deviceInfo.taid_ticket);
          c.reportMsg(this.val$context, this.val$ad, 1006, localJSONObject);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        AdLog.e("AdRelationTargetMatch", "report failed", localThrowable);
        return;
      }
      if (localResult.deviceInfo.muid_type == 3) {
        String str = "mac";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.AdRelationTargetMatch.1
 * JD-Core Version:    0.7.0.1
 */