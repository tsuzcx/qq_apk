package com.tencent.mobileqq.activity.chathistory;

import bcpr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryBubbleListForTroopFragment$3
  implements Runnable
{
  ChatHistoryBubbleListForTroopFragment$3(ChatHistoryBubbleListForTroopFragment paramChatHistoryBubbleListForTroopFragment) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(this.this$0.jdField_a_of_type_JavaLangString, 1, this.this$0.c);
    if (localMessageRecord != null)
    {
      List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.this$0.jdField_a_of_type_JavaLangString, 1, localMessageRecord.shmsgseq, 20);
      localList.add(0, localMessageRecord);
      ThreadManager.getUIHandler().post(new ChatHistoryBubbleListForTroopFragment.3.1(this, localList));
      return;
    }
    bcpr.a("chat_history", "target_404", String.valueOf(this.this$0.c), String.valueOf(this.this$0.b), "", "");
    if (QLog.isColorLevel()) {
      QLog.e("chatHistory.troop.msgList", 2, "msg not found, fallback to loadData");
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment.3
 * JD-Core Version:    0.7.0.1
 */