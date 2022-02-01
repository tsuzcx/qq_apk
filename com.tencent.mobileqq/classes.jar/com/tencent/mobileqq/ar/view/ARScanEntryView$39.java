package com.tencent.mobileqq.ar.view;

import anvx;
import apbb;
import apov;
import apqp;
import ayyc;
import bdla;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$39
  implements Runnable
{
  ARScanEntryView$39(ARScanEntryView paramARScanEntryView) {}
  
  public void run()
  {
    boolean bool2 = apbb.a().a();
    boolean bool3 = apbb.a().b();
    boolean bool4 = this.this$0.jdField_a_of_type_Apqp.a().a();
    ayyc localayyc = this.this$0.jdField_a_of_type_Apqp.a();
    if ((ARScanEntryView.c(this.this$0)) && (localayyc != null)) {}
    for (boolean bool1 = localayyc.a(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);; bool1 = true)
    {
      QLog.d("AREngine_ARScanEntryView", 1, "excute mTimeoutChecker runnable isAREnable:=" + bool2 + ",isSupportAr:=" + bool3 + ",isBaseSoReady:=" + bool4 + ",isPromotionResReady:=" + bool1);
      if ((bool2) && (bool3))
      {
        if ((!bool4) || (!bool1)) {
          break label274;
        }
        if (!ARScanEntryView.f(this.this$0)) {
          break label225;
        }
        QLog.d("AREngine_ARScanEntryView", 1, "ARLoadFailed. mIsArSoReady = " + bool4 + "mARStartFail = " + ARScanEntryView.f(this.this$0) + ",isPromotionResReady =" + bool1);
        this.this$0.d_(anvx.a(2131700250));
      }
      label274:
      for (;;)
      {
        ARScanEntryView.a(this.this$0, null);
        return;
        label225:
        if (!ARScanEntryView.c(this.this$0))
        {
          this.this$0.d_(anvx.a(2131700245));
          bdla.b(null, "dc00898", "", "", "0X80085B3", "0X80085B3", 0, 0, "", "", "", "");
          continue;
          ARScanEntryView.e(this.this$0, true);
          this.this$0.k();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.39
 * JD-Core Version:    0.7.0.1
 */