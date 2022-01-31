package com.tencent.biz.videostory.capture.widgets;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;

class AEPlayShowPageView$3
  implements Runnable
{
  AEPlayShowPageView$3(AEPlayShowPageView paramAEPlayShowPageView, int paramInt) {}
  
  public void run()
  {
    if (AEPlayShowPageView.a(this.this$0) != null)
    {
      View localView = AEPlayShowPageView.a(this.this$0).findViewByPosition(this.a);
      if (localView != null) {
        localView.performClick();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.widgets.AEPlayShowPageView.3
 * JD-Core Version:    0.7.0.1
 */