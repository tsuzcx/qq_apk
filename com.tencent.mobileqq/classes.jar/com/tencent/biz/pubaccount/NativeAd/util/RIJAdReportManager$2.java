package com.tencent.biz.pubaccount.NativeAd.util;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.observer.BusinessObserver;

final class RIJAdReportManager$2
  implements BusinessObserver
{
  RIJAdReportManager$2(AdvertisementInfo paramAdvertisementInfo, AdReportData paramAdReportData, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        return;
      }
      localObject = new WebSsoBody.WebSsoResponseBody();
      ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
      if ((!((WebSsoBody.WebSsoResponseBody)localObject).ret.has()) || (((WebSsoBody.WebSsoResponseBody)localObject).ret.get() != 0)) {
        return;
      }
      paramBundle = "";
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mTitle;
      }
      localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new report success : title = ");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(" type = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.a());
      ((IRIJAdLogService)localObject).d("REPORT_LINK", localStringBuilder.toString());
      return;
    }
    catch (Exception paramBundle)
    {
      Object localObject;
      paramBundle.printStackTrace();
    }
    paramBundle = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("new report fail : ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    ((StringBuilder)localObject).append(" type = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdReportData.a());
    paramBundle.d("REPORT_LINK", ((StringBuilder)localObject).toString());
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.RIJAdReportManager.2
 * JD-Core Version:    0.7.0.1
 */