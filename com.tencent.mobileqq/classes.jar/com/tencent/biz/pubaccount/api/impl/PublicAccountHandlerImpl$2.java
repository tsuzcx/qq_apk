package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class PublicAccountHandlerImpl$2
  implements Runnable
{
  PublicAccountHandlerImpl$2(PublicAccountHandlerImpl paramPublicAccountHandlerImpl) {}
  
  public void run()
  {
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)PublicAccountHandlerImpl.access$000(this.this$0).getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (localEcShopAssistantManager != null) {
      localEcShopAssistantManager.a(null, "FollowList");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl.2
 * JD-Core Version:    0.7.0.1
 */