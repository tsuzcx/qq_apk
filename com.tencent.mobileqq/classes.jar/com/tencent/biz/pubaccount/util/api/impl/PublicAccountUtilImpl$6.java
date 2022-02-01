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
      paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver;
      if (paramBundle != null) {
        paramBundle.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Boolean) {
        PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695217);
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
          if (this.jdField_a_of_type_JavaLangObject != null)
          {
            paramBundle = (PublicAccountHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
            if (paramBundle != null) {
              paramBundle.onFollowPublicAccount(this.jdField_a_of_type_JavaLangObject);
            }
          }
          else
          {
            paramBundle = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
            paramBundle.delPublicAccountInfo(this.jdField_a_of_type_JavaLangString);
            paramBundle.delAccountDetailInfoCache(this.jdField_a_of_type_JavaLangString);
            StructLongMessageDownloadProcessor.deleteTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, 1008);
            TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)paramBundle.getPublicAccountEqqInfoList());
            ServiceAccountFolderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
            paramBundle = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
            if (paramBundle != null) {
              paramBundle.a(this.jdField_a_of_type_JavaLangString, "unfollow");
            }
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver == null) {
            break label481;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.onUpdate(102, true, this.jdField_a_of_type_JavaLangString);
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label481;
        }
        PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695217);
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label481;
      }
      PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695217);
      return;
    }
    catch (Exception paramBundle)
    {
      label443:
      label481:
      break label443;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695217);
      return;
      paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver;
      if (paramBundle != null) {
        paramBundle.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Boolean) {
        PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695217);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.6
 * JD-Core Version:    0.7.0.1
 */