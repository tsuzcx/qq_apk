package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.QQAppInterface;

class Conversation$10
  implements Runnable
{
  Conversation$10(Conversation paramConversation) {}
  
  public void run()
  {
    if (this.this$0.s() != null) {
      this.this$0.s().startAllSubMessageAccountMsg(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.10
 * JD-Core Version:    0.7.0.1
 */