package com.tencent.mobileqq.apollo.api.uitls.impl;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.script.SpriteBridge;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class ApolloUtilImpl$4
  implements Runnable
{
  ApolloUtilImpl$4(ApolloUtilImpl paramApolloUtilImpl, ChatMessage paramChatMessage, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (QQMessageFacade)((AppRuntime)localObject1).getManager(QQManagerFactory.MGR_MSG_FACADE);
      if (localObject2 != null) {
        ((QQMessageFacade)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extStr);
      }
    }
    if (this.jdField_a_of_type_Int != this.b - 1) {}
    do
    {
      do
      {
        int i;
        do
        {
          return;
          i = ApolloUtilImpl.getShareMsgActionId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForArkApp)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloUtil", 2, new Object[] { "[playShareMsgAction] share ark action actionId:", Integer.valueOf(i) });
          }
        } while (i <= 0);
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.saveExtInfoToExtStr("is_share_ark_message_action_played", "2");
        localObject2 = (SpriteBridge)((ISpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBridge();
        if (localObject2 != null) {
          ((SpriteBridge)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, i);
        }
      } while (localObject1 == null);
      localObject1 = (QQMessageFacade)((AppRuntime)localObject1).getManager(QQManagerFactory.MGR_MSG_FACADE);
    } while (localObject1 == null);
    ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl.4
 * JD-Core Version:    0.7.0.1
 */