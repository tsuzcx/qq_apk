package com.tencent.mobileqq.ar.view;

import ajyc;
import allc;
import almz;
import bcpw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$37
  implements Runnable
{
  ARScanEntryView$37(ARScanEntryView paramARScanEntryView) {}
  
  public void run()
  {
    allc localallc = this.this$0.a.a();
    boolean bool1 = localallc.c();
    boolean bool2 = localallc.d();
    QLog.d("AREngine_ARScanEntryView", 1, "startDownloadTimeoutCheck, AR组件加载超, mIsDownloadTimeout[" + ARScanEntryView.c(this.this$0) + "],isBaseSoReady:=" + bool1 + ",isFaceSoReady:=" + bool2);
    ARScanEntryView.c(this.this$0, true);
    if (!bool1)
    {
      this.this$0.d_(ajyc.a(2131700741));
      return;
    }
    this.this$0.j();
    bcpw.a(BaseApplicationImpl.getContext(), 2131690173, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.37
 * JD-Core Version:    0.7.0.1
 */