package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import mqq.os.MqqHandler;

class ChatHistory$8
  implements Runnable
{
  ChatHistory$8(ChatHistory paramChatHistory, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (this.a) {
      localStringBuilder = new StringBuilder();
    } else {
      localStringBuilder = null;
    }
    int i = 0;
    if (this.this$0.Q != null) {
      i = this.this$0.Q.a(MessageRecord.getTableName(this.this$0.e, this.this$0.f));
    }
    int j = ChatHistory.a(this.this$0.app, this.this$0.e, this.this$0.f, localStringBuilder);
    Message localMessage = this.this$0.U.obtainMessage(this.b);
    if ((localStringBuilder != null) && (localStringBuilder.length() > 0)) {
      localMessage.obj = localStringBuilder.toString();
    }
    localMessage.arg1 = j;
    localMessage.arg2 = i;
    this.this$0.U.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.8
 * JD-Core Version:    0.7.0.1
 */