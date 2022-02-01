package com.tencent.mobileqq.apollo.api.aio.panel.impl;

import android.os.Handler;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class CmGamePanelProviderImpl$2
  extends ApolloExtensionObserverImpl
{
  CmGamePanelProviderImpl$2(CmGamePanelProviderImpl paramCmGamePanelProviderImpl) {}
  
  public void a(int paramInt, List<ApolloBattleGameInfo> paramList)
  {
    QLog.d("CmGamePanelProvider", 1, "[onGetApolloBattleGameList] " + paramInt);
    if (paramInt == CmGamePanelProviderImpl.access$100(this.a))
    {
      if ((paramList != null) && (paramList.size() > 0)) {
        ThreadManagerV2.getUIHandlerV2().post(new CmGamePanelProviderImpl.2.1(this, paramInt, paramList));
      }
    }
    else {
      return;
    }
    QLog.d("CmGamePanelProvider", 1, "[onGetApolloBattleGameList] battleGameInfoList is empty.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.panel.impl.CmGamePanelProviderImpl.2
 * JD-Core Version:    0.7.0.1
 */