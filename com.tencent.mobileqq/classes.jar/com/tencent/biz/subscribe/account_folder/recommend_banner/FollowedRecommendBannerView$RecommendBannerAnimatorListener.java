package com.tencent.biz.subscribe.account_folder.recommend_banner;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class FollowedRecommendBannerView$RecommendBannerAnimatorListener
  implements ValueAnimator.AnimatorUpdateListener
{
  private View b;
  
  private FollowedRecommendBannerView$RecommendBannerAnimatorListener(FollowedRecommendBannerView paramFollowedRecommendBannerView, View paramView)
  {
    this.b = paramView;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
    localLayoutParams.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.b.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView.RecommendBannerAnimatorListener
 * JD-Core Version:    0.7.0.1
 */