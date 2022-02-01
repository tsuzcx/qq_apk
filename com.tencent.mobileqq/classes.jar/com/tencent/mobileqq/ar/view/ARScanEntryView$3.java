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
    localStringBuilder.append(this.a.m);
    QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
    if (!this.a.m) {
      return;
    }
    ARScanEntryView.a(this.a, 100);
    ARScanEntryView.a(this.a).removeMessages(324);
    ARScanEntryView.a(this.a).sendEmptyMessage(324);
    this.a.k();
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onARBaseResUpdateProgress ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(";");
    localStringBuilder.append(this.a.m);
    QLog.d("AREngine_ARScanEntryView", 1, localStringBuilder.toString());
    if (!this.a.m) {
      return;
    }
    ARScanEntryView.a(this.a, paramInt);
    ARScanEntryView.a(this.a);
  }
  
  public void b()
  {
    this.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.3
 * JD-Core Version:    0.7.0.1
 */