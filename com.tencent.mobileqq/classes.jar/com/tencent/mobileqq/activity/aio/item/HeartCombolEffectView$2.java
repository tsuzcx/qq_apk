package com.tencent.mobileqq.activity.aio.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class HeartCombolEffectView$2
  extends AnimatorListenerAdapter
{
  HeartCombolEffectView$2(HeartCombolEffectView paramHeartCombolEffectView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    this.a.setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView.2
 * JD-Core Version:    0.7.0.1
 */