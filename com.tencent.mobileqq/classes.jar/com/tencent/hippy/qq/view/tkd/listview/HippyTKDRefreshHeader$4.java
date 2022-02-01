package com.tencent.hippy.qq.view.tkd.listview;

class HippyTKDRefreshHeader$4
  implements Runnable
{
  HippyTKDRefreshHeader$4(HippyTKDRefreshHeader paramHippyTKDRefreshHeader) {}
  
  public void run()
  {
    if (!HippyTKDRefreshHeader.access$000(this.this$0))
    {
      this.this$0.setRefreshState(0);
      HippyTKDRefreshHeader.access$002(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.4
 * JD-Core Version:    0.7.0.1
 */