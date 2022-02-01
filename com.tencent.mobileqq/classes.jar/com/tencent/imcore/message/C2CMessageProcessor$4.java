package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qidian.util.QidianUtils;

class C2CMessageProcessor$4
  implements Runnable
{
  C2CMessageProcessor$4(C2CMessageProcessor paramC2CMessageProcessor, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    QidianUtils.a(this.this$0.a, this.a.istroop, this.a.frienduin, String.valueOf(this.a.mQidianMasterUin), String.valueOf(this.a.mQidianTaskId), this.a.mQidianTipText, this.a.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageProcessor.4
 * JD-Core Version:    0.7.0.1
 */