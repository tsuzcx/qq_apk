package com.tencent.mobileqq.activity.aio.core;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;

class FriendChatPie$2
  implements Runnable
{
  FriendChatPie$2(FriendChatPie paramFriendChatPie) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin"), this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("uintype", 0)).time < FriendChatPie.a(this.this$0)) {
      VipUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "FriendAIO", "SilentCare", 0, 0, new String[] { this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin") });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.2
 * JD-Core Version:    0.7.0.1
 */