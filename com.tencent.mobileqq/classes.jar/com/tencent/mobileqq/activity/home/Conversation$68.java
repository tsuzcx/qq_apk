package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class Conversation$68
  implements Runnable
{
  Conversation$68(Conversation paramConversation) {}
  
  public void run()
  {
    if ((Conversation.y(this.this$0) != null) && (Conversation.y(this.this$0).isShowing()))
    {
      Conversation.y(this.this$0).dismiss();
      QQToast.makeText(this.this$0.P(), 2, this.this$0.e(2131916886), 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.68
 * JD-Core Version:    0.7.0.1
 */