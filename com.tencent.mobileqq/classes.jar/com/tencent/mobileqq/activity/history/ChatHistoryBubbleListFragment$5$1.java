package com.tencent.mobileqq.activity.history;

import ajrb;
import ancb;
import azil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.qphone.base.util.QLog;

public class ChatHistoryBubbleListFragment$5$1
  implements Runnable
{
  public ChatHistoryBubbleListFragment$5$1(ajrb paramajrb) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "do delete uniseq=" + this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq + ",id=" + this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getId());
    }
    azil localazil = (azil)this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment.a.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
    if (localazil != null) {
      localazil.a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage, false);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment.a.getMessageFacade().removeMsgByMessageRecord(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage, true);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForApollo)) {
      ancb.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBubbleListFragment.a, "chat_history_start_del_msg");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.5.1
 * JD-Core Version:    0.7.0.1
 */