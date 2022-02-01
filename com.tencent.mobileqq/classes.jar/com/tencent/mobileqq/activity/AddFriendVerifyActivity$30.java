package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddFriendVerifyActivity$30
  implements View.OnClickListener
{
  AddFriendVerifyActivity$30(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.dismiss();
      AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, -1, this.jdField_a_of_type_JavaLangString);
      label58:
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a = null;
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.30
 * JD-Core Version:    0.7.0.1
 */