package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import tku;
import tpp;

public final class ReadInJoyAdReportUtils$1
  implements Runnable
{
  public ReadInJoyAdReportUtils$1(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, Context paramContext, int paramInt3) {}
  
  public void run()
  {
    if (tpp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
    {
      tku.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_Int, this.b);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isSoftAd())
    {
      tku.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.c, this.jdField_a_of_type_Int, this.b);
      return;
    }
    tku.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.c, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils.1
 * JD-Core Version:    0.7.0.1
 */