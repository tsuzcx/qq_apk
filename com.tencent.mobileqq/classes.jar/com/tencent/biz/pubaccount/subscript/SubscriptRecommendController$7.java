package com.tencent.biz.pubaccount.subscript;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SubscriptRecommendController$7
  implements Animation.AnimationListener
{
  SubscriptRecommendController$7(SubscriptRecommendController paramSubscriptRecommendController) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a;
    paramAnimation.a(SubscriptRecommendController.a(paramAnimation));
    this.a.c();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.7
 * JD-Core Version:    0.7.0.1
 */