package com.tencent.mobileqq.activity.aio.item;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;

class SixCombolEffectView$3
  extends D8SafeAnimatorListener
{
  SixCombolEffectView$3(SixCombolEffectView paramSixCombolEffectView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!SixCombolEffectView.jdField_a_of_type_Boolean) {
      return;
    }
    SixCombolEffectView.a(this.a).start();
    this.a.a();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (SixCombolEffectView.a(this.a)) {
      return;
    }
    SixCombolEffectView.jdField_a_of_type_Int = 1;
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("Animation 1 ,mAnimationState = ");
      paramAnimator.append(SixCombolEffectView.jdField_a_of_type_Int);
      QLog.w("SixCombolEffectView", 2, paramAnimator.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.3
 * JD-Core Version:    0.7.0.1
 */