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
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      paramObject = (PublicAccountHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
      if (paramObject != null) {
        paramObject.onFollowPublicAccount(this.jdField_a_of_type_JavaLangObject);
      }
    }
    else
    {
      paramObject = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      paramObject.delPublicAccountInfo(this.jdField_a_of_type_JavaLangString);
      paramObject.delAccountDetailInfoCache(this.jdField_a_of_type_JavaLangString);
      StructLongMessageDownloadProcessor.deleteTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, 1008);
      TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)paramObject.getPublicAccountEqqInfoList());
      ServiceAccountFolderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      paramObject = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      if (paramObject != null) {
        paramObject.a(this.jdField_a_of_type_JavaLangString, "unfollow");
      }
    }
    paramObject = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver;
    if (paramObject != null) {
      paramObject.onUpdate(102, true, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    paramObject = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver;
    if (paramObject != null) {
      paramObject.onUpdate(102, false, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Boolean) {
      PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695217);
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.7
 * JD-Core Version:    0.7.0.1
 */