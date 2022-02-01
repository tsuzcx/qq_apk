package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

class MessageHandler$4
  implements Runnable
{
  MessageHandler$4(MessageHandler paramMessageHandler, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.this$0.a.getMsgCache().b(this.a))
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("delay notify: ");
        localStringBuilder.append(MessageCache.a);
        QLog.d("MsgSend", 4, localStringBuilder.toString());
      }
      this.this$0.notifyUI(8022, true, new String[] { this.a.frienduin });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.4
 * JD-Core Version:    0.7.0.1
 */