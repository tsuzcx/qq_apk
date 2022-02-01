package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.QQSettingMe;

class Conversation$24
  implements Runnable
{
  Conversation$24(Conversation paramConversation) {}
  
  public void run()
  {
    if (!QQSettingMe.i()) {
      Conversation.q(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.24
 * JD-Core Version:    0.7.0.1
 */