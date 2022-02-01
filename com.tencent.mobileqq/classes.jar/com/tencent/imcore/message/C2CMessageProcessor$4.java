package com.tencent.imcore.message;

import aczw;
import bkio;
import com.tencent.mobileqq.data.MessageRecord;

public class C2CMessageProcessor$4
  implements Runnable
{
  public C2CMessageProcessor$4(aczw paramaczw, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    bkio.a(this.this$0.a, this.a.istroop, this.a.frienduin, String.valueOf(this.a.mQidianMasterUin), String.valueOf(this.a.mQidianTaskId), this.a.mQidianTipText, this.a.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageProcessor.4
 * JD-Core Version:    0.7.0.1
 */