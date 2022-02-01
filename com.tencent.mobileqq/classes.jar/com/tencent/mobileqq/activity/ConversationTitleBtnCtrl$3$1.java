package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.TextView;

class ConversationTitleBtnCtrl$3$1
  implements Runnable
{
  ConversationTitleBtnCtrl$3$1(ConversationTitleBtnCtrl.3 param3) {}
  
  public void run()
  {
    if (ConversationTitleBtnCtrl.a(this.a.this$0) > 0) {
      if (ConversationTitleBtnCtrl.a(this.a.this$0) != null)
      {
        if (ConversationTitleBtnCtrl.a(this.a.this$0) > 99)
        {
          ConversationTitleBtnCtrl.a(this.a.this$0).setText("99+");
          ConversationTitleBtnCtrl.a(this.a.this$0).setVisibility(0);
        }
      }
      else if (ConversationTitleBtnCtrl.b(this.a.this$0) != null) {
        ConversationTitleBtnCtrl.b(this.a.this$0).setVisibility(8);
      }
    }
    label212:
    do
    {
      do
      {
        return;
        ConversationTitleBtnCtrl.a(this.a.this$0).setText("" + ConversationTitleBtnCtrl.a(this.a.this$0));
        break;
        if (!ConversationTitleBtnCtrl.a(this.a.this$0)) {
          break label212;
        }
        if (ConversationTitleBtnCtrl.b(this.a.this$0) != null) {
          ConversationTitleBtnCtrl.b(this.a.this$0).setVisibility(0);
        }
      } while (ConversationTitleBtnCtrl.a(this.a.this$0) == null);
      ConversationTitleBtnCtrl.a(this.a.this$0).setVisibility(8);
      return;
      if (ConversationTitleBtnCtrl.b(this.a.this$0) != null) {
        ConversationTitleBtnCtrl.b(this.a.this$0).setVisibility(8);
      }
    } while (ConversationTitleBtnCtrl.a(this.a.this$0) == null);
    ConversationTitleBtnCtrl.a(this.a.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.3.1
 * JD-Core Version:    0.7.0.1
 */