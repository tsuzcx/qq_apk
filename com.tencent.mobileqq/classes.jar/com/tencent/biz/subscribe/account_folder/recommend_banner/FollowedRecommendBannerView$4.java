package com.tencent.biz.subscribe.account_folder.recommend_banner;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class FollowedRecommendBannerView$4
  extends AnimatorListenerAdapter
{
  FollowedRecommendBannerView$4(FollowedRecommendBannerView paramFollowedRecommendBannerView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FollowedRecommendBannerView.a(this.a).notifyDataSetChanged();
    this.a.clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView.4
 * JD-Core Version:    0.7.0.1
 */