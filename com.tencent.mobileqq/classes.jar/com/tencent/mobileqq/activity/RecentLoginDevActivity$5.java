package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class RecentLoginDevActivity$5
  implements Runnable
{
  RecentLoginDevActivity$5(RecentLoginDevActivity paramRecentLoginDevActivity) {}
  
  public void run()
  {
    try
    {
      if ((RecentLoginDevActivity.f(this.this$0) == null) && (!this.this$0.isFinishing())) {
        RecentLoginDevActivity.a(this.this$0, new QQProgressDialog(this.this$0.getActivity(), this.this$0.getTitleBarHeight()));
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if ((RecentLoginDevActivity.f(this.this$0) != null) && (!RecentLoginDevActivity.f(this.this$0).isShowing())) {
      RecentLoginDevActivity.f(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentLoginDevActivity.5
 * JD-Core Version:    0.7.0.1
 */