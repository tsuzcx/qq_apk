package com.tencent.mobileqq.ar.view;

import android.os.Handler;
import com.tencent.mobileqq.ar.arengine.ARLocalControl;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog;
import com.tencent.mobileqq.ar.model.QQARSession;
import com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate;
import com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate.AsyncFaceResDownloadCallBack;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$4
  implements ScanEntryResourceDelegate.AsyncFaceResDownloadCallBack
{
  ARScanEntryView$4(ARScanEntryView paramARScanEntryView) {}
  
  public void a()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onAsyncFaceResDownLoadComplete " + this.a.m);
    if (!this.a.m) {
      return;
    }
    ARScanEntryView.b(this.a, 100);
    if ((ARScanEntryView.a(this.a).a != null) && (ARScanEntryView.a(this.a).a.a != null)) {
      ARScanEntryView.a(this.a).a.a.a();
    }
    if (ARScanEntryView.a(this.a) != null)
    {
      ARScanEntryView.a(this.a).removeMessages(324);
      ARScanEntryView.a(this.a).sendEmptyMessage(324);
    }
    if ((ARScanEntryView.a(this.a)) && (this.a.a.a().a()))
    {
      ARScanEntryView.b(this.a);
      QLog.d("AREngine_ARScanEntryView", 1, "everything is ready,so quit update resources");
      return;
    }
    this.a.k();
  }
  
  public void a(int paramInt)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onAsyncFaceResUpdateProgress " + paramInt + ";" + this.a.m);
    if (!this.a.m) {
      return;
    }
    ARScanEntryView.b(this.a, paramInt);
    ARScanEntryView.a(this.a);
  }
  
  public void b()
  {
    this.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.4
 * JD-Core Version:    0.7.0.1
 */