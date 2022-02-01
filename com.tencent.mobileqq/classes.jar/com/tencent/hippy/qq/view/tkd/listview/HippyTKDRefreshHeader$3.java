package com.tencent.hippy.qq.view.tkd.listview;

import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollFinishListener;

class HippyTKDRefreshHeader$3
  implements RecyclerViewBase.OnScrollFinishListener
{
  HippyTKDRefreshHeader$3(HippyTKDRefreshHeader paramHippyTKDRefreshHeader) {}
  
  public void onScrollFinished()
  {
    this.this$0.setRefreshState(0);
    HippyTKDRefreshHeader.access$002(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.3
 * JD-Core Version:    0.7.0.1
 */