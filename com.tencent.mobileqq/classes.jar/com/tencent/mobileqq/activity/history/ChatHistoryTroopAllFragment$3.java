package com.tencent.mobileqq.activity.history;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryTroopAllFragment$3
  implements Runnable
{
  ChatHistoryTroopAllFragment$3(ChatHistoryTroopAllFragment paramChatHistoryTroopAllFragment) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.this$0.v.getMessageFacade().e(this.this$0.s, 1, this.this$0.y);
    if (localMessageRecord != null)
    {
      List localList = this.this$0.v.getMessageFacade().b(this.this$0.s, 1, localMessageRecord.shmsgseq, 20);
      localList.add(0, localMessageRecord);
      ThreadManager.getUIHandler().post(new ChatHistoryTroopAllFragment.3.1(this, localList));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("chatHistory.troop.msgList", 2, "msg not found, fallback to loadData");
    }
    this.this$0.w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment.3
 * JD-Core Version:    0.7.0.1
 */