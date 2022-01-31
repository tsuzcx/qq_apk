package com.tencent.mobileqq.activity.aio.rebuild;

import aecb;
import aecn;
import aimk;
import aimn;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;

public class CmGameChatPie$ChatPieMsgListener$10
  implements Runnable
{
  public CmGameChatPie$ChatPieMsgListener$10(aecn paramaecn, boolean paramBoolean, aecb paramaecb, int paramInt, long paramLong) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean) {
      if (aecb.a(this.jdField_a_of_type_Aecb) != null) {
        aecb.a(this.jdField_a_of_type_Aecb).dismiss();
      }
    }
    while (this.jdField_a_of_type_Aecb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(this.jdField_a_of_type_Int, true, "message", this.jdField_a_of_type_Long, 1, 0, this.jdField_a_of_type_Aecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(this.jdField_a_of_type_Aecb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Aecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Aecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, aecb.c(this.jdField_a_of_type_Aecb), null);
    localStartCheckParam.mTempAIOUin = this.jdField_a_of_type_Aecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localStartCheckParam.mTempAIONickName = this.jdField_a_of_type_Aecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    localStartCheckParam.disableMinGame = true;
    ApolloGameUtil.a(this.jdField_a_of_type_Aecb.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localStartCheckParam);
    aecb.U = true;
    if (aecb.a(this.jdField_a_of_type_Aecb) != null) {
      aecb.a(this.jdField_a_of_type_Aecb).dismiss();
    }
    aimn.b(this.jdField_a_of_type_Aecb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aecb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.10
 * JD-Core Version:    0.7.0.1
 */