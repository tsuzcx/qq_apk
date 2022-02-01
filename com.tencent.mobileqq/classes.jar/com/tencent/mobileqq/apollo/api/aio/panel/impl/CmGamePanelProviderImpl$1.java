package com.tencent.mobileqq.apollo.api.aio.panel.impl;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.handler.ApolloGetBattleGameListVasHandler;
import com.tencent.qphone.base.util.QLog;

class CmGamePanelProviderImpl$1
  implements Runnable
{
  CmGamePanelProviderImpl$1(CmGamePanelProviderImpl paramCmGamePanelProviderImpl) {}
  
  public void run()
  {
    try
    {
      ApolloGetBattleGameListVasHandler.a(CmGamePanelProviderImpl.access$000(this.this$0).a, CmGamePanelProviderImpl.access$100(this.this$0));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("CmGamePanelProvider", 1, "[createPanel]   getBattleGameList error! exception = ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.panel.impl.CmGamePanelProviderImpl.1
 * JD-Core Version:    0.7.0.1
 */