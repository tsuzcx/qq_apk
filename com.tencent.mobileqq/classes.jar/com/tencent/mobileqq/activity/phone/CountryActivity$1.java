package com.tencent.mobileqq.activity.phone;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class CountryActivity$1
  implements Animation.AnimationListener
{
  CountryActivity$1(CountryActivity paramCountryActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!this.a.isFinishing())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$SearchDialog.show();
      this.a.b.setAnimation(null);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.CountryActivity.1
 * JD-Core Version:    0.7.0.1
 */