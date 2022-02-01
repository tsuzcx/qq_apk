package com.tencent.biz.qqcircle.publish.view;

class HorizontalListView$2
  implements Runnable
{
  HorizontalListView$2(HorizontalListView paramHorizontalListView, HorizontalListView.PerformClick paramPerformClick) {}
  
  public void run()
  {
    HorizontalListView localHorizontalListView = this.this$0;
    localHorizontalListView.r = -1;
    HorizontalListView.a(localHorizontalListView);
    if (!this.this$0.g) {
      this.a.run();
    }
    HorizontalListView.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.HorizontalListView.2
 * JD-Core Version:    0.7.0.1
 */