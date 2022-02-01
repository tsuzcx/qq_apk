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
    if (!SixCombolEffectView.jdField_a_of_type_Boolean) {
      return;
    }
    SixCombolEffectView.jdField_a_of_type_Int = 4;
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("Animation 4 ,mAnimationState = ");
      paramAnimator.append(SixCombolEffectView.jdField_a_of_type_Int);
      QLog.w("SixCombolEffectView", 2, paramAnimator.toString());
    }
    if (SixCombolEffectView.a(this.a) != null)
    {
      paramAnimator = SixCombolEffectView.a(this.a);
      if (paramAnimator != null) {
        SixCombolEffectView.a(this.a).a(paramAnimator);
      }
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (SixCombolEffectView.a(this.a)) {
      return;
    }
    SixCombolEffectView.jdField_a_of_type_Int = 3;
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("Animation 3 ,mAnimationState = ");
      paramAnimator.append(SixCombolEffectView.jdField_a_of_type_Int);
      QLog.w("SixCombolEffectView", 2, paramAnimator.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.7
 * JD-Core Version:    0.7.0.1
 */