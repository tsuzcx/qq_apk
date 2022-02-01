package com.tencent.mobileqq.apollo;

import amos;
import anch;
import anis;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class ChatPieApolloViewController$5
  implements Runnable
{
  public ChatPieApolloViewController$5(amos paramamos, int paramInt, BaseChatPie paramBaseChatPie, anch paramanch) {}
  
  public void run()
  {
    anis.a(this.jdField_a_of_type_Int, 101, 0, new Object[] { "parallel surfaceReady" });
    QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil start preLoad Js");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_Anch != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo != null))
    {
      this.jdField_a_of_type_Anch.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo);
      this.jdField_a_of_type_Anch.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController.5
 * JD-Core Version:    0.7.0.1
 */