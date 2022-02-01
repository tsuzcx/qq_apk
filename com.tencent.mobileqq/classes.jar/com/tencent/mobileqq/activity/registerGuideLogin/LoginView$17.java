package com.tencent.mobileqq.activity.registerGuideLogin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class LoginView$17
  implements Animator.AnimatorListener
{
  LoginView$17(LoginView paramLoginView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    LoginView.c(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    LoginView.a(this.a, LoginView.b(this.a), LoginView.d(this.a), LoginView.f(this.a), LoginView.h(this.a), 1.0F);
    if (this.a.a != null) {
      this.a.a.e();
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