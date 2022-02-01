package com.tencent.mobileqq.activity;

import bjbs;

class RecentLoginDevActivity$5
  implements Runnable
{
  RecentLoginDevActivity$5(RecentLoginDevActivity paramRecentLoginDevActivity) {}
  
  public void run()
  {
    try
    {
      if ((RecentLoginDevActivity.a(this.this$0) == null) && (!this.this$0.isFinishing())) {
        RecentLoginDevActivity.a(this.this$0, new bjbs(this.this$0.getActivity(), this.this$0.getTitleBarHeight()));
      }
      if ((RecentLoginDevActivity.a(this.this$0) != null) && (!RecentLoginDevActivity.a(this.this$0).isShowing())) {
        RecentLoginDevActivity.a(this.this$0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentLoginDevActivity.5
 * JD-Core Version:    0.7.0.1
 */