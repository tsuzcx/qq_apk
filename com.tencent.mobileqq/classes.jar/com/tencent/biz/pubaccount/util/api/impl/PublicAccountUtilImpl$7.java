package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
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
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;

class PublicAccountUtilImpl$7
  extends NewPublicAccountObserver.ResponseResultListener
{
  PublicAccountUtilImpl$7(PublicAccountUtilImpl paramPublicAccountUtilImpl, Object paramObject, QQAppInterface paramQQAppInterface, String paramString, PublicAccountObserver paramPublicAccountObserver, boolean paramBoolean, Context paramContext) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      paramObject = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
      if (paramObject != null) {
        paramObject.a(this.jdField_a_of_type_JavaLangObject);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(102, true, this.jdField_a_of_type_JavaLangString);
      }
      return;
      paramObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      paramObject.b(this.jdField_a_of_type_JavaLangString);
      paramObject.a(this.jdField_a_of_type_JavaLangString);
      StructLongMessageDownloadProcessor.deleteTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, 1008);
      TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.a());
      ServiceAccountFolderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      paramObject = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      if (paramObject != null) {
        paramObject.a(this.jdField_a_of_type_JavaLangString, "unfollow");
      }
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Boolean) {
      PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695222);
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.7
 * JD-Core Version:    0.7.0.1
 */