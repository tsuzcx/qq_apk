package com.tencent.mobileqq.activity.aio.helper;

import android.app.Dialog;

class AIOJubaoDialogHelper$3
  implements Runnable
{
  AIOJubaoDialogHelper$3(AIOJubaoDialogHelper paramAIOJubaoDialogHelper) {}
  
  public void run()
  {
    if ((this.this$0.c != null) && (this.this$0.c.isShowing()))
    {
      this.this$0.c.dismiss();
      return;
    }
    if ((this.this$0.d != null) && (this.this$0.d.isShowing())) {
      this.this$0.d.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOJubaoDialogHelper.3
 * JD-Core Version:    0.7.0.1
 */