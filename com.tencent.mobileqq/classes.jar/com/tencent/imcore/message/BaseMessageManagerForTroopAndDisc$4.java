package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class BaseMessageManagerForTroopAndDisc$4
  implements Runnable
{
  BaseMessageManagerForTroopAndDisc$4(BaseMessageManagerForTroopAndDisc paramBaseMessageManagerForTroopAndDisc, MessageRecord paramMessageRecord, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doPaiYiPaiRevokeRequest ");
      localStringBuilder.append(this.a.getLogColorContent());
      localStringBuilder.append(" holdFlag: ");
      localStringBuilder.append(this.b);
      QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
    }
    if (!this.b)
    {
      BaseMessageManager.e.b(this.this$0.a, this.a, 15000L);
      return;
    }
    this.this$0.l(this.a);
    this.this$0.a();
    long l1 = System.currentTimeMillis();
    long l2 = this.c;
    if (this.this$0.m(this.a)) {
      BaseMessageManager.e.b(this.this$0.a, this.a, 15000L - (l1 - l2));
    } else {
      BaseMessageManager.e.a(this.this$0.a, this.a.frienduin, this.a.istroop, BaseMessageProcessor.b, BaseMessageProcessor.k);
    }
    this.this$0.l(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.4
 * JD-Core Version:    0.7.0.1
 */