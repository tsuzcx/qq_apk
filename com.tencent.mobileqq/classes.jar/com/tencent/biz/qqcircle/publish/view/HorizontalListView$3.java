package com.tencent.biz.qqcircle.publish.view;

class HorizontalListView$3
  implements Runnable
{
  HorizontalListView$3(HorizontalListView paramHorizontalListView) {}
  
  public void run()
  {
    if (this.this$0.r == -1)
    {
      if (HorizontalListView.b(this.this$0) != -1) {
        return;
      }
      if (!this.this$0.d.a()) {
        return;
      }
      if (HorizontalListView.a)
      {
        localObject = this.this$0;
        ((HorizontalListView)localObject).a("mFlingRunnable", new Object[] { Integer.valueOf(((HorizontalListView)localObject).r) });
      }
      Object localObject = this.this$0.d;
      int i = this.this$0.getScrollX();
      if (((OverScroller)localObject).a(this.this$0.j + i, this.this$0.getScrollY(), this.this$0.j, this.this$0.j, 0, 0))
      {
        this.this$0.r = 6;
        if (HorizontalListView.a) {
          this.this$0.a("mFlingRunnable", new Object[] { "TOUCH_MODE_OVERFLING" });
        }
        this.this$0.setCurrentScrollState(4099);
        this.this$0.invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.HorizontalListView.3
 * JD-Core Version:    0.7.0.1
 */