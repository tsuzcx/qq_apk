package com.tencent.mobileqq.activity.specialcare;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;

class SpecailCareListActivity$19
  implements Animation.AnimationListener
{
  SpecailCareListActivity$19(SpecailCareListActivity paramSpecailCareListActivity, SpecailCareListActivity.ViewHolder paramViewHolder) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolder.a.clearAnimation();
    paramAnimation = new RelativeLayout.LayoutParams(-2, -2);
    paramAnimation.addRule(1, 2131368343);
    paramAnimation.setMargins(0, (int)(SpecailCareListActivity.i(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) * 36.0F), (int)(SpecailCareListActivity.j(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) * 30.0F), 0);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolder.a.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolder.a.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.19
 * JD-Core Version:    0.7.0.1
 */