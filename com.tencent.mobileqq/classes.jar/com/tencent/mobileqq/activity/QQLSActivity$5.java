package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.ChatMessage;
import java.util.Comparator;

class QQLSActivity$5
  implements Comparator<ChatMessage>
{
  QQLSActivity$5(QQLSActivity paramQQLSActivity) {}
  
  public int a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if (paramChatMessage1.shmsgseq == paramChatMessage2.shmsgseq) {
      return 0;
    }
    if (paramChatMessage1.shmsgseq > paramChatMessage2.shmsgseq) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.5
 * JD-Core Version:    0.7.0.1
 */