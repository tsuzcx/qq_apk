package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class UpComingMsgChatPie$4
  implements Comparator<MessageRecord>
{
  UpComingMsgChatPie$4(UpComingMsgChatPie paramUpComingMsgChatPie) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.UpComingMsgChatPie.4
 * JD-Core Version:    0.7.0.1
 */