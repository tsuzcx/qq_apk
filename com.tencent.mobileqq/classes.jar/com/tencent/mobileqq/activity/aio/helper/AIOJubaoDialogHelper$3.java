package com.tencent.mobileqq.activity.aio.helper;

import agfq;
import android.app.Dialog;

public class AIOJubaoDialogHelper$3
  implements Runnable
{
  public AIOJubaoDialogHelper$3(agfq paramagfq) {}
  
  public void run()
  {
    if ((this.this$0.c != null) && (this.this$0.c.isShowing())) {
      this.this$0.c.dismiss();
    }
    while ((this.this$0.d == null) || (!this.this$0.d.isShowing())) {
      return;
    }
    this.this$0.d.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOJubaoDialogHelper.3
 * JD-Core Version:    0.7.0.1
 */