package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class HCTopicMessageProcessor$1
  implements Comparator<MessageRecord>
{
  HCTopicMessageProcessor$1(HCTopicMessageProcessor paramHCTopicMessageProcessor) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)((paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) % 2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.HCTopicMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */