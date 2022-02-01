package com.tencent.mobileqq.activity.history;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryBubbleListFragment$2
  implements Runnable
{
  ChatHistoryBubbleListFragment$2(ChatHistoryBubbleListFragment paramChatHistoryBubbleListFragment) {}
  
  public void run()
  {
    Object localObject;
    if (this.this$0.a == 1) {
      localObject = this.this$0.c;
    } else {
      localObject = this.this$0.b;
    }
    MessageRecord localMessageRecord = this.this$0.f.getMessageFacade().e((String)localObject, this.this$0.a, this.this$0.i);
    if (localMessageRecord != null)
    {
      localObject = this.this$0.f.getMessageFacade().b((String)localObject, this.this$0.a, localMessageRecord.shmsgseq, 20);
      ((List)localObject).add(0, localMessageRecord);
      ThreadManager.getUIHandler().post(new ChatHistoryBubbleListFragment.2.1(this, (List)localObject));
      return;
    }
    TroopTechReportUtils.a("chat_history", "target_404", String.valueOf(this.this$0.i), String.valueOf(this.this$0.m), "", "");
    if (QLog.isColorLevel()) {
      QLog.e("chatHistory.troop.msgList", 2, "msg not found, fallback to loadData");
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.2
 * JD-Core Version:    0.7.0.1
 */