package com.tencent.mobileqq.apollo.aio.api.impl;

import com.tencent.mobileqq.apollo.aio.api.ICmShowAioMatcher.AioSupported;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class CmShowAioMatcherImpl$6
  implements ICmShowAioMatcher.AioSupported
{
  public boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    HotChatManager localHotChatManager = (HotChatManager)paramAppRuntime.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if ((localHotChatManager != null) && (localHotChatManager.b(paramString)))
    {
      QLog.i("[cmshow]CmShowAioMatcher", 1, "cmshow NOT support hot chat right now.");
      return false;
    }
    if (((IApolloManagerService)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).queryApolloSwitchSet("discuss") == 0)
    {
      QLog.i("[cmshow]CmShowAioMatcher", 1, "cmshow NOT support discuss aio.");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl.6
 * JD-Core Version:    0.7.0.1
 */