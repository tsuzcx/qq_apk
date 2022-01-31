package com.tencent.mobileqq.ar.view;

import ajya;
import allb;
import almy;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$37
  implements Runnable
{
  ARScanEntryView$37(ARScanEntryView paramARScanEntryView) {}
  
  public void run()
  {
    allb localallb = this.this$0.a.a();
    boolean bool1 = localallb.c();
    boolean bool2 = localallb.d();
    QLog.d("AREngine_ARScanEntryView", 1, "startDownloadTimeoutCheck, AR组件加载超, mIsDownloadTimeout[" + ARScanEntryView.c(this.this$0) + "],isBaseSoReady:=" + bool1 + ",isFaceSoReady:=" + bool2);
    ARScanEntryView.c(this.this$0, true);
    if (!bool1)
    {
      this.this$0.d_(ajya.a(2131700752));
      return;
    }
    this.this$0.j();
    bcql.a(BaseApplicationImpl.getContext(), 2131690173, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.37
 * JD-Core Version:    0.7.0.1
 */