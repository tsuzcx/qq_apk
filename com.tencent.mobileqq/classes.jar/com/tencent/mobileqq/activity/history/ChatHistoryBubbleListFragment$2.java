package com.tencent.mobileqq.activity.history;

import bfui;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryBubbleListFragment$2
  implements Runnable
{
  ChatHistoryBubbleListFragment$2(ChatHistoryBubbleListFragment paramChatHistoryBubbleListFragment) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Int == 1) {}
    for (Object localObject = this.this$0.b;; localObject = this.this$0.jdField_a_of_type_JavaLangString)
    {
      MessageRecord localMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e((String)localObject, this.this$0.jdField_a_of_type_Int, this.this$0.jdField_c_of_type_Long);
      if (localMessageRecord == null) {
        break;
      }
      localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject, this.this$0.jdField_a_of_type_Int, localMessageRecord.shmsgseq, 20);
      ((List)localObject).add(0, localMessageRecord);
      ThreadManager.getUIHandler().post(new ChatHistoryBubbleListFragment.2.1(this, (List)localObject));
      return;
    }
    bfui.a("chat_history", "target_404", String.valueOf(this.this$0.jdField_c_of_type_Long), String.valueOf(this.this$0.jdField_c_of_type_Int), "", "");
    if (QLog.isColorLevel()) {
      QLog.e("chatHistory.troop.msgList", 2, "msg not found, fallback to loadData");
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.2
 * JD-Core Version:    0.7.0.1
 */