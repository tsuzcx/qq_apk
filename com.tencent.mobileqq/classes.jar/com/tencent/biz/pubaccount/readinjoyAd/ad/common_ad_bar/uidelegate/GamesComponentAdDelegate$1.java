package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyAdJumpUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.GameComponentReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GamesComponentAdDelegate$1
  implements View.OnClickListener
{
  GamesComponentAdDelegate$1(GamesComponentAdDelegate paramGamesComponentAdDelegate) {}
  
  public void onClick(View paramView)
  {
    long l = 3010204L;
    if (FastWeqAdUtils.e(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {}
    for (;;)
    {
      if (((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
      {
        Integer localInteger = ReadInJoyAdJumpUtils.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (Activity)this.a.jdField_a_of_type_AndroidContentContext);
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.adClickPos = AdClickPos.SoftAdComponent;
        GameComponentReport.a(localInteger, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, NativeAdUtils.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), GameComponentReport.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, l, 9L, null, "1"));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (FastWeqAdUtils.c(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        l = 3010304L;
      } else if (FastWeqAdUtils.f(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
        l = 3010404L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GamesComponentAdDelegate.1
 * JD-Core Version:    0.7.0.1
 */