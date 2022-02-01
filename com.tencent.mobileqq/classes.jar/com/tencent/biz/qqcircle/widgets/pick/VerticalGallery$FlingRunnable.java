package com.tencent.biz.qqcircle.widgets.pick;

import android.widget.Scroller;

class VerticalGallery$FlingRunnable
  implements Runnable
{
  private Scroller a;
  private int b;
  private int c;
  
  public VerticalGallery$FlingRunnable(VerticalGallery paramVerticalGallery)
  {
    this.a = new Scroller(paramVerticalGallery.getContext());
  }
  
  private void b()
  {
    this.this$0.removeCallbacks(this);
  }
  
  private void b(boolean paramBoolean)
  {
    VerticalGallery.b(this.this$0, false);
    this.a.forceFinished(true);
    if (paramBoolean) {
      this.this$0.l();
    }
    this.this$0.s();
  }
  
  public void a()
  {
    if (this.this$0.B == 0)
    {
      b(true);
      return;
    }
    VerticalGallery.c(this.this$0, false);
    Object localObject = this.a;
    boolean bool = ((Scroller)localObject).computeScrollOffset();
    int j = ((Scroller)localObject).getCurrY();
    int i = this.c - j;
    if (i > 0)
    {
      localObject = this.this$0;
      VerticalGallery.a((VerticalGallery)localObject, ((VerticalGallery)localObject).k);
      i = Math.min(this.this$0.getHeight() - this.this$0.getPaddingTop() - this.this$0.getPaddingBottom() - 1, i);
    }
    else
    {
      int k = this.this$0.getChildCount();
      localObject = this.this$0;
      VerticalGallery.a((VerticalGallery)localObject, ((VerticalGallery)localObject).k + (k - 1));
      i = Math.max(-(this.this$0.getHeight() - this.this$0.getPaddingBottom() - this.this$0.getPaddingTop() - 1), i);
    }
    this.this$0.c(i);
    if ((bool) && (!VerticalGallery.c(this.this$0)))
    {
      this.c = j;
      this.this$0.post(this);
      return;
    }
    b(true);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    b();
    boolean bool = VerticalGallery.a(this.this$0);
    int i = 2147483647;
    if (bool)
    {
      if (paramInt < 0) {
        i = 2147483647;
      } else {
        i = 0;
      }
      this.c = i;
      this.a.fling(0, i, 0, paramInt, 0, 2147483647, 0, 2147483647);
      this.this$0.post(this);
      return;
    }
    if (paramInt >= 0) {
      i = 0;
    }
    this.b = i;
    this.a.fling(i, 0, paramInt, 0, 0, 2147483647, 0, 2147483647);
    this.this$0.post(this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.this$0.removeCallbacks(this);
    b(paramBoolean);
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (VerticalGallery.a(this.this$0))
    {
      b();
      VerticalGallery.b(this.this$0, true);
      this.c = 0;
      this.a.startScroll(0, 0, 0, -paramInt, VerticalGallery.b(this.this$0));
      this.this$0.post(this);
      return;
    }
    b();
    VerticalGallery.b(this.this$0, true);
    this.b = 0;
    this.a.startScroll(0, 0, -paramInt, 0, VerticalGallery.b(this.this$0));
    this.this$0.post(this);
  }
  
  public void run()
  {
    if (VerticalGallery.a(this.this$0))
    {
      a();
      return;
    }
    if (this.this$0.B == 0)
    {
      b(true);
      return;
    }
    VerticalGallery.c(this.this$0, false);
    Object localObject = this.a;
    boolean bool = ((Scroller)localObject).computeScrollOffset();
    int j = ((Scroller)localObject).getCurrX();
    int i = this.b - j;
    if (i > 0)
    {
      localObject = this.this$0;
      VerticalGallery.a((VerticalGallery)localObject, ((VerticalGallery)localObject).k);
      i = Math.min(this.this$0.getWidth() - this.this$0.getPaddingLeft() - this.this$0.getPaddingRight() - 1, i);
    }
    else
    {
      int k = this.this$0.getChildCount();
      localObject = this.this$0;
      VerticalGallery.a((VerticalGallery)localObject, ((VerticalGallery)localObject).k + (k - 1));
      i = Math.max(-(this.this$0.getWidth() - this.this$0.getPaddingRight() - this.this$0.getPaddingLeft() - 1), i);
    }
    this.this$0.b(i);
    if ((bool) && (!VerticalGallery.c(this.this$0)))
    {
      this.b = j;
      this.this$0.post(this);
      return;
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pick.VerticalGallery.FlingRunnable
 * JD-Core Version:    0.7.0.1
 */