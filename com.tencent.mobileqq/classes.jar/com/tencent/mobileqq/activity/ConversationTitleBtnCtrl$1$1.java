package com.tencent.mobileqq.activity;

import aejz;
import android.view.View;
import android.widget.TextView;

class ConversationTitleBtnCtrl$1$1
  implements Runnable
{
  ConversationTitleBtnCtrl$1$1(ConversationTitleBtnCtrl.1 param1) {}
  
  public void run()
  {
    if (aejz.a(this.a.this$0) > 0) {
      if (aejz.a(this.a.this$0) != null)
      {
        if (aejz.a(this.a.this$0) > 99)
        {
          aejz.a(this.a.this$0).setText("99+");
          aejz.a(this.a.this$0).setVisibility(0);
        }
      }
      else if (aejz.a(this.a.this$0) != null) {
        aejz.a(this.a.this$0).setVisibility(8);
      }
    }
    label212:
    do
    {
      do
      {
        return;
        aejz.a(this.a.this$0).setText("" + aejz.a(this.a.this$0));
        break;
        if (!aejz.a(this.a.this$0)) {
          break label212;
        }
        if (aejz.a(this.a.this$0) != null) {
          aejz.a(this.a.this$0).setVisibility(0);
        }
      } while (aejz.a(this.a.this$0) == null);
      aejz.a(this.a.this$0).setVisibility(8);
      return;
      if (aejz.a(this.a.this$0) != null) {
        aejz.a(this.a.this$0).setVisibility(8);
      }
    } while (aejz.a(this.a.this$0) == null);
    aejz.a(this.a.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.1.1
 * JD-Core Version:    0.7.0.1
 */