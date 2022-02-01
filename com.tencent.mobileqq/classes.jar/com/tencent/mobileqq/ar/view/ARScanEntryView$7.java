package com.tencent.mobileqq.ar.view;

import android.os.Handler;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView.PopUpListener;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$7
  implements ScanIconAnimateView.PopUpListener
{
  ARScanEntryView$7(ARScanEntryView paramARScanEntryView) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "PopUp onStart ");
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "PopUp onEnd  needReportRedDot = " + ARScanEntryView.b(this.a));
    }
    if (ARScanEntryView.a(this.a) != null) {
      ARScanEntryView.a(this.a).post(new ARScanEntryView.7.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.7
 * JD-Core Version:    0.7.0.1
 */