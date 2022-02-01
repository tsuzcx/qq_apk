package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.newfriend.CloneFriendPushHelper;
import com.tencent.mobileqq.statistics.ReportController;

class FriendChatPie$19
  implements Runnable
{
  FriendChatPie$19(FriendChatPie paramFriendChatPie) {}
  
  public void run()
  {
    if (CloneFriendPushHelper.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
    {
      FriendChatPie.b(this.this$0, true);
      CloneFriendPushHelper.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ReportController.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008072", "0X8008072", 0, 0, "", "", "", "");
      return;
    }
    FriendChatPie.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.19
 * JD-Core Version:    0.7.0.1
 */