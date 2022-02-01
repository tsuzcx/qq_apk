package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class UpComingMsgChatPie$5
  implements Comparator<MessageRecord>
{
  UpComingMsgChatPie$5(UpComingMsgChatPie paramUpComingMsgChatPie) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.UpComingMsgChatPie.5
 * JD-Core Version:    0.7.0.1
 */