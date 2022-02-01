package com.tencent.mobileqq.activity.recent.specialcare;

import android.animation.Animator;
import android.view.View;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class CareNotificationBar$3$2
  extends D8SafeAnimatorListener
{
  CareNotificationBar$3$2(CareNotificationBar.3 param3) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.post(new CareNotificationBar.3.2.1(this));
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.3.2
 * JD-Core Version:    0.7.0.1
 */