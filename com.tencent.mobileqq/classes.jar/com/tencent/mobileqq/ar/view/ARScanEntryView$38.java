package com.tencent.mobileqq.ar.view;

import amtj;
import aolu;
import aono;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$38
  implements Runnable
{
  ARScanEntryView$38(ARScanEntryView paramARScanEntryView) {}
  
  public void run()
  {
    aolu localaolu = this.this$0.a.a();
    boolean bool1 = localaolu.c();
    boolean bool2 = localaolu.d();
    QLog.d("AREngine_ARScanEntryView", 1, "startDownloadTimeoutCheck, AR组件加载超, mIsDownloadTimeout[" + ARScanEntryView.e(this.this$0) + "],isBaseSoReady:=" + bool1 + ",isFaceSoReady:=" + bool2);
    ARScanEntryView.d(this.this$0, true);
    if (!bool1) {
      this.this$0.b_(amtj.a(2131699900));
    }
    do
    {
      return;
      this.this$0.j();
    } while (ARScanEntryView.c(this.this$0));
    QQToast.a(BaseApplicationImpl.getContext(), 2131690103, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.38
 * JD-Core Version:    0.7.0.1
 */