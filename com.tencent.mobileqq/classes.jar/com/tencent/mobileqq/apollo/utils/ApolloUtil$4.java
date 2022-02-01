package com.tencent.mobileqq.apollo.utils;

import amud;
import amul;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class ApolloUtil$4
  implements Runnable
{
  ApolloUtil$4(ChatMessage paramChatMessage, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (QQMessageFacade)((AppRuntime)localObject1).getManager(20);
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
          i = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForArkApp)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloUtil", 2, new Object[] { "[playShareMsgAction] share ark action actionId:", Integer.valueOf(i) });
          }
        } while (i <= 0);
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.saveExtInfoToExtStr("is_share_ark_message_action_played", "2");
        localObject2 = ((amul)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).a();
        if (localObject2 != null) {
          ((amud)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, i);
        }
      } while (localObject1 == null);
      localObject1 = (QQMessageFacade)((AppRuntime)localObject1).getManager(20);
    } while (localObject1 == null);
    ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloUtil.4
 * JD-Core Version:    0.7.0.1
 */