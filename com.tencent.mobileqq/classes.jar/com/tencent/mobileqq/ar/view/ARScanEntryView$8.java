package com.tencent.mobileqq.ar.view;

import android.os.Handler;
import com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$8
  implements Runnable
{
  ARScanEntryView$8(ARScanEntryView paramARScanEntryView, long paramLong, ScanEntryResourceDelegate paramScanEntryResourceDelegate) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, String.format("doWhenGetARConfig start time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - ARScanEntryView.a(this.this$0)) }));
    }
    long l2 = this.jdField_a_of_type_Long;
    long l1 = 0L;
    int i;
    if ((l2 & 0x4) != 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate.a(2)) {
      l1 = 2L;
    }
    l2 = l1;
    if (!this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate.a(8)) {
      l2 = l1 | 0x8;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate.a(4)) && (i != 0)) {
      l2 |= 0x4;
    } else {
      ARScanEntryView.b(this.this$0, 100);
    }
    this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate.a(l2, ARScanEntryView.a(this.this$0), ARScanEntryView.a(this.this$0));
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate.c();
    if ((this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate.a(4)) || (i == 0)) {
      ARScanEntryView.b(this.this$0, 100);
    }
    if (bool)
    {
      ARScanEntryView.a(this.this$0, 100);
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARScanEntryView", 2, String.format("doWhenGetARConfig end time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - ARScanEntryView.a(this.this$0)) }));
      }
      if (ARScanEntryView.a(this.this$0) != null)
      {
        ARScanEntryView.a(this.this$0).removeMessages(324);
        ARScanEntryView.a(this.this$0).sendEmptyMessage(324);
      }
    }
    if ((bool) && (ARScanEntryView.a(this.this$0) != 100)) {
      this.this$0.k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.8
 * JD-Core Version:    0.7.0.1
 */