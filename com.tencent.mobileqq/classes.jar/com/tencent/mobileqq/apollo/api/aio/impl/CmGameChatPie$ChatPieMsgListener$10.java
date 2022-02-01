package com.tencent.mobileqq.apollo.api.aio.impl;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.lightGame.CmGamePlayAgainDialog;
import com.tencent.mobileqq.apollo.lightGame.CmGameSessionUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;

class CmGameChatPie$ChatPieMsgListener$10
  implements Runnable
{
  CmGameChatPie$ChatPieMsgListener$10(CmGameChatPie.ChatPieMsgListener paramChatPieMsgListener, boolean paramBoolean, CmGameChatPie paramCmGameChatPie, int paramInt, long paramLong) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean) {
      if (CmGameChatPie.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie) != null) {
        CmGameChatPie.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).dismiss();
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(this.jdField_a_of_type_Int, true, "message", this.jdField_a_of_type_Long, 1, 0, this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, CmGameChatPie.c(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie), null);
    localStartCheckParam.mTempAIOUin = this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localStartCheckParam.mTempAIONickName = this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    localStartCheckParam.disableMinGame = true;
    ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localStartCheckParam);
    CmGameChatPie.O = true;
    if (CmGameChatPie.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie) != null) {
      CmGameChatPie.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie).dismiss();
    }
    CmGameSessionUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.ChatPieMsgListener.10
 * JD-Core Version:    0.7.0.1
 */