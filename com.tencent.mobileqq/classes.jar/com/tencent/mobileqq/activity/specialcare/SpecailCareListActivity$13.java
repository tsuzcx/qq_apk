package com.tencent.mobileqq.activity.specialcare;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class SpecailCareListActivity$13
  implements Animation.AnimationListener
{
  SpecailCareListActivity$13(SpecailCareListActivity paramSpecailCareListActivity, SpecailCareListActivity.ViewHolder paramViewHolder, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolder.a.clearAnimation();
    paramAnimation = new RelativeLayout.LayoutParams(-2, -2);
    paramAnimation.addRule(10);
    paramAnimation.addRule(1, 2131368343);
    paramAnimation.setMargins(0, (int)(SpecailCareListActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) * 22.0F), (int)(SpecailCareListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) * 23.0F + this.jdField_a_of_type_Int), 0);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolder.a.setLayoutParams(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.13
 * JD-Core Version:    0.7.0.1
 */