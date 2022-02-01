package com.tencent.mobileqq.ar.view;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate;
import com.tencent.mobileqq.olympic.activity.PromotionRes;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$36
  implements Runnable
{
  ARScanEntryView$36(ARScanEntryView paramARScanEntryView) {}
  
  public void run()
  {
    boolean bool2 = ARDeviceController.a().b();
    boolean bool3 = ARDeviceController.a().c();
    boolean bool4 = this.this$0.H.getUniformResManger().j();
    Object localObject = this.this$0.H.getPromotionManager();
    boolean bool1;
    if ((ARScanEntryView.p(this.this$0)) && (localObject != null)) {
      bool1 = ((PromotionRes)localObject).e(this.this$0.C);
    } else {
      bool1 = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("excute mTimeoutChecker runnable isAREnable:=");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append(",isSupportAr:=");
    ((StringBuilder)localObject).append(bool3);
    ((StringBuilder)localObject).append(",isBaseSoReady:=");
    ((StringBuilder)localObject).append(bool4);
    ((StringBuilder)localObject).append(",isPromotionResReady:=");
    ((StringBuilder)localObject).append(bool1);
    QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
    if ((bool2) && (bool3)) {
      if ((bool4) && (bool1))
      {
        if (ARScanEntryView.z(this.this$0))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ARLoadFailed. mIsArSoReady = ");
          ((StringBuilder)localObject).append(bool4);
          ((StringBuilder)localObject).append("mARStartFail = ");
          ((StringBuilder)localObject).append(ARScanEntryView.z(this.this$0));
          ((StringBuilder)localObject).append(",isPromotionResReady =");
          ((StringBuilder)localObject).append(bool1);
          QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
          this.this$0.c(HardCodeUtil.a(2131898994));
        }
        else if (!ARScanEntryView.p(this.this$0))
        {
          this.this$0.c(HardCodeUtil.a(2131898990));
          ReportController.b(null, "dc00898", "", "", "0X80085B3", "0X80085B3", 0, 0, "", "", "", "");
        }
      }
      else
      {
        ARScanEntryView.g(this.this$0, true);
        this.this$0.m();
      }
    }
    ARScanEntryView.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.36
 * JD-Core Version:    0.7.0.1
 */