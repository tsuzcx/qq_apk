package com.tencent.mobileqq.activity;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class LoginInfoActivity$19
  implements Animation.AnimationListener
{
  LoginInfoActivity$19(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    LoginInfoActivity.access$700(this.a).setVisibility(4);
    LoginInfoActivity.access$700(this.a).clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.19
 * JD-Core Version:    0.7.0.1
 */