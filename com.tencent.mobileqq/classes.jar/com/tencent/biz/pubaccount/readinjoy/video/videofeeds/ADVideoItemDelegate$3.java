package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHardAdBarManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyVideoFeedsAdUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ADVideoItemDelegate$3
  implements View.OnClickListener
{
  ADVideoItemDelegate$3(ADVideoItemDelegate paramADVideoItemDelegate, VideoInfo paramVideoInfo) {}
  
  public void onClick(View paramView)
  {
    AdvertisementInfo localAdvertisementInfo = ReadInJoyVideoFeedsAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
    ReadInJoyAdUtils.a(localAdvertisementInfo, 2005, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemDelegate.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemDelegate.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a.a(ADVideoItemDelegate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemDelegate), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, localAdvertisementInfo, 2005);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemDelegate.3
 * JD-Core Version:    0.7.0.1
 */