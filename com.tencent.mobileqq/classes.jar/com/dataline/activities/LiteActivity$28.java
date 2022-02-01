package com.dataline.activities;

import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.widget.XListView;

final class LiteActivity$28
  implements Runnable
{
  LiteActivity$28(XListView paramXListView, ScrollerRunnable paramScrollerRunnable) {}
  
  public void run()
  {
    if (this.a.getCount() > 2)
    {
      ScrollerRunnable localScrollerRunnable = this.b;
      XListView localXListView = this.a;
      LiteActivity.a(localScrollerRunnable, localXListView, localXListView.getCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.28
 * JD-Core Version:    0.7.0.1
 */