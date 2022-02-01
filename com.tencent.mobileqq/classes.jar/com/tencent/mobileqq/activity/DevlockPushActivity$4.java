package com.tencent.mobileqq.activity;

import biau;

class DevlockPushActivity$4
  implements Runnable
{
  DevlockPushActivity$4(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void run()
  {
    try
    {
      if ((this.this$0.a != null) && (this.this$0.a.isShowing()))
      {
        this.this$0.a.dismiss();
        this.this$0.a.cancel();
      }
      this.this$0.a = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockPushActivity.4
 * JD-Core Version:    0.7.0.1
 */