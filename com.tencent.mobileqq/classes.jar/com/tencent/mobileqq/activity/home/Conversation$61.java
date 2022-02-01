package com.tencent.mobileqq.activity.home;

import bisl;
import com.tencent.mobileqq.widget.QQToast;

class Conversation$61
  implements Runnable
{
  Conversation$61(Conversation paramConversation) {}
  
  public void run()
  {
    if ((Conversation.a(this.this$0) != null) && (Conversation.a(this.this$0).isShowing()))
    {
      Conversation.a(this.this$0).dismiss();
      QQToast.a(this.this$0.a(), 2, this.this$0.a(2131719075), 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.61
 * JD-Core Version:    0.7.0.1
 */