package com.tencent.mobileqq.ar.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ARScanEntryView$25$1
  implements View.OnClickListener
{
  ARScanEntryView$25$1(ARScanEntryView.25 param25) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.a(this.a.b);
    }
    ARScanEntryView.t(this.a.this$0);
    ARScanEntryView.n(this.a.this$0);
    this.a.this$0.e.setOnClickListener(this.a.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.25.1
 * JD-Core Version:    0.7.0.1
 */