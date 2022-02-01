package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

class DiscussionMemberActivity$1
  implements Animation.AnimationListener
{
  DiscussionMemberActivity$1(DiscussionMemberActivity paramDiscussionMemberActivity, TranslateAnimation paramTranslateAnimation1, Dialog paramDialog, TranslateAnimation paramTranslateAnimation2, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation)
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.setAnimation(null);
      DiscussionMemberActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity).setVisibility(8);
      return;
    }
    if (paramAnimation == this.b)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.setAnimation(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.offsetTopAndBottom(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.requestLayout();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity.1
 * JD-Core Version:    0.7.0.1
 */