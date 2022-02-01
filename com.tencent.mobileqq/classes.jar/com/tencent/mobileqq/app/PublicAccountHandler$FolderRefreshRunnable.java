package com.tencent.mobileqq.app;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import mqq.util.WeakReference;

class PublicAccountHandler$FolderRefreshRunnable
  implements Runnable
{
  private final WeakReference<QQAppInterface> a;
  private final WeakReference<PublicAccountDataManager> b;
  
  public PublicAccountHandler$FolderRefreshRunnable(QQAppInterface paramQQAppInterface, PublicAccountDataManager paramPublicAccountDataManager)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramPublicAccountDataManager);
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.a.get();
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.b.get();
    if ((localObject != null) && (localPublicAccountDataManager != null))
    {
      TroopBarAssistantManager.a().a((QQAppInterface)localObject, localPublicAccountDataManager.a());
      ServiceAccountFolderManager.a().c((QQAppInterface)localObject);
      TroopBarAssistantManager.a().g((QQAppInterface)localObject);
      localObject = ReadInJoyLogicEngine.a();
      if (localObject != null) {
        ((ReadInJoyLogicEngine)localObject).e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.FolderRefreshRunnable
 * JD-Core Version:    0.7.0.1
 */