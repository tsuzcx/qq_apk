package com.tencent.mobileqq.activity;

import adcx;
import android.view.View;
import android.widget.TextView;

class ConversationTitleBtnCtrl$3$1
  implements Runnable
{
  ConversationTitleBtnCtrl$3$1(ConversationTitleBtnCtrl.3 param3) {}
  
  public void run()
  {
    if (adcx.a(this.a.this$0) > 0) {
      if (adcx.a(this.a.this$0) != null)
      {
        if (adcx.a(this.a.this$0) > 99)
        {
          adcx.a(this.a.this$0).setText("99+");
          adcx.a(this.a.this$0).setVisibility(0);
        }
      }
      else if (adcx.b(this.a.this$0) != null) {
        adcx.b(this.a.this$0).setVisibility(8);
      }
    }
    label212:
    do
    {
      do
      {
        return;
        adcx.a(this.a.this$0).setText("" + adcx.a(this.a.this$0));
        break;
        if (!adcx.a(this.a.this$0)) {
          break label212;
        }
        if (adcx.b(this.a.this$0) != null) {
          adcx.b(this.a.this$0).setVisibility(0);
        }
      } while (adcx.a(this.a.this$0) == null);
      adcx.a(this.a.this$0).setVisibility(8);
      return;
      if (adcx.b(this.a.this$0) != null) {
        adcx.b(this.a.this$0).setVisibility(8);
      }
    } while (adcx.a(this.a.this$0) == null);
    adcx.a(this.a.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.3.1
 * JD-Core Version:    0.7.0.1
 */