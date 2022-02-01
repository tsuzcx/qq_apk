package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class C2CMessageProcessor$4
  implements Comparator<MessageRecord>
{
  C2CMessageProcessor$4(C2CMessageProcessor paramC2CMessageProcessor) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord2.time - paramMessageRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageProcessor.4
 * JD-Core Version:    0.7.0.1
 */