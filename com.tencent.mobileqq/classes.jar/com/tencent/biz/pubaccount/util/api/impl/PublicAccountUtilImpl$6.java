package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class PublicAccountUtilImpl$6
  implements BusinessObserver
{
  PublicAccountUtilImpl$6(PublicAccountUtilImpl paramPublicAccountUtilImpl, PublicAccountObserver paramPublicAccountObserver, String paramString, boolean paramBoolean, Context paramContext, Object paramObject, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Boolean) {
        PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695222);
      }
    }
    label221:
    label377:
    do
    {
      do
      {
        do
        {
          return;
          if (!paramBoolean) {
            break label415;
          }
          for (;;)
          {
            try
            {
              paramBundle = paramBundle.getByteArray("data");
              if (paramBundle == null) {
                break label377;
              }
              mobileqq_mp.UnFollowResponse localUnFollowResponse = new mobileqq_mp.UnFollowResponse();
              localUnFollowResponse.mergeFrom(paramBundle);
              if (((mobileqq_mp.RetInfo)localUnFollowResponse.ret_info.get()).ret_code.get() != 0) {
                break label339;
              }
              if (this.jdField_a_of_type_JavaLangObject == null) {
                break label221;
              }
              paramBundle = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
              if (paramBundle != null) {
                paramBundle.a(this.jdField_a_of_type_JavaLangObject);
              }
              if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(102, true, this.jdField_a_of_type_JavaLangString);
              return;
            }
            catch (Exception paramBundle)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
                this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
              }
            }
            if (!this.jdField_a_of_type_Boolean) {
              break;
            }
            PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695222);
            return;
            paramBundle = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
            paramBundle.b(this.jdField_a_of_type_JavaLangString);
            paramBundle.a(this.jdField_a_of_type_JavaLangString);
            StructLongMessageDownloadProcessor.deleteTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, 1008);
            TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle.a());
            ServiceAccountFolderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
            paramBundle = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
            if (paramBundle != null) {
              paramBundle.a(this.jdField_a_of_type_JavaLangString, "unfollow");
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
          }
        } while (!this.jdField_a_of_type_Boolean);
        PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695222);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
        }
      } while (!this.jdField_a_of_type_Boolean);
      PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695222);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
      }
    } while (!this.jdField_a_of_type_Boolean);
    label339:
    PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695222);
    label415:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.6
 * JD-Core Version:    0.7.0.1
 */