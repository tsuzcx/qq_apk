package com.tencent.mobileqq.activity;

import bety;
import com.tencent.mobileqq.widget.QQToast;

class Conversation$57
  implements Runnable
{
  Conversation$57(Conversation paramConversation) {}
  
  public void run()
  {
    if ((Conversation.a(this.this$0) != null) && (Conversation.a(this.this$0).isShowing()))
    {
      Conversation.a(this.this$0).dismiss();
      QQToast.a(this.this$0.a(), 2, this.this$0.a(2131720447), 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.57
 * JD-Core Version:    0.7.0.1
 */