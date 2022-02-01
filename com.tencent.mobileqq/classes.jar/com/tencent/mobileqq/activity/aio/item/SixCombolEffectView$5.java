package com.tencent.mobileqq.activity.aio.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.tencent.qphone.base.util.QLog;

class SixCombolEffectView$5
  extends AnimatorListenerAdapter
{
  SixCombolEffectView$5(SixCombolEffectView paramSixCombolEffectView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (!SixCombolEffectView.i) {
      return;
    }
    SixCombolEffectView.c(this.a).start();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (SixCombolEffectView.a(this.a)) {
      return;
    }
    SixCombolEffectView.j = 2;
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("Animation 2 ,mAnimationState = ");
      paramAnimator.append(SixCombolEffectView.j);
      QLog.w("SixCombolEffectView", 2, paramAnimator.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.5
 * JD-Core Version:    0.7.0.1
 */