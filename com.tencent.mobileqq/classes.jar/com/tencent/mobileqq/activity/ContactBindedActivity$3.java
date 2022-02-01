package com.tencent.mobileqq.activity;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

class ContactBindedActivity$3
  implements Animation.AnimationListener
{
  ContactBindedActivity$3(ContactBindedActivity paramContactBindedActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "doMultiAddTipsAnim end");
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "doMultiAddTipsAnim start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactBindedActivity.3
 * JD-Core Version:    0.7.0.1
 */