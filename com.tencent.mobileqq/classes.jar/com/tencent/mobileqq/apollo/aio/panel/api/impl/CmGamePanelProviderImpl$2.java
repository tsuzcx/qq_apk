package com.tencent.mobileqq.apollo.aio.panel.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class CmGamePanelProviderImpl$2
  extends ApolloExtensionObserver
{
  CmGamePanelProviderImpl$2(CmGamePanelProviderImpl paramCmGamePanelProviderImpl) {}
  
  protected void a(int paramInt, List<ApolloBattleGameInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onGetApolloBattleGameList] ");
    localStringBuilder.append(paramInt);
    QLog.d("[cmshow]CmGamePanelProvider", 1, localStringBuilder.toString());
    if (paramInt == CmGamePanelProviderImpl.access$100(this.a))
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        ThreadManagerV2.getUIHandlerV2().post(new CmGamePanelProviderImpl.2.1(this, paramInt, paramList));
        return;
      }
      QLog.d("[cmshow]CmGamePanelProvider", 1, "[onGetApolloBattleGameList] battleGameInfoList is empty.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.api.impl.CmGamePanelProviderImpl.2
 * JD-Core Version:    0.7.0.1
 */