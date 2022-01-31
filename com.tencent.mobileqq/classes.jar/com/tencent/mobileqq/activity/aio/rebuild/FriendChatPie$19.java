package com.tencent.mobileqq.activity.aio.rebuild;

import agld;
import ahgp;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class FriendChatPie$19
  implements Runnable
{
  public FriendChatPie$19(agld paramagld) {}
  
  public void run()
  {
    if (ahgp.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
    {
      agld.b(this.this$0, true);
      ahgp.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "", "", "0X8008072", "0X8008072", 0, 0, "", "", "", "");
      return;
    }
    agld.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.19
 * JD-Core Version:    0.7.0.1
 */