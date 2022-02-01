package com.tencent.mobileqq.ar.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ARScanEntryView$27$1
  implements View.OnClickListener
{
  ARScanEntryView$27$1(ARScanEntryView.27 param27) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(this.a.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo);
    }
    ARScanEntryView.g(this.a.this$0);
    ARScanEntryView.d(this.a.this$0);
    this.a.this$0.a.setOnClickListener(this.a.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.27.1
 * JD-Core Version:    0.7.0.1
 */