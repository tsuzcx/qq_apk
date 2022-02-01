package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AccountManageActivity$AnimationEndClearListener
  implements Animation.AnimationListener
{
  int jdField_a_of_type_Int = -1;
  View jdField_a_of_type_AndroidViewView;
  
  public AccountManageActivity$AnimationEndClearListener(AccountManageActivity paramAccountManageActivity, View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.jdField_a_of_type_AndroidViewView;
    if (paramAnimation == null) {
      return;
    }
    int i = this.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i == 2) {
        paramAnimation.setVisibility(8);
      }
    }
    else
    {
      paramAnimation.setVisibility(0);
      if (this.jdField_a_of_type_AndroidViewView.getId() == 2131364592) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c();
      }
    }
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.AnimationEndClearListener
 * JD-Core Version:    0.7.0.1
 */