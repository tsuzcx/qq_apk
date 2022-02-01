package com.tencent.mobileqq.activity.aio.item;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;

class SixCombolEffectView$9
  implements Animator.AnimatorListener
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.9
 * JD-Core Version:    0.7.0.1
 */