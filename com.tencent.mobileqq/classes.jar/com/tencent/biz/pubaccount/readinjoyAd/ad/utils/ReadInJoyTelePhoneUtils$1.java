package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class ReadInJoyTelePhoneUtils$1
  implements Runnable
{
  public void run()
  {
    try
    {
      Object localObject = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdRl + "&acttype=9001", "GET", null, null);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyTelePhoneUtils", 1, "requestTelephoneInfoAndCall-> result bytes null");
        }
      }
      else
      {
        localObject = new String((byte[])localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyTelePhoneUtils", 1, "requestTelephoneInfoAndCall-> result = " + (String)localObject);
        }
        localObject = new JSONObject((String)localObject);
        if ((((JSONObject)localObject).optJSONObject("data") != null) && (!TextUtils.isEmpty(((JSONObject)localObject).optJSONObject("data").optString("fmcphone"))))
        {
          ReadInJoyTelePhoneUtils.a(this.jdField_a_of_type_AndroidContentContext, ((JSONObject)localObject).optJSONObject("data").optString("fmcphone"), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyTelePhoneUtils.1
 * JD-Core Version:    0.7.0.1
 */