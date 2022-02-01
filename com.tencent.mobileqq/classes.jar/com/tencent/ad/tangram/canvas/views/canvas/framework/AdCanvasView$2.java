package com.tencent.ad.tangram.canvas.views.canvas.framework;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AdCanvasView$2
  implements View.OnClickListener
{
  AdCanvasView$2(AdCanvasView paramAdCanvasView) {}
  
  public void onClick(View paramView)
  {
    this.this$0.back();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasView.2
 * JD-Core Version:    0.7.0.1
 */