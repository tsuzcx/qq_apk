package com.tencent.mobileqq.activity;

import adtz;
import android.view.View;
import android.widget.TextView;

class ConversationTitleBtnCtrl$3$1
  implements Runnable
{
  ConversationTitleBtnCtrl$3$1(ConversationTitleBtnCtrl.3 param3) {}
  
  public void run()
  {
    if (adtz.a(this.a.this$0) > 0) {
      if (adtz.a(this.a.this$0) != null)
      {
        if (adtz.a(this.a.this$0) > 99)
        {
          adtz.a(this.a.this$0).setText("99+");
          adtz.a(this.a.this$0).setVisibility(0);
        }
      }
      else if (adtz.b(this.a.this$0) != null) {
        adtz.b(this.a.this$0).setVisibility(8);
      }
    }
    label212:
    do
    {
      do
      {
        return;
        adtz.a(this.a.this$0).setText("" + adtz.a(this.a.this$0));
        break;
        if (!adtz.a(this.a.this$0)) {
          break label212;
        }
        if (adtz.b(this.a.this$0) != null) {
          adtz.b(this.a.this$0).setVisibility(0);
        }
      } while (adtz.a(this.a.this$0) == null);
      adtz.a(this.a.this$0).setVisibility(8);
      return;
      if (adtz.b(this.a.this$0) != null) {
        adtz.b(this.a.this$0).setVisibility(8);
      }
    } while (adtz.a(this.a.this$0) == null);
    adtz.a(this.a.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.3.1
 * JD-Core Version:    0.7.0.1
 */