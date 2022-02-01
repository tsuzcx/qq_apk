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
    boolean bool2 = ARDeviceController.a().a();
    boolean bool3 = ARDeviceController.a().b();
    boolean bool4 = this.this$0.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a().a();
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a();
    boolean bool1;
    if ((ARScanEntryView.c(this.this$0)) && (localObject != null)) {
      bool1 = ((PromotionRes)localObject).a(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);
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
        if (ARScanEntryView.f(this.this$0))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ARLoadFailed. mIsArSoReady = ");
          ((StringBuilder)localObject).append(bool4);
          ((StringBuilder)localObject).append("mARStartFail = ");
          ((StringBuilder)localObject).append(ARScanEntryView.f(this.this$0));
          ((StringBuilder)localObject).append(",isPromotionResReady =");
          ((StringBuilder)localObject).append(bool1);
          QLog.d("AREngine_ARScanEntryView", 1, ((StringBuilder)localObject).toString());
          this.this$0.c_(HardCodeUtil.a(2131700972));
        }
        else if (!ARScanEntryView.c(this.this$0))
        {
          this.this$0.c_(HardCodeUtil.a(2131700967));
          ReportController.b(null, "dc00898", "", "", "0X80085B3", "0X80085B3", 0, 0, "", "", "", "");
        }
      }
      else
      {
        ARScanEntryView.e(this.this$0, true);
        this.this$0.k();
      }
    }
    ARScanEntryView.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.36
 * JD-Core Version:    0.7.0.1
 */