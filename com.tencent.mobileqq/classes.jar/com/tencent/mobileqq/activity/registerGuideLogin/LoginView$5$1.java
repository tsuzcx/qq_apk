package com.tencent.mobileqq.activity.registerGuideLogin;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;

class LoginView$5$1
  implements Animation.AnimationListener
{
  LoginView$5$1(LoginView.5 param5) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.this$0.m.setVisibility(0);
    this.a.this$0.m.clearAnimation();
    this.a.this$0.m.setAnimation(null);
    this.a.this$0.r.invalidate();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.5.1
 * JD-Core Version:    0.7.0.1
 */