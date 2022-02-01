package com.tencent.biz.pubaccount.ecshopassit.utils;

import acam;
import acmw;
import bdnu;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import onq;
import opg;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public final class EcshopUtils$1
  implements Runnable
{
  public EcshopUtils$1(QQAppInterface paramQQAppInterface, String paramString) {}
  
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
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMsgForMsgTab(this.jdField_a_of_type_JavaLangString, 1008);
    localObject3 = opg.a((MessageRecord)localObject1);
    if ((localObject3 != null) && (((bdnu)localObject3).c != 100))
    {
      localObject1 = onq.a((MessageRecord)localObject1);
      if (localObject1 != null) {
        acam.a().a(new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject1));
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_JavaLangString, 1008, false);
      return;
      if ((localObject1 instanceof MessageForArkApp))
      {
        localObject3 = opg.a((MessageRecord)localObject1);
        if ((localObject3 != null) && (String.valueOf(1).equals(((JSONObject)localObject3).optString("action_type"))))
        {
          localObject1 = onq.a((MessageRecord)localObject1);
          if (localObject1 != null) {
            acam.a().a(new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject1));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.utils.EcshopUtils.1
 * JD-Core Version:    0.7.0.1
 */