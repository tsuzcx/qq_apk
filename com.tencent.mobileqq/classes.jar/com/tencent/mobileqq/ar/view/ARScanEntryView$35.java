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
    Object localObject = this.this$0.a.a();
    boolean bool1 = ((ScanEntryResourceDelegate)localObject).c();
    boolean bool2 = ((ScanEntryResourceDelegate)localObject).d();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startDownloadTimeoutCheck, AR组件加载超, mIsDownloadTimeout[");
    ((StringBuilder)localObject).append(ARScanEntryView.e(this.this$0));
    ((StringBuilder)localObject).append("],isBaseSoReady:=");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(",isFaceSoReady:=");
    ((StringBuilder)localObject).append(bool2);
    QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
    ARScanEntryView.d(this.this$0, true);
    if (!bool1)
    {
      this.this$0.c_(HardCodeUtil.a(2131700973));
      return;
    }
    this.this$0.j();
    if (!ARScanEntryView.c(this.this$0)) {
      QQToast.a(BaseApplicationImpl.getContext(), 2131690114, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.35
 * JD-Core Version:    0.7.0.1
 */