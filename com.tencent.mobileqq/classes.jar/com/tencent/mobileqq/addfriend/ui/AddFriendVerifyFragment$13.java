package com.tencent.mobileqq.addfriend.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddFriendVerifyFragment$13
  implements View.OnClickListener
{
  AddFriendVerifyFragment$13(AddFriendVerifyFragment paramAddFriendVerifyFragment, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment) != null) && (AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment).isShowing()) && (AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment).getWindow() != null)) {}
    try
    {
      AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment).dismiss();
      AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment, -1, this.jdField_a_of_type_JavaLangString);
      label58:
      AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.13
 * JD-Core Version:    0.7.0.1
 */