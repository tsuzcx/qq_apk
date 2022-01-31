package com.tencent.mobileqq.ar.view;

import ajya;
import akxb;
import allb;
import almy;
import augl;
import axqy;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$38
  implements Runnable
{
  ARScanEntryView$38(ARScanEntryView paramARScanEntryView) {}
  
  public void run()
  {
    boolean bool2 = akxb.a().a();
    boolean bool3 = akxb.a().b();
    boolean bool4 = this.this$0.jdField_a_of_type_Almy.a().a();
    augl localaugl = this.this$0.jdField_a_of_type_Almy.a();
    if ((ARScanEntryView.d(this.this$0)) && (localaugl != null)) {}
    for (boolean bool1 = localaugl.a(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);; bool1 = true)
    {
      QLog.d("AREngine_ARScanEntryView", 1, "excute mTimeoutChecker runnable isAREnable:=" + bool2 + ",isSupportAr:=" + bool3 + ",isBaseSoReady:=" + bool4 + ",isPromotionResReady:=" + bool1);
      if ((bool2) && (bool3))
      {
        if ((!bool4) || (!bool1)) {
          break label274;
        }
        if (!ARScanEntryView.e(this.this$0)) {
          break label225;
        }
        QLog.d("AREngine_ARScanEntryView", 1, "ARLoadFailed. mIsArSoReady = " + bool4 + "mARStartFail = " + ARScanEntryView.e(this.this$0) + ",isPromotionResReady =" + bool1);
        this.this$0.d_(ajya.a(2131700751));
      }
      label274:
      for (;;)
      {
        ARScanEntryView.a(this.this$0, null);
        return;
        label225:
        if (!ARScanEntryView.d(this.this$0))
        {
          this.this$0.d_(ajya.a(2131700746));
          axqy.b(null, "dc00898", "", "", "0X80085B3", "0X80085B3", 0, 0, "", "", "", "");
          continue;
          ARScanEntryView.d(this.this$0, true);
          this.this$0.k();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.38
 * JD-Core Version:    0.7.0.1
 */