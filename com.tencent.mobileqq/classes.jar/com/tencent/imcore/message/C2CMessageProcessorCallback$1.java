package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qidian.util.QidianUtils;

class C2CMessageProcessorCallback$1
  implements Runnable
{
  C2CMessageProcessorCallback$1(C2CMessageProcessorCallback paramC2CMessageProcessorCallback, C2CMessageProcessor paramC2CMessageProcessor, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    QidianUtils.a(this.a.q, this.b.istroop, this.b.frienduin, String.valueOf(this.b.mQidianMasterUin), String.valueOf(this.b.mQidianTaskId), this.b.mQidianTipText, this.b.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageProcessorCallback.1
 * JD-Core Version:    0.7.0.1
 */