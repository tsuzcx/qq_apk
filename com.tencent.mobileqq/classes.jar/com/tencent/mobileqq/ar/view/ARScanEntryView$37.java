package com.tencent.mobileqq.ar.view;

import ajjy;
import akwq;
import akyn;
import bbmy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$37
  implements Runnable
{
  ARScanEntryView$37(ARScanEntryView paramARScanEntryView) {}
  
  public void run()
  {
    akwq localakwq = this.this$0.a.a();
    boolean bool1 = localakwq.c();
    boolean bool2 = localakwq.d();
    QLog.d("AREngine_ARScanEntryView", 1, "startDownloadTimeoutCheck, AR组件加载超, mIsDownloadTimeout[" + ARScanEntryView.c(this.this$0) + "],isBaseSoReady:=" + bool1 + ",isFaceSoReady:=" + bool2);
    ARScanEntryView.c(this.this$0, true);
    if (!bool1)
    {
      this.this$0.d_(ajjy.a(2131634957));
      return;
    }
    this.this$0.j();
    bbmy.a(BaseApplicationImpl.getContext(), 2131624619, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.37
 * JD-Core Version:    0.7.0.1
 */