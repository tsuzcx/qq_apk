package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action;

import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.SoftAdReportData;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.qroute.QRoute;

final class ReadInJoyAdReportUtils$1
  implements Runnable
{
  ReadInJoyAdReportUtils$1(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, boolean paramBoolean1, Integer paramInteger, ReportAction paramReportAction, int paramInt3, boolean paramBoolean2, SoftAdReportData paramSoftAdReportData) {}
  
  public void run()
  {
    if (((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).isGameComponentType(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
    {
      ReadInJoyAdReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangInteger, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportAction);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isSoftAd())
    {
      ReadInJoyAdReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.c, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangInteger, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportAction, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentSoftAdReportData);
      return;
    }
    ReadInJoyAdReportUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.c, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangInteger, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportAction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils.1
 * JD-Core Version:    0.7.0.1
 */