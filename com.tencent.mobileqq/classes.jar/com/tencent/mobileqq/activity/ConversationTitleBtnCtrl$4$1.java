package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.TextView;
import com.tencent.widget.RedWidgetUtil;

class ConversationTitleBtnCtrl$4$1
  implements Runnable
{
  ConversationTitleBtnCtrl$4$1(ConversationTitleBtnCtrl.4 param4) {}
  
  public void run()
  {
    if (ConversationTitleBtnCtrl.f(this.a.this$0) > 0)
    {
      if (ConversationTitleBtnCtrl.i(this.a.this$0) != null)
      {
        if (ConversationTitleBtnCtrl.f(this.a.this$0) > 99)
        {
          ConversationTitleBtnCtrl.i(this.a.this$0).setText("99+");
        }
        else
        {
          TextView localTextView = ConversationTitleBtnCtrl.i(this.a.this$0);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(ConversationTitleBtnCtrl.f(this.a.this$0));
          localTextView.setText(localStringBuilder.toString());
        }
        RedWidgetUtil.fixTextViewLayout(ConversationTitleBtnCtrl.i(this.a.this$0), ConversationTitleBtnCtrl.f(this.a.this$0), 99, 2130852592);
        ConversationTitleBtnCtrl.i(this.a.this$0).setVisibility(0);
      }
      if (ConversationTitleBtnCtrl.j(this.a.this$0) != null) {
        ConversationTitleBtnCtrl.j(this.a.this$0).setVisibility(8);
      }
    }
    else if (ConversationTitleBtnCtrl.g(this.a.this$0))
    {
      if (ConversationTitleBtnCtrl.j(this.a.this$0) != null) {
        ConversationTitleBtnCtrl.j(this.a.this$0).setVisibility(0);
      }
      if (ConversationTitleBtnCtrl.i(this.a.this$0) != null) {
        ConversationTitleBtnCtrl.i(this.a.this$0).setVisibility(8);
      }
    }
    else
    {
      if (ConversationTitleBtnCtrl.j(this.a.this$0) != null) {
        ConversationTitleBtnCtrl.j(this.a.this$0).setVisibility(8);
      }
      if (ConversationTitleBtnCtrl.i(this.a.this$0) != null) {
        ConversationTitleBtnCtrl.i(this.a.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.4.1
 * JD-Core Version:    0.7.0.1
 */