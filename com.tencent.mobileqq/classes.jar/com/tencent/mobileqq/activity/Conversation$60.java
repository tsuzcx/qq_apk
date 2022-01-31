package com.tencent.mobileqq.activity;

import bbms;
import bbmy;

class Conversation$60
  implements Runnable
{
  Conversation$60(Conversation paramConversation) {}
  
  public void run()
  {
    if ((Conversation.a(this.this$0) != null) && (Conversation.a(this.this$0).isShowing()))
    {
      Conversation.a(this.this$0).dismiss();
      bbmy.a(this.this$0.a(), 2, this.this$0.a(2131654008), 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.60
 * JD-Core Version:    0.7.0.1
 */