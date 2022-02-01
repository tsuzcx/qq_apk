package com.tencent.imcore.message.facade.add;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;

public class OnMsgAddObserver
{
  public static void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof ChatMessage)) {
      ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.OnMsgAddObserver
 * JD-Core Version:    0.7.0.1
 */