package com.tencent.mobileqq.activity;

import acus;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

public class DiscussionMemberActivity$3$1
  implements Runnable
{
  public DiscussionMemberActivity$3$1(acus paramacus) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.offsetTopAndBottom(-this.a.jdField_a_of_type_Int);
    DiscussionMemberActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity).setVisibility(0);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.startAnimation(this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getWindow().peekDecorView().getWindowToken(), 0);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.removeObserver(this.a.jdField_a_of_type_Altm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity.3.1
 * JD-Core Version:    0.7.0.1
 */