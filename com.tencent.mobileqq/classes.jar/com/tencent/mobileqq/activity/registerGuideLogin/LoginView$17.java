package com.tencent.mobileqq.activity.registerGuideLogin;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class LoginView$17
  extends D8SafeAnimatorListener
{
  LoginView$17(LoginView paramLoginView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    LoginView.c(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    LoginView.a(paramAnimator, LoginView.f(paramAnimator), LoginView.h(this.a), LoginView.j(this.a), LoginView.l(this.a), 1.0F);
    if (this.a.k != null) {
      this.a.k.e();
    }
    LoginView.c(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.17
 * JD-Core Version:    0.7.0.1
 */