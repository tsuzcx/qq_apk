package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;

class Conversation$17
  implements Runnable
{
  Conversation$17(Conversation paramConversation, String paramString) {}
  
  public void run()
  {
    Conversation localConversation = this.this$0;
    Conversation.a(localConversation, this.a, ContactUtils.c(localConversation.a(), this.this$0.a().getCurrentUin()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.17
 * JD-Core Version:    0.7.0.1
 */