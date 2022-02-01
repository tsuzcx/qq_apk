package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

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
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    RecentLoginDevActivity.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentLoginDevActivity.6
 * JD-Core Version:    0.7.0.1
 */