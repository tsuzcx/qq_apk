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
    if (!SixCombolEffectView.jdField_a_of_type_Boolean) {
      return;
    }
    SixCombolEffectView.b(this.a).start();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (SixCombolEffectView.a(this.a)) {
      return;
    }
    SixCombolEffectView.jdField_a_of_type_Int = 2;
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("Animation 2 ,mAnimationState = ");
      paramAnimator.append(SixCombolEffectView.jdField_a_of_type_Int);
      QLog.w("SixCombolEffectView", 2, paramAnimator.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.5
 * JD-Core Version:    0.7.0.1
 */