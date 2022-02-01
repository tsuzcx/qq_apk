package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import mqq.app.AppRuntime;

class BaseMessageManager$1
  implements Runnable
{
  BaseMessageManager$1(BaseMessageManager paramBaseMessageManager, MessageRecord paramMessageRecord, long paramLong) {}
  
  public void run()
  {
    ((MessageCache)this.this$0.a.getMsgCache()).i(this.a);
    this.this$0.a();
    long l1 = System.currentTimeMillis();
    long l2 = this.b;
    if (!((MessageCache)this.this$0.a.getMsgCache()).d(this.a.frienduin, this.a.istroop, this.a.uniseq)) {
      BaseMessageManager.e.a(this.this$0.a, this.a, 15000L - (l1 - l2));
    } else {
      BaseMessageManager.e.a(this.this$0.a, this.a.frienduin, this.a.istroop, BaseMessageProcessor.b, BaseMessageProcessor.j);
    }
    ((MessageCache)this.this$0.a.getMsgCache()).i(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager.1
 * JD-Core Version:    0.7.0.1
 */