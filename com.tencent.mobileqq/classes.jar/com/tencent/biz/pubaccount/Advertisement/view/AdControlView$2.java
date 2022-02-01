package com.tencent.biz.pubaccount.Advertisement.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class AdControlView$2
  extends AnimatorListenerAdapter
{
  AdControlView$2(AdControlView paramAdControlView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    this.a.b = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    paramAnimator = this.a;
    paramAnimator.b = false;
    paramAnimator.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.AdControlView.2
 * JD-Core Version:    0.7.0.1
 */