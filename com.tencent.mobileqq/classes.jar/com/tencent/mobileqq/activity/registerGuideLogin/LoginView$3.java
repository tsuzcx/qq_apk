package com.tencent.mobileqq.activity.registerGuideLogin;

import ahfi;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.widget.CustomSafeEditText;

public class LoginView$3
  implements Runnable
{
  LoginView$3(LoginView paramLoginView) {}
  
  public void run()
  {
    this.this$0.c.setVisibility(0);
    this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new ahfi(this));
    this.this$0.c.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.3
 * JD-Core Version:    0.7.0.1
 */