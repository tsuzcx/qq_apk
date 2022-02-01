package com.tencent.mobileqq.activity.aio.rebuild;

import ahzc;
import ahzo;
import amty;
import amub;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;

public class CmGameChatPie$ChatPieMsgListener$10
  implements Runnable
{
  public CmGameChatPie$ChatPieMsgListener$10(ahzo paramahzo, boolean paramBoolean, ahzc paramahzc, int paramInt, long paramLong) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean) {
      if (ahzc.a(this.jdField_a_of_type_Ahzc) != null) {
        ahzc.a(this.jdField_a_of_type_Ahzc).dismiss();
      }
    }
    while (this.jdField_a_of_type_Ahzc.app == null) {
      return;
    }
    CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(this.jdField_a_of_type_Int, true, "message", this.jdField_a_of_type_Long, 1, 0, this.jdField_a_of_type_Ahzc.sessionInfo.curType, ApolloGameUtil.a(this.jdField_a_of_type_Ahzc.app, this.jdField_a_of_type_Ahzc.sessionInfo.curType, this.jdField_a_of_type_Ahzc.sessionInfo.curFriendUin), this.jdField_a_of_type_Ahzc.sessionInfo.curFriendUin, ahzc.c(this.jdField_a_of_type_Ahzc), null);
    localStartCheckParam.mTempAIOUin = this.jdField_a_of_type_Ahzc.sessionInfo.curFriendUin;
    localStartCheckParam.mTempAIONickName = this.jdField_a_of_type_Ahzc.sessionInfo.curFriendNick;
    localStartCheckParam.disableMinGame = true;
    ApolloGameUtil.a(this.jdField_a_of_type_Ahzc.mActivity, localStartCheckParam);
    ahzc.c = true;
    if (ahzc.a(this.jdField_a_of_type_Ahzc) != null) {
      ahzc.a(this.jdField_a_of_type_Ahzc).dismiss();
    }
    amub.b(this.jdField_a_of_type_Ahzc.app, this.jdField_a_of_type_Ahzc.sessionInfo.curFriendUin, this.jdField_a_of_type_Ahzc.sessionInfo.curType, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.10
 * JD-Core Version:    0.7.0.1
 */