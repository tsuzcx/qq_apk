package com.tencent.biz.subscribe.account_folder.top_pannel;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class TopPanelViewNew$RecommendBannerAnimatorListener
  implements ValueAnimator.AnimatorUpdateListener
{
  private View a;
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
    localLayoutParams.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelViewNew.RecommendBannerAnimatorListener
 * JD-Core Version:    0.7.0.1
 */