package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import android.os.Bundle;
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
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.observer.BusinessObserver;

class PublicAccountUtilImpl$6
  implements BusinessObserver
{
  PublicAccountUtilImpl$6(PublicAccountUtilImpl paramPublicAccountUtilImpl, IPublicAccountObserver paramIPublicAccountObserver, String paramString, boolean paramBoolean, Context paramContext, Object paramObject, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("success:");
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
      QLog.d("PublicAccountUtil", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean)
    {
      paramBundle = this.a;
      if (paramBundle != null) {
        paramBundle.onUpdate(102, false, this.b);
      }
      if (this.c) {
        PublicAccountUtilImpl.access$300(this.d, 2131892951);
      }
    }
    else if (!paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        localObject = new mobileqq_mp.UnFollowResponse();
        ((mobileqq_mp.UnFollowResponse)localObject).mergeFrom(paramBundle);
        if (((mobileqq_mp.RetInfo)((mobileqq_mp.UnFollowResponse)localObject).ret_info.get()).ret_code.get() == 0)
        {
          if (this.e != null)
          {
            paramBundle = (PublicAccountHandlerImpl)this.f.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
            if (paramBundle != null) {
              paramBundle.onFollowPublicAccount(this.e);
            }
          }
          else
          {
            paramBundle = (IPublicAccountDataManager)this.f.getRuntimeService(IPublicAccountDataManager.class, "all");
            paramBundle.delPublicAccountInfo(this.b);
            paramBundle.delAccountDetailInfoCache(this.b);
            StructLongMessageDownloadProcessor.deleteTask(this.f, this.b);
            this.f.getMessageFacade().c(this.b, 1008);
            TroopBarAssistantManager.a().a(this.f, (List)paramBundle.getPublicAccountEqqInfoList());
            ServiceAccountFolderManager.a().c(this.f, this.b);
            paramBundle = (EcShopAssistantManager)this.f.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
            if (paramBundle != null) {
              paramBundle.a(this.b, "unfollow");
            }
          }
          if (this.a == null) {
            break label481;
          }
          this.a.onUpdate(102, true, this.b);
          return;
        }
        if (this.a != null) {
          this.a.onUpdate(102, false, this.b);
        }
        if (!this.c) {
          break label481;
        }
        PublicAccountUtilImpl.access$300(this.d, 2131892951);
        return;
      }
      if (this.a != null) {
        this.a.onUpdate(102, false, this.b);
      }
      if (!this.c) {
        break label481;
      }
      PublicAccountUtilImpl.access$300(this.d, 2131892951);
      return;
    }
    catch (Exception paramBundle)
    {
      label443:
      label481:
      break label443;
    }
    if (this.a != null) {
      this.a.onUpdate(102, false, this.b);
    }
    if (this.c)
    {
      PublicAccountUtilImpl.access$300(this.d, 2131892951);
      return;
      paramBundle = this.a;
      if (paramBundle != null) {
        paramBundle.onUpdate(102, false, this.b);
      }
      if (this.c) {
        PublicAccountUtilImpl.access$300(this.d, 2131892951);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.6
 * JD-Core Version:    0.7.0.1
 */