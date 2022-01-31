package com.tencent.mobileqq.activity;

import bbms;

class DevlockPushActivity$3
  implements Runnable
{
  DevlockPushActivity$3(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void run()
  {
    try
    {
      if ((this.this$0.a == null) && (!this.this$0.isFinishing()))
      {
        this.this$0.a = new bbms(this.this$0, this.this$0.getTitleBarHeight());
        this.this$0.a.c(2131629253);
      }
      if ((this.this$0.a != null) && (!this.this$0.a.isShowing())) {
        this.this$0.a.show();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockPushActivity.3
 * JD-Core Version:    0.7.0.1
 */