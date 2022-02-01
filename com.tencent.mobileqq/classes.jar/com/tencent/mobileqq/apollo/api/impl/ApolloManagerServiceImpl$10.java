package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.BaseChatPanelBarConfProcessor.C2CChatPanelBarConfProcessor;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.BaseChatPanelBarConfProcessor.GroupChatPanelBarConfProcessor;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.ChatPanelBarConfBean;
import com.tencent.mobileqq.apollo.handler.ApolloGetBattleGameListVasHandler;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;

class ApolloManagerServiceImpl$10
  implements Runnable
{
  ApolloManagerServiceImpl$10(ApolloManagerServiceImpl paramApolloManagerServiceImpl, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    int k = 0;
    int j = 0;
    try
    {
      int i;
      if (this.a.a == 0)
      {
        i = j;
        if (BaseChatPanelBarConfProcessor.C2CChatPanelBarConfProcessor.a().a())
        {
          i = j;
          if (!StudyModeManager.a()) {
            i = 1;
          }
        }
        if (i != 0) {
          ApolloGetBattleGameListVasHandler.a(ApolloManagerServiceImpl.access$300(this.this$0), 4018);
        }
      }
      else if (this.a.a == 1)
      {
        i = k;
        if (BaseChatPanelBarConfProcessor.GroupChatPanelBarConfProcessor.b().a())
        {
          i = k;
          if (!StudyModeManager.a()) {
            i = 1;
          }
        }
        if (i != 0)
        {
          ApolloGetBattleGameListVasHandler.a(ApolloManagerServiceImpl.access$300(this.this$0), 4019);
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("ApolloManager", 1, "[doAfterOpenAIO]  getBattleGameList error! exception = ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.10
 * JD-Core Version:    0.7.0.1
 */