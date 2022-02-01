package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class BaseMessageProcessorForTroopAndDisc$1
  implements Comparator<MessageRecord>
{
  BaseMessageProcessorForTroopAndDisc$1(BaseMessageProcessorForTroopAndDisc paramBaseMessageProcessorForTroopAndDisc) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)((paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) % 2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageProcessorForTroopAndDisc.1
 * JD-Core Version:    0.7.0.1
 */