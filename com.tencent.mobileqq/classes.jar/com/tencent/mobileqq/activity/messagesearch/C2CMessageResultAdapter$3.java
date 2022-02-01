package com.tencent.mobileqq.activity.messagesearch;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class C2CMessageResultAdapter$3
  implements Comparator<MessageItem>
{
  C2CMessageResultAdapter$3(C2CMessageResultAdapter paramC2CMessageResultAdapter) {}
  
  public int a(MessageItem paramMessageItem1, MessageItem paramMessageItem2)
  {
    return (int)(paramMessageItem2.b.time - paramMessageItem1.b.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CMessageResultAdapter.3
 * JD-Core Version:    0.7.0.1
 */