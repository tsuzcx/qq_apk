package com.tencent.mobileqq.activity.home;

import bhht;
import com.tencent.mobileqq.widget.QQToast;

class Conversation$62
  implements Runnable
{
  Conversation$62(Conversation paramConversation) {}
  
  public void run()
  {
    if ((Conversation.a(this.this$0) != null) && (Conversation.a(this.this$0).isShowing()))
    {
      Conversation.a(this.this$0).dismiss();
      QQToast.a(this.this$0.a(), 2, this.this$0.a(2131718686), 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.62
 * JD-Core Version:    0.7.0.1
 */