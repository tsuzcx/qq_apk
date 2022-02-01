package com.tencent.mobileqq.addfriend.ui;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;

class AddFriendVerifyFragment$2$1
  implements Runnable
{
  AddFriendVerifyFragment$2$1(AddFriendVerifyFragment.2 param2, String paramString) {}
  
  public void run()
  {
    if (AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment$2.this$0).isShown())
    {
      TextView localTextView = AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment$2.this$0);
      String str;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment$2.jdField_a_of_type_JavaLangString)) {
        str = this.jdField_a_of_type_JavaLangString;
      } else {
        str = this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment$2.jdField_a_of_type_JavaLangString;
      }
      localTextView.setText(str);
      if (AppSetting.d)
      {
        localTextView = AddFriendVerifyFragment.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment$2.this$0);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment$2.jdField_a_of_type_JavaLangString)) {
          str = this.jdField_a_of_type_JavaLangString;
        } else {
          str = this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment$2.jdField_a_of_type_JavaLangString;
        }
        localTextView.setContentDescription(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.2.1
 * JD-Core Version:    0.7.0.1
 */