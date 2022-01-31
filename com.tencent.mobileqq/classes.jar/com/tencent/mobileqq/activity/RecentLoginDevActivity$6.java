package com.tencent.mobileqq.activity;

import bety;

class RecentLoginDevActivity$6
  implements Runnable
{
  RecentLoginDevActivity$6(RecentLoginDevActivity paramRecentLoginDevActivity) {}
  
  public void run()
  {
    try
    {
      if ((RecentLoginDevActivity.a(this.this$0) != null) && (RecentLoginDevActivity.a(this.this$0).isShowing()))
      {
        RecentLoginDevActivity.a(this.this$0).dismiss();
        RecentLoginDevActivity.a(this.this$0).cancel();
      }
      RecentLoginDevActivity.a(this.this$0, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentLoginDevActivity.6
 * JD-Core Version:    0.7.0.1
 */