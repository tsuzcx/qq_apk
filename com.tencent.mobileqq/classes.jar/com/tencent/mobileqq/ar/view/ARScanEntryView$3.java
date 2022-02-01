package com.tencent.mobileqq.ar.view;

import android.os.Handler;
import com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate.ARBaseResDownLoadCallBack;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$3
  implements ScanEntryResourceDelegate.ARBaseResDownLoadCallBack
{
  ARScanEntryView$3(ARScanEntryView paramARScanEntryView) {}
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onARBaseResDownloadComplete ;");
    localStringBuilder.append(this.a.J);
    QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
    if (!this.a.J) {
      return;
    }
    ARScanEntryView.a(this.a, 100);
    ARScanEntryView.d(this.a).removeMessages(324);
    ARScanEntryView.d(this.a).sendEmptyMessage(324);
    this.a.m();
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onARBaseResUpdateProgress ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(";");
    localStringBuilder.append(this.a.J);
    QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
    if (!this.a.J) {
      return;
    }
    ARScanEntryView.a(this.a, paramInt);
    ARScanEntryView.c(this.a);
  }
  
  public void b()
  {
    this.a.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.3
 * JD-Core Version:    0.7.0.1
 */