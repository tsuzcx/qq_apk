package com.tencent.mobileqq.activity.registerGuideLogin;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class LoginView$16
  implements ValueAnimator.AnimatorUpdateListener
{
  LoginView$16(LoginView paramLoginView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    int i = (int)((LoginView.f(this.a) - LoginView.g(this.a)) * f + LoginView.g(this.a));
    int j = (int)((LoginView.h(this.a) - LoginView.i(this.a)) * f + LoginView.i(this.a));
    int k = (int)((LoginView.j(this.a) - LoginView.k(this.a)) * f + LoginView.k(this.a));
    int m = (int)((LoginView.l(this.a) - LoginView.m(this.a)) * f + LoginView.m(this.a));
    LoginView.a(this.a, i, j, k, m, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.16
 * JD-Core Version:    0.7.0.1
 */