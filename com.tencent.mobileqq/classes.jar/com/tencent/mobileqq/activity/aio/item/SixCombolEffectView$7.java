package com.tencent.mobileqq.activity.aio.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;

class SixCombolEffectView$7
  extends AnimatorListenerAdapter
{
  SixCombolEffectView$7(SixCombolEffectView paramSixCombolEffectView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (!SixCombolEffectView.i) {
      return;
    }
    SixCombolEffectView.j = 4;
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("Animation 4 ,mAnimationState = ");
      paramAnimator.append(SixCombolEffectView.j);
      QLog.w("SixCombolEffectView", 2, paramAnimator.toString());
    }
    if (SixCombolEffectView.d(this.a) != null)
    {
      paramAnimator = SixCombolEffectView.e(this.a);
      if (paramAnimator != null) {
        SixCombolEffectView.d(this.a).a(paramAnimator);
      }
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (SixCombolEffectView.a(this.a)) {
      return;
    }
    SixCombolEffectView.j = 3;
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("Animation 3 ,mAnimationState = ");
      paramAnimator.append(SixCombolEffectView.j);
      QLog.w("SixCombolEffectView", 2, paramAnimator.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.7
 * JD-Core Version:    0.7.0.1
 */