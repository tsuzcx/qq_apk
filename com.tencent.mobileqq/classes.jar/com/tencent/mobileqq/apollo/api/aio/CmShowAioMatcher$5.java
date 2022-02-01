package com.tencent.mobileqq.apollo.api.aio;

import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;

class CmShowAioMatcher$5
  implements CmShowAioMatcher.AioSupported
{
  CmShowAioMatcher$5(CmShowAioMatcher paramCmShowAioMatcher) {}
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if ((localHotChatManager != null) && (localHotChatManager.b(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmShowAioMatcher", 2, "cmshow NOT support hot chat right now.");
      }
      return false;
    }
    if (((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).n(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmShowAioMatcher", 2, "cmshow NOT support isQidianPrivateTroop now.");
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher.5
 * JD-Core Version:    0.7.0.1
 */