package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import mqq.util.WeakReference;

class PublicAccountHandlerImpl$FolderRefreshRunnable
  implements Runnable
{
  private final WeakReference<QQAppInterface> a;
  private final WeakReference<PublicAccountDataManagerImpl> b;
  
  public PublicAccountHandlerImpl$FolderRefreshRunnable(QQAppInterface paramQQAppInterface, PublicAccountDataManagerImpl paramPublicAccountDataManagerImpl)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramPublicAccountDataManagerImpl);
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.a.get();
    PublicAccountDataManagerImpl localPublicAccountDataManagerImpl = (PublicAccountDataManagerImpl)this.b.get();
    if ((localObject != null) && (localPublicAccountDataManagerImpl != null))
    {
      TroopBarAssistantManager.a().a((QQAppInterface)localObject, (List)localPublicAccountDataManagerImpl.getPublicAccountEqqInfoList());
      ServiceAccountFolderManager.a().c((QQAppInterface)localObject);
      TroopBarAssistantManager.a().g((QQAppInterface)localObject);
      localObject = ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine();
      if (localObject != null) {
        ((IReadInJoyLogicEngine)localObject).e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl.FolderRefreshRunnable
 * JD-Core Version:    0.7.0.1
 */