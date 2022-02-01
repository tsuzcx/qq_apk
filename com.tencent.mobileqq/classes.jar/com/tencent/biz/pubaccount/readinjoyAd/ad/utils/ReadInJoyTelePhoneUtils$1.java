package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class ReadInJoyTelePhoneUtils$1
  implements Runnable
{
  ReadInJoyTelePhoneUtils$1(AdvertisementInfo paramAdvertisementInfo, Context paramContext) {}
  
  public void run()
  {
    try
    {
      Object localObject = BaseApplicationImpl.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.mAdRl);
      localStringBuilder.append("&acttype=9001");
      localObject = HttpUtil.openUrlForByte((Context)localObject, localStringBuilder.toString(), "GET", null, null);
      if (localObject == null)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ReadInJoyTelePhoneUtils", 1, "requestTelephoneInfoAndCall-> result bytes null");
        return;
      }
      localObject = new String((byte[])localObject);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("requestTelephoneInfoAndCall-> result = ");
        localStringBuilder.append((String)localObject);
        QLog.d("ReadInJoyTelePhoneUtils", 1, localStringBuilder.toString());
      }
      localObject = new JSONObject((String)localObject);
      if ((((JSONObject)localObject).optJSONObject("data") != null) && (!TextUtils.isEmpty(((JSONObject)localObject).optJSONObject("data").optString("fmcphone"))))
      {
        ReadInJoyTelePhoneUtils.a(this.b, ((JSONObject)localObject).optJSONObject("data").optString("fmcphone"), this.a);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyTelePhoneUtils.1
 * JD-Core Version:    0.7.0.1
 */