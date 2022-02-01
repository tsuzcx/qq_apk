package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import java.util.List;

class PublicAccountUtilImpl$7
  extends NewPublicAccountObserver.ResponseResultListener
{
  PublicAccountUtilImpl$7(PublicAccountUtilImpl paramPublicAccountUtilImpl, Object paramObject, QQAppInterface paramQQAppInterface, String paramString, IPublicAccountObserver paramIPublicAccountObserver, boolean paramBoolean, Context paramContext) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if (this.a != null)
    {
      paramObject = (PublicAccountHandlerImpl)this.b.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
      if (paramObject != null) {
        paramObject.onFollowPublicAccount(this.a);
      }
    }
    else
    {
      paramObject = (IPublicAccountDataManager)this.b.getRuntimeService(IPublicAccountDataManager.class, "all");
      paramObject.delPublicAccountInfo(this.c);
      paramObject.delAccountDetailInfoCache(this.c);
      StructLongMessageDownloadProcessor.deleteTask(this.b, this.c);
      this.b.getMessageFacade().c(this.c, 1008);
      TroopBarAssistantManager.a().a(this.b, (List)paramObject.getPublicAccountEqqInfoList());
      ServiceAccountFolderManager.a().c(this.b, this.c);
      paramObject = (EcShopAssistantManager)this.b.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      if (paramObject != null) {
        paramObject.a(this.c, "unfollow");
      }
    }
    paramObject = this.d;
    if (paramObject != null) {
      paramObject.onUpdate(102, true, this.c);
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    paramObject = this.d;
    if (paramObject != null) {
      paramObject.onUpdate(102, false, this.c);
    }
    if (this.e) {
      PublicAccountUtilImpl.access$300(this.f, 2131892951);
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.7
 * JD-Core Version:    0.7.0.1
 */