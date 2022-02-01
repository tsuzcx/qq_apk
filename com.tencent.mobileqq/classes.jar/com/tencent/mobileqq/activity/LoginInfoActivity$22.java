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
    LoginInfoActivity.access$4500(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).setVisibility(4);
    LoginInfoActivity.access$700(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).clearAnimation();
    LoginInfoActivity.access$4600(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.22
 * JD-Core Version:    0.7.0.1
 */