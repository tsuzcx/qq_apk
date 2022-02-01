package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;

class LimitChatPie$15
  implements Runnable
{
  LimitChatPie$15(LimitChatPie paramLimitChatPie) {}
  
  public void run()
  {
    ExpandFriendData.setAdvertiseDate(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.15
 * JD-Core Version:    0.7.0.1
 */