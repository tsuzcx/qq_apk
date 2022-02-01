package com.tencent.mobileqq.ar.view;

import android.os.Handler;
import com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate;
import com.tencent.mobileqq.olympic.activity.ARTipsManager.ButtonClickListener;
import com.tencent.mobileqq.olympic.activity.PromotionRes;

class ARScanEntryView$40
  implements ARTipsManager.ButtonClickListener
{
  ARScanEntryView$40(ARScanEntryView paramARScanEntryView, ScanEntryResourceDelegate paramScanEntryResourceDelegate, PromotionRes paramPromotionRes) {}
  
  public void a()
  {
    ARScanEntryView.f(this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView, false);
    this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView.b("ClickTips");
    ARScanEntryView.g(this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView, true);
    ARScanEntryView.a(this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView).postDelayed(new ARScanEntryView.40.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.40
 * JD-Core Version:    0.7.0.1
 */