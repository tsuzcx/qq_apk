package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class AddFriendHelper$2
  implements Runnable
{
  AddFriendHelper$2(AddFriendHelper paramAddFriendHelper, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (ChatActivityUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
    {
      this.this$0.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AddFriendHelper.2.1(this));
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.this$0.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AddFriendHelper.2.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AddFriendHelper.2
 * JD-Core Version:    0.7.0.1
 */