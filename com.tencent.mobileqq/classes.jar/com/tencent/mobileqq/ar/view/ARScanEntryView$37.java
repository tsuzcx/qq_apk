package com.tencent.mobileqq.ar.view;

import alud;
import anga;
import anhx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$37
  implements Runnable
{
  ARScanEntryView$37(ARScanEntryView paramARScanEntryView) {}
  
  public void run()
  {
    anga localanga = this.this$0.a.a();
    boolean bool1 = localanga.c();
    boolean bool2 = localanga.d();
    QLog.d("AREngine_ARScanEntryView", 1, "startDownloadTimeoutCheck, AR组件加载超, mIsDownloadTimeout[" + ARScanEntryView.e(this.this$0) + "],isBaseSoReady:=" + bool1 + ",isFaceSoReady:=" + bool2);
    ARScanEntryView.c(this.this$0, true);
    if (!bool1) {
      this.this$0.d_(alud.a(2131701133));
    }
    do
    {
      return;
      this.this$0.j();
    } while (ARScanEntryView.c(this.this$0));
    QQToast.a(BaseApplicationImpl.getContext(), 2131690221, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.37
 * JD-Core Version:    0.7.0.1
 */