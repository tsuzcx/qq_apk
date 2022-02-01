package com.tencent.mobileqq.app;

import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;

class PublicAccountHandler$2
  implements Runnable
{
  PublicAccountHandler$2(PublicAccountHandler paramPublicAccountHandler) {}
  
  public void run()
  {
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)PublicAccountHandler.a(this.this$0).getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (localEcShopAssistantManager != null) {
      localEcShopAssistantManager.a(null, "FollowList");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.2
 * JD-Core Version:    0.7.0.1
 */