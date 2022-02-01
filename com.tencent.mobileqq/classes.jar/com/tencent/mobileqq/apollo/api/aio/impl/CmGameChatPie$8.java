package com.tencent.mobileqq.apollo.api.aio.impl;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler;
import com.tencent.mobileqq.app.QQAppInterface;

class CmGameChatPie$8
  implements Runnable
{
  CmGameChatPie$8(CmGameChatPie paramCmGameChatPie) {}
  
  public void run()
  {
    ((IApolloManagerService)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getGameTempMsgHandler().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.8
 * JD-Core Version:    0.7.0.1
 */