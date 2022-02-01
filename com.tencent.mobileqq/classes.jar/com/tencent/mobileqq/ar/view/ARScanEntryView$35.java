package com.tencent.mobileqq.ar.view;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$35
  implements Runnable
{
  ARScanEntryView$35(ARScanEntryView paramARScanEntryView) {}
  
  public void run()
  {
    Object localObject = this.this$0.H.getUniformResManger();
    boolean bool1 = ((ScanEntryResourceDelegate)localObject).l();
    boolean bool2 = ((ScanEntryResourceDelegate)localObject).m();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startDownloadTimeoutCheck, AR组件加载超, mIsDownloadTimeout[");
    ((StringBuilder)localObject).append(ARScanEntryView.y(this.this$0));
    ((StringBuilder)localObject).append("],isBaseSoReady:=");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(",isFaceSoReady:=");
    ((StringBuilder)localObject).append(bool2);
    QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
    ARScanEntryView.f(this.this$0, true);
    if (!bool1)
    {
      this.this$0.c(HardCodeUtil.a(2131898995));
      return;
    }
    this.this$0.l();
    if (!ARScanEntryView.p(this.this$0)) {
      QQToast.makeText(BaseApplicationImpl.getContext(), 2131887013, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.35
 * JD-Core Version:    0.7.0.1
 */