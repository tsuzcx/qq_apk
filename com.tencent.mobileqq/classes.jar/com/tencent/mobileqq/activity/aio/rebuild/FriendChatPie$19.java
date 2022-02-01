package com.tencent.mobileqq.activity.aio.rebuild;

import aijm;
import ajji;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class FriendChatPie$19
  implements Runnable
{
  public FriendChatPie$19(aijm paramaijm) {}
  
  public void run()
  {
    if (ajji.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
    {
      aijm.c(this.this$0, true);
      ajji.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "", "", "0X8008072", "0X8008072", 0, 0, "", "", "", "");
      return;
    }
    aijm.c(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.19
 * JD-Core Version:    0.7.0.1
 */