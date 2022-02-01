package com.tencent.mobileqq.activity;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;

class LoginInfoActivity$22
  implements Animation.AnimationListener
{
  LoginInfoActivity$22(LoginInfoActivity paramLoginInfoActivity, boolean paramBoolean, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    LoginInfoActivity.access$4200(this.c).setVisibility(4);
    LoginInfoActivity.access$700(this.c).clearAnimation();
    LoginInfoActivity.access$4300(this.c, this.a, this.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.22
 * JD-Core Version:    0.7.0.1
 */