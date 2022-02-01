package com.tencent.mobileqq.activity.phone;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class NewStyleCountryActivity$2
  implements Animation.AnimationListener
{
  NewStyleCountryActivity$2(NewStyleCountryActivity paramNewStyleCountryActivity, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.b.setAnimation(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.b.offsetTopAndBottom(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.b.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.NewStyleCountryActivity.2
 * JD-Core Version:    0.7.0.1
 */