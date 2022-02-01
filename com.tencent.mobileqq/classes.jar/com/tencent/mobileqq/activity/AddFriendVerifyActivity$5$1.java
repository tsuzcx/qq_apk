package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;

class AddFriendVerifyActivity$5$1
  implements Runnable
{
  AddFriendVerifyActivity$5$1(AddFriendVerifyActivity.5 param5, String paramString) {}
  
  public void run()
  {
    if (AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$5.this$0).isShown())
    {
      TextView localTextView = AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$5.this$0);
      String str;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$5.jdField_a_of_type_JavaLangString)) {
        str = this.jdField_a_of_type_JavaLangString;
      } else {
        str = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$5.jdField_a_of_type_JavaLangString;
      }
      localTextView.setText(str);
      if (AppSetting.d)
      {
        localTextView = AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$5.this$0);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$5.jdField_a_of_type_JavaLangString)) {
          str = this.jdField_a_of_type_JavaLangString;
        } else {
          str = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$5.jdField_a_of_type_JavaLangString;
        }
        localTextView.setContentDescription(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.5.1
 * JD-Core Version:    0.7.0.1
 */