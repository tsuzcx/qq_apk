package com.tencent.mobileqq.activity;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class FriendProfileImageActivity$9
  implements Animation.AnimationListener
{
  FriendProfileImageActivity$9(FriendProfileImageActivity paramFriendProfileImageActivity, TextView paramTextView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.f) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.9
 * JD-Core Version:    0.7.0.1
 */