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
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidViewView.getId() == 2131364705)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c();
        continue;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.AnimationEndClearListener
 * JD-Core Version:    0.7.0.1
 */