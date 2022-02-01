package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class QCircleMsgLoader$1
  implements Comparator<MessageRecord>
{
  QCircleMsgLoader$1(QCircleMsgLoader paramQCircleMsgLoader) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.QCircleMsgLoader.1
 * JD-Core Version:    0.7.0.1
 */