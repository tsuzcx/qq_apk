package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action;

import android.content.Context;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import uec;
import uki;

public final class ReadInJoyAdReportUtils$1
  implements Runnable
{
  public ReadInJoyAdReportUtils$1(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, boolean paramBoolean, JumpMode paramJumpMode, ReportAction paramReportAction, Context paramContext, int paramInt3) {}
  
  public void run()
  {
    if (uki.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
    {
      uec.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportJumpMode, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportAction);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isSoftAd())
    {
      uec.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.c, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportJumpMode, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportAction);
      return;
    }
    uec.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.c, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportJumpMode, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportAction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils.1
 * JD-Core Version:    0.7.0.1
 */