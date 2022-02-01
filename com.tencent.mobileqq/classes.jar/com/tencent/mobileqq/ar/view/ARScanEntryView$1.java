package com.tencent.mobileqq.ar.view;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$1
  implements MessageQueue.IdleHandler
{
  ARScanEntryView$1(ARScanEntryView paramARScanEntryView) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "queueIdle called ");
    }
    if ((ARScanEntryView.a(this.a) != null) && (this.a.m)) {
      ARScanEntryView.a(this.a).c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.1
 * JD-Core Version:    0.7.0.1
 */