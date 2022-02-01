package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.script.SpriteBridge;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class ApolloUtilImpl$3
  implements Runnable
{
  ApolloUtilImpl$3(ApolloUtilImpl paramApolloUtilImpl, MessageRecord paramMessageRecord, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject1 != null)
    {
      localObject2 = (QQMessageFacade)((AppRuntime)localObject1).getManager(QQManagerFactory.MGR_MSG_FACADE);
      if (localObject2 != null) {
        ((QQMessageFacade)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extStr);
      }
    }
    if (this.jdField_a_of_type_Int != this.b - 1) {
      return;
    }
    int i = ApolloUtilImpl.getShareMsgActionId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForArkApp)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloUtil", 2, new Object[] { "[playShareMsgAction] share ark action actionId:", Integer.valueOf(i) });
    }
    if (i <= 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.saveExtInfoToExtStr("is_share_ark_message_action_played", "2");
    Object localObject2 = (SpriteBridge)((ISpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBridge();
    if (localObject2 != null) {
      ((SpriteBridge)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, i);
    }
    if (localObject1 != null)
    {
      localObject1 = (QQMessageFacade)((AppRuntime)localObject1).getManager(QQManagerFactory.MGR_MSG_FACADE);
      if (localObject1 != null) {
        ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extStr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl.3
 * JD-Core Version:    0.7.0.1
 */