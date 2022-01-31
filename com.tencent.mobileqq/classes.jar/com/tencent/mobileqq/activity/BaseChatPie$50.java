package com.tencent.mobileqq.activity;

import aaed;
import android.view.View;
import android.widget.TextView;

class BaseChatPie$50
  implements Runnable
{
  BaseChatPie$50(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (this.this$0.i != null) {
      this.this$0.i.setVisibility(8);
    }
    if (BaseChatPie.a(this.this$0) != null) {
      BaseChatPie.a(this.this$0).setVisibility(8);
    }
    if ((this.this$0.a != null) && (!this.this$0.w())) {
      this.this$0.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.50
 * JD-Core Version:    0.7.0.1
 */