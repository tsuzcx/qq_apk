package com.tencent.mobileqq.activity.registerGuideLogin;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.widget.PastablePwdEditText;

class LoginView$5
  implements Runnable
{
  LoginView$5(LoginView paramLoginView) {}
  
  public void run()
  {
    this.this$0.m.setVisibility(0);
    this.this$0.p.clearFocus();
    this.this$0.h.clearFocus();
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new LoginView.5.1(this));
    this.this$0.m.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.5
 * JD-Core Version:    0.7.0.1
 */