package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;

class PublicAccountManagerImpl$15
  implements Runnable
{
  PublicAccountManagerImpl$15(PublicAccountManagerImpl paramPublicAccountManagerImpl, AppInterface paramAppInterface, String paramString) {}
  
  public void run()
  {
    ServiceAccountFolderManager.a().c((QQAppInterface)this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.15
 * JD-Core Version:    0.7.0.1
 */