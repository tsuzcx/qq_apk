package com.tencent.mobileqq.activity.aio.item;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class SixCombolEffectView$9
  extends D8SafeAnimatorListener
{
  SixCombolEffectView$9(SixCombolEffectView paramSixCombolEffectView, SixCombolEffectView.OneHeartTracker paramOneHeartTracker) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!SixCombolEffectView.a) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$OneHeartTracker.b.start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.9
 * JD-Core Version:    0.7.0.1
 */