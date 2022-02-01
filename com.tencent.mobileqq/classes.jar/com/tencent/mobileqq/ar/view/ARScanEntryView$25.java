package com.tencent.mobileqq.ar.view;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$25
  implements Runnable
{
  ARScanEntryView$25(ARScanEntryView paramARScanEntryView, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, ArVideoResourceInfo paramArVideoResourceInfo) {}
  
  public void run()
  {
    ARScanEntryView.n(this.this$0);
    this.this$0.f.setVisibility(8);
    this.this$0.e.setVisibility(0);
    this.this$0.e.setOnClickListener(new ARScanEntryView.25.1(this));
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_ARScanEntryView", 2, "onMultiARAnimationInteraction 请点击屏幕进入下一动画片段！");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.25
 * JD-Core Version:    0.7.0.1
 */