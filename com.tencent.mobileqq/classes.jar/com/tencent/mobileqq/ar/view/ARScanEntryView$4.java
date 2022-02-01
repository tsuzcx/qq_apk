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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAsyncFaceResDownLoadComplete ");
    localStringBuilder.append(this.a.J);
    QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
    if (!this.a.J) {
      return;
    }
    ARScanEntryView.b(this.a, 100);
    if ((ARScanEntryView.a(this.a).h != null) && (ARScanEntryView.a(this.a).h.b != null)) {
      ARScanEntryView.a(this.a).h.b.b();
    }
    if (ARScanEntryView.d(this.a) != null)
    {
      ARScanEntryView.d(this.a).removeMessages(324);
      ARScanEntryView.d(this.a).sendEmptyMessage(324);
    }
    if ((ARScanEntryView.e(this.a)) && (this.a.H.getUniformResManger().j()))
    {
      ARScanEntryView.f(this.a);
      QLog.d("AREngine_ARScanEntryView", 1, "everything is ready,so quit update resources");
      return;
    }
    this.a.m();
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAsyncFaceResUpdateProgress ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(";");
    localStringBuilder.append(this.a.J);
    QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
    if (!this.a.J) {
      return;
    }
    ARScanEntryView.b(this.a, paramInt);
    ARScanEntryView.c(this.a);
  }
  
  public void b()
  {
    this.a.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.4
 * JD-Core Version:    0.7.0.1
 */