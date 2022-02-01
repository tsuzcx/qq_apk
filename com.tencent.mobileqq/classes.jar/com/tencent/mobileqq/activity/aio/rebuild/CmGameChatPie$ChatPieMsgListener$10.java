package com.tencent.mobileqq.activity.aio.rebuild;

import ahek;
import ahew;
import aluw;
import aluz;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;

public class CmGameChatPie$ChatPieMsgListener$10
  implements Runnable
{
  public CmGameChatPie$ChatPieMsgListener$10(ahew paramahew, boolean paramBoolean, ahek paramahek, int paramInt, long paramLong) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean) {
      if (ahek.a(this.jdField_a_of_type_Ahek) != null) {
        ahek.a(this.jdField_a_of_type_Ahek).dismiss();
      }
    }
    while (this.jdField_a_of_type_Ahek.app == null) {
      return;
    }
    CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(this.jdField_a_of_type_Int, true, "message", this.jdField_a_of_type_Long, 1, 0, this.jdField_a_of_type_Ahek.sessionInfo.curType, ApolloGameUtil.a(this.jdField_a_of_type_Ahek.app, this.jdField_a_of_type_Ahek.sessionInfo.curType, this.jdField_a_of_type_Ahek.sessionInfo.curFriendUin), this.jdField_a_of_type_Ahek.sessionInfo.curFriendUin, ahek.c(this.jdField_a_of_type_Ahek), null);
    localStartCheckParam.mTempAIOUin = this.jdField_a_of_type_Ahek.sessionInfo.curFriendUin;
    localStartCheckParam.mTempAIONickName = this.jdField_a_of_type_Ahek.sessionInfo.curFriendNick;
    localStartCheckParam.disableMinGame = true;
    ApolloGameUtil.a(this.jdField_a_of_type_Ahek.mActivity, localStartCheckParam);
    ahek.c = true;
    if (ahek.a(this.jdField_a_of_type_Ahek) != null) {
      ahek.a(this.jdField_a_of_type_Ahek).dismiss();
    }
    aluz.b(this.jdField_a_of_type_Ahek.app, this.jdField_a_of_type_Ahek.sessionInfo.curFriendUin, this.jdField_a_of_type_Ahek.sessionInfo.curType, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.10
 * JD-Core Version:    0.7.0.1
 */