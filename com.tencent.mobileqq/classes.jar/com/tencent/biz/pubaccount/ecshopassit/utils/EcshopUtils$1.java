package com.tencent.biz.pubaccount.ecshopassit.utils;

import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

final class EcshopUtils$1
  implements Runnable
{
  EcshopUtils$1(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    do
    {
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localObject1 == null) {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        int i;
        Object localObject3;
        QLog.e("Ecshop_EcshopUtils", 1, QLog.getStackTraceString(localThrowable));
        return;
      }
      finally
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade() == null)) {
          break label339;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_JavaLangString, 1008, false);
      }
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_JavaLangString, 1008);
      if (i != 0) {
        break;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade() == null));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_JavaLangString, 1008, false);
    return;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_JavaLangString, 1008);
    localObject3 = EcshopUtils.a((MessageRecord)localObject1);
    if ((localObject3 != null) && (((AbsStructMsgElement)localObject3).c != 100))
    {
      localObject1 = EcShopAssistantManager.a((MessageRecord)localObject1);
      if (localObject1 != null) {
        GdtPreLoader.a().a(new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject1));
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_JavaLangString, 1008, false);
      return;
      if ((localObject1 instanceof MessageForArkApp))
      {
        localObject3 = EcshopUtils.a((MessageRecord)localObject1);
        if ((localObject3 != null) && (String.valueOf(1).equals(((JSONObject)localObject3).optString("action_type"))))
        {
          localObject1 = EcShopAssistantManager.a((MessageRecord)localObject1);
          if (localObject1 != null) {
            GdtPreLoader.a().a(new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject1));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.utils.EcshopUtils.1
 * JD-Core Version:    0.7.0.1
 */