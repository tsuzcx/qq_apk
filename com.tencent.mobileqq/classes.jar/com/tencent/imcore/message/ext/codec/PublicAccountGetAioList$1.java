package com.tencent.imcore.message.ext.codec;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class PublicAccountGetAioList$1
  implements Comparator<MessageRecord>
{
  PublicAccountGetAioList$1(PublicAccountGetAioList paramPublicAccountGetAioList) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.PublicAccountGetAioList.1
 * JD-Core Version:    0.7.0.1
 */