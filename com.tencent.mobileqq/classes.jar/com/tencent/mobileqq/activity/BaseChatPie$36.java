package com.tencent.mobileqq.activity;

import android.app.Dialog;

class BaseChatPie$36
  implements Runnable
{
  BaseChatPie$36(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if ((this.this$0.e != null) && (this.this$0.e.isShowing())) {
      this.this$0.e.dismiss();
    }
    while ((this.this$0.f == null) || (!this.this$0.f.isShowing())) {
      return;
    }
    this.this$0.f.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.36
 * JD-Core Version:    0.7.0.1
 */