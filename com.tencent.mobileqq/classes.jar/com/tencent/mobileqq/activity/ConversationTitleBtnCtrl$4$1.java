package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.TextView;

class ConversationTitleBtnCtrl$4$1
  implements Runnable
{
  ConversationTitleBtnCtrl$4$1(ConversationTitleBtnCtrl.4 param4) {}
  
  public void run()
  {
    if (ConversationTitleBtnCtrl.a(this.a.this$0) > 0)
    {
      if (ConversationTitleBtnCtrl.a(this.a.this$0) != null)
      {
        if (ConversationTitleBtnCtrl.a(this.a.this$0) > 99)
        {
          ConversationTitleBtnCtrl.a(this.a.this$0).setText("99+");
        }
        else
        {
          TextView localTextView = ConversationTitleBtnCtrl.a(this.a.this$0);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(ConversationTitleBtnCtrl.a(this.a.this$0));
          localTextView.setText(localStringBuilder.toString());
        }
        ConversationTitleBtnCtrl.a(this.a.this$0).setVisibility(0);
      }
      if (ConversationTitleBtnCtrl.c(this.a.this$0) != null) {
        ConversationTitleBtnCtrl.c(this.a.this$0).setVisibility(8);
      }
    }
    else if (ConversationTitleBtnCtrl.a(this.a.this$0))
    {
      if (ConversationTitleBtnCtrl.c(this.a.this$0) != null) {
        ConversationTitleBtnCtrl.c(this.a.this$0).setVisibility(0);
      }
      if (ConversationTitleBtnCtrl.a(this.a.this$0) != null) {
        ConversationTitleBtnCtrl.a(this.a.this$0).setVisibility(8);
      }
    }
    else
    {
      if (ConversationTitleBtnCtrl.c(this.a.this$0) != null) {
        ConversationTitleBtnCtrl.c(this.a.this$0).setVisibility(8);
      }
      if (ConversationTitleBtnCtrl.a(this.a.this$0) != null) {
        ConversationTitleBtnCtrl.a(this.a.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.4.1
 * JD-Core Version:    0.7.0.1
 */