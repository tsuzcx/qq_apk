package com.tencent.mobileqq.activity;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class BaseChatPie$11
  implements Runnable
{
  BaseChatPie$11(BaseChatPie paramBaseChatPie, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (ChatActivityUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e)) {
      this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new BaseChatPie.11.1(this));
    }
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new BaseChatPie.11.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.11
 * JD-Core Version:    0.7.0.1
 */