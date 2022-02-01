package com.tencent.mobileqq.activity.recent.specialcare;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.view.View;

class CareNotificationBar$3$1
  implements Animator.AnimatorListener
{
  CareNotificationBar$3$1(CareNotificationBar.3 param3, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar$3.a.postDelayed(new CareNotificationBar.3.1.1(this), 300L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.3.1
 * JD-Core Version:    0.7.0.1
 */