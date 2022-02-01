package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;

class PPCLoginAuthHandler$1
  implements Runnable
{
  PPCLoginAuthHandler$1(PPCLoginAuthHandler paramPPCLoginAuthHandler) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.a.getEntityManagerFactory(this.this$0.a.getCurrentAccountUin()).createEntityManager();
    ExtensionInfo localExtensionInfo = (ExtensionInfo)localEntityManager.find(ExtensionInfo.class, this.this$0.a.getAccount());
    if (localExtensionInfo != null)
    {
      localExtensionInfo.commingRingId = 0L;
      localEntityManager.update(localExtensionInfo);
    }
    else
    {
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = this.this$0.a.getAccount();
      localEntityManager.persist(localExtensionInfo);
    }
    localEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PPCLoginAuthHandler.1
 * JD-Core Version:    0.7.0.1
 */