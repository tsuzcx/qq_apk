package com.tencent.mobileqq.apollo.api.aio.impl;

import com.tencent.mobileqq.apollo.lightGame.CmGamePlayAgainDialog;

class CmGameChatPie$ChatPieMsgListener$8
  implements Runnable
{
  CmGameChatPie$ChatPieMsgListener$8(CmGameChatPie.ChatPieMsgListener paramChatPieMsgListener, CmGameChatPie paramCmGameChatPie, int paramInt, long paramLong, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
    if (CmGameChatPie.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie) != null) {
      CmGameChatPie.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.ChatPieMsgListener.8
 * JD-Core Version:    0.7.0.1
 */