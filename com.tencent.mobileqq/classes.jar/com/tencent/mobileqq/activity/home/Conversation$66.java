package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class Conversation$66
  implements Runnable
{
  Conversation$66(Conversation paramConversation) {}
  
  public void run()
  {
    if ((Conversation.a(this.this$0) != null) && (Conversation.a(this.this$0).isShowing()))
    {
      Conversation.a(this.this$0).dismiss();
      QQToast.a(this.this$0.a(), 2, this.this$0.a(2131719615), 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.66
 * JD-Core Version:    0.7.0.1
 */