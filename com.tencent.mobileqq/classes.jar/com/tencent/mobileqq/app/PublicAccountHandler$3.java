package com.tencent.mobileqq.app;

import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;

class PublicAccountHandler$3
  implements Runnable
{
  PublicAccountHandler$3(PublicAccountHandler paramPublicAccountHandler) {}
  
  public void run()
  {
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)PublicAccountHandler.a(this.this$0).getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (localEcShopAssistantManager != null) {
      localEcShopAssistantManager.a(null, "FollowList");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.3
 * JD-Core Version:    0.7.0.1
 */