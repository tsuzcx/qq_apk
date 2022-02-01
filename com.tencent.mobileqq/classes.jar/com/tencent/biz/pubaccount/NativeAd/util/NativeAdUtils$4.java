package com.tencent.biz.pubaccount.NativeAd.util;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.observer.BusinessObserver;

final class NativeAdUtils$4
  implements BusinessObserver
{
  NativeAdUtils$4(AdvertisementInfo paramAdvertisementInfo, AdReportData paramAdReportData, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        return;
      }
      WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
      localWebSsoResponseBody.mergeFrom(paramBundle);
      if ((!localWebSsoResponseBody.ret.has()) || (localWebSsoResponseBody.ret.get() != 0)) {
        return;
      }
      paramBundle = "";
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mTitle;
      }
      ReadInJoyAdLog.a("REPORT_LINK", "new report success : title = " + paramBundle + " type = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.a());
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    ReadInJoyAdLog.a("REPORT_LINK", "new report fail : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo + " type = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.a());
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.4
 * JD-Core Version:    0.7.0.1
 */