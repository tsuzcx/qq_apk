package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

final class MsgProxyUtils$2
  implements Comparator<MessageRecord>
{
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxyUtils.2
 * JD-Core Version:    0.7.0.1
 */