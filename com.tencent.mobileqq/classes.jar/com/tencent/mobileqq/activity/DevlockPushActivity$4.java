package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class DevlockPushActivity$4
  implements Runnable
{
  DevlockPushActivity$4(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void run()
  {
    try
    {
      if ((this.this$0.b != null) && (this.this$0.b.isShowing()))
      {
        this.this$0.b.dismiss();
        this.this$0.b.cancel();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.this$0.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockPushActivity.4
 * JD-Core Version:    0.7.0.1
 */