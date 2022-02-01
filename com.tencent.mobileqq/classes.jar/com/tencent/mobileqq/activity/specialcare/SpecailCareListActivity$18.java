package com.tencent.mobileqq.activity.specialcare;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class SpecailCareListActivity$18
  implements Animation.AnimationListener
{
  SpecailCareListActivity$18(SpecailCareListActivity paramSpecailCareListActivity, SpecailCareListActivity.ViewHolder paramViewHolder, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolder.a.clearAnimation();
    paramAnimation = new RelativeLayout.LayoutParams(-2, -2);
    paramAnimation.addRule(1, 2131368343);
    paramAnimation.addRule(10);
    paramAnimation.setMargins(0, (int)(SpecailCareListActivity.h(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) * 10.0F), this.jdField_a_of_type_Int, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolder.a.setLayoutParams(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.18
 * JD-Core Version:    0.7.0.1
 */