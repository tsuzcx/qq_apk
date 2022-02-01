package com.tencent.hippy.qq.view.tkd.listview;

class HippyTKDDefaultFooter$2
  implements Runnable
{
  HippyTKDDefaultFooter$2(HippyTKDDefaultFooter paramHippyTKDDefaultFooter) {}
  
  public void run()
  {
    if (HippyTKDDefaultFooter.access$000(this.this$0) != null) {
      HippyTKDDefaultFooter.access$000(this.this$0).onNeedPullToRefresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDDefaultFooter.2
 * JD-Core Version:    0.7.0.1
 */