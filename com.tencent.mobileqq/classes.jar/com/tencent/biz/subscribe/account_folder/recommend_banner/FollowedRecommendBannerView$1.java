package com.tencent.biz.subscribe.account_folder.recommend_banner;

import com.tencent.biz.videostory.support.VSReporter;
import java.util.List;

class FollowedRecommendBannerView$1
  implements IRecommendBannerFlowListener
{
  FollowedRecommendBannerView$1(FollowedRecommendBannerView paramFollowedRecommendBannerView) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && ((FollowedRecommendBannerView.a(this.a) == null) || (FollowedRecommendBannerView.a(this.a).a() == null) || (paramInt >= FollowedRecommendBannerView.a(this.a).a().size()))) {
      return;
    }
    VSReporter.a(FollowedRecommendBannerView.a(this.a), "auth_person", "reco_follow", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView.1
 * JD-Core Version:    0.7.0.1
 */