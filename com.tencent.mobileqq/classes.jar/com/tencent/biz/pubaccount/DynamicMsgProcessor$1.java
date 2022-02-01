package com.tencent.biz.pubaccount;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class DynamicMsgProcessor$1
  implements Comparator<MessageRecord>
{
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.DynamicMsgProcessor.1
 * JD-Core Version:    0.7.0.1
 */