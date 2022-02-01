package com.tencent.mobileqq.activity.chathistory;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryBubbleListForTroopFragment$6$1
  implements Runnable
{
  ChatHistoryBubbleListForTroopFragment$6$1(ChatHistoryBubbleListForTroopFragment.6 param6) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "do delete uniseq=" + this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq + ",id=" + this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getId());
    }
    QSlowTableManager localQSlowTableManager = (QSlowTableManager)this.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.a.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
    if (localQSlowTableManager != null) {
      localQSlowTableManager.a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage, false);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.a.getMessageFacade().a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage, true);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForApollo)) {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.a, "chat_history_start_del_msg");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment.6.1
 * JD-Core Version:    0.7.0.1
 */