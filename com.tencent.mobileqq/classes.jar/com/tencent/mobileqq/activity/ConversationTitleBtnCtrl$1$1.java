package com.tencent.mobileqq.activity;

import aeav;
import android.view.View;
import android.widget.TextView;

class ConversationTitleBtnCtrl$1$1
  implements Runnable
{
  ConversationTitleBtnCtrl$1$1(ConversationTitleBtnCtrl.1 param1) {}
  
  public void run()
  {
    if (aeav.a(this.a.this$0) > 0) {
      if (aeav.a(this.a.this$0) != null)
      {
        if (aeav.a(this.a.this$0) > 99)
        {
          aeav.a(this.a.this$0).setText("99+");
          aeav.a(this.a.this$0).setVisibility(0);
        }
      }
      else if (aeav.a(this.a.this$0) != null) {
        aeav.a(this.a.this$0).setVisibility(8);
      }
    }
    label225:
    do
    {
      do
      {
        return;
        aeav.a(this.a.this$0).setText("" + aeav.a(this.a.this$0));
        break;
        if ((!aeav.a(this.a.this$0)) || (aeav.b(this.a.this$0) <= 0)) {
          break label225;
        }
        if (aeav.a(this.a.this$0) != null) {
          aeav.a(this.a.this$0).setVisibility(0);
        }
      } while (aeav.a(this.a.this$0) == null);
      aeav.a(this.a.this$0).setVisibility(8);
      return;
      if (aeav.a(this.a.this$0) != null) {
        aeav.a(this.a.this$0).setVisibility(8);
      }
    } while (aeav.a(this.a.this$0) == null);
    aeav.a(this.a.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.1.1
 * JD-Core Version:    0.7.0.1
 */