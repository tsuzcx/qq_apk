package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHardAdBarManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyVideoFeedsAdUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsRecommendPresenter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.qroute.QRoute;

class ADVideoItemDelegate$3
  implements View.OnClickListener
{
  ADVideoItemDelegate$3(ADVideoItemDelegate paramADVideoItemDelegate, VideoInfo paramVideoInfo, VideoFeedsHardAdBarManager paramVideoFeedsHardAdBarManager) {}
  
  public void onClick(View paramView)
  {
    paramView = ReadInJoyVideoFeedsAdUtils.a(this.a.as);
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramView, 2005, this.c.b.x());
    this.b.a(ADVideoItemDelegate.a(this.c), this.a, paramView, 2005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemDelegate.3
 * JD-Core Version:    0.7.0.1
 */