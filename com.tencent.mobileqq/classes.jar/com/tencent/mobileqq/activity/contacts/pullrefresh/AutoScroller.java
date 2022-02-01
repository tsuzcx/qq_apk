package com.tencent.mobileqq.activity.contacts.pullrefresh;

import android.widget.Scroller;

public class AutoScroller
  implements Runnable
{
  private CommonRefreshLayout a;
  private Scroller b;
  private AutoScroller.ScrollerCallback c;
  private int d;
  private boolean e = false;
  private boolean f = false;
  
  public AutoScroller(CommonRefreshLayout paramCommonRefreshLayout)
  {
    this.a = paramCommonRefreshLayout;
    this.b = new Scroller(paramCommonRefreshLayout.getContext());
  }
  
  private void c()
  {
    this.d = 0;
    this.e = false;
    this.a.removeCallbacks(this);
    if (!this.f)
    {
      AutoScroller.ScrollerCallback localScrollerCallback = this.c;
      if (localScrollerCallback != null) {
        localScrollerCallback.a();
      }
    }
  }
  
  public void a()
  {
    if (this.e)
    {
      if (!this.b.isFinished())
      {
        this.f = true;
        this.b.forceFinished(true);
      }
      c();
      this.f = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.removeCallbacks(this);
    this.d = 0;
    if (!this.b.isFinished()) {
      this.b.forceFinished(true);
    }
    this.b.startScroll(0, 0, 0, paramInt1, paramInt2);
    this.a.post(this);
    this.e = true;
  }
  
  public void a(AutoScroller.ScrollerCallback paramScrollerCallback)
  {
    this.c = paramScrollerCallback;
  }
  
  public boolean b()
  {
    return this.b.isFinished();
  }
  
  public void run()
  {
    int i;
    if ((this.b.computeScrollOffset()) && (!this.b.isFinished())) {
      i = 0;
    } else {
      i = 1;
    }
    int j = this.b.getCurrY();
    int k = this.d;
    if (i != 0)
    {
      c();
      return;
    }
    this.d = j;
    AutoScroller.ScrollerCallback localScrollerCallback = this.c;
    if (localScrollerCallback != null) {
      localScrollerCallback.a(j - k);
    }
    this.a.post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.pullrefresh.AutoScroller
 * JD-Core Version:    0.7.0.1
 */