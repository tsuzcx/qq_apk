package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.qphone.base.util.QLog;

class ChatPieApolloViewController$6
  implements Runnable
{
  ChatPieApolloViewController$6(ChatPieApolloViewController paramChatPieApolloViewController, int paramInt, BaseChatPie paramBaseChatPie, SpriteScriptManagerImpl paramSpriteScriptManagerImpl) {}
  
  public void run()
  {
    TraceReportUtil.a(this.jdField_a_of_type_Int, 101, 0, new Object[] { "parallel surfaceReady" });
    QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil start preLoad Js");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApiImplSpriteScriptManagerImpl != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiImplSpriteScriptManagerImpl.updateSessionInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a);
      this.jdField_a_of_type_ComTencentMobileqqApolloApiImplSpriteScriptManagerImpl.onSurfaceReady(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController.6
 * JD-Core Version:    0.7.0.1
 */