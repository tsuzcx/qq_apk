package com.tencent.mobileqq.activity.history;

import afyo;
import ajfa;
import aulz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.qphone.base.util.QLog;

public class ChatHistoryTroopAllFragment$6$1
  implements Runnable
{
  public ChatHistoryTroopAllFragment$6$1(afyo paramafyo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "do delete uniseq=" + this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq + ",id=" + this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getId());
    }
    aulz localaulz = (aulz)this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment.b.getManager(201);
    if (localaulz != null) {
      localaulz.a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage, false);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment.b.a().a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage, true);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForApollo)) {
      ajfa.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopAllFragment.b, "chat_history_start_del_msg");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment.6.1
 * JD-Core Version:    0.7.0.1
 */