package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;

class Conversation$18
  implements Runnable
{
  Conversation$18(Conversation paramConversation, String paramString) {}
  
  public void run()
  {
    Conversation localConversation = this.this$0;
    Conversation.a(localConversation, this.a, ContactUtils.c(localConversation.s(), this.this$0.s().getCurrentUin()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.18
 * JD-Core Version:    0.7.0.1
 */