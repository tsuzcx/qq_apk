package com.tencent.biz.subscribe.account_folder.recommend_banner;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FollowedRecommendBannerView$2
  implements View.OnClickListener
{
  FollowedRecommendBannerView$2(FollowedRecommendBannerView paramFollowedRecommendBannerView) {}
  
  public void onClick(View paramView)
  {
    FollowedRecommendBannerView.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView.2
 * JD-Core Version:    0.7.0.1
 */