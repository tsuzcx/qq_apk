package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;

class HotChatPie$9
  implements Runnable
{
  HotChatPie$9(HotChatPie paramHotChatPie) {}
  
  public void run()
  {
    ((HotChatHandler)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.9
 * JD-Core Version:    0.7.0.1
 */