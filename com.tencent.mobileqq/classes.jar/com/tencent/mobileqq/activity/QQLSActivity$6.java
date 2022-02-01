package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.ChatMessage;
import java.util.Comparator;

class QQLSActivity$6
  implements Comparator<ChatMessage>
{
  QQLSActivity$6(QQLSActivity paramQQLSActivity) {}
  
  public int a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if (paramChatMessage1.time == paramChatMessage2.time) {
      return 0;
    }
    if (paramChatMessage1.time > paramChatMessage2.time) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.6
 * JD-Core Version:    0.7.0.1
 */