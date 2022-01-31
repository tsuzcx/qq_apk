package com.tencent.mobileqq.ar.view;

import ajyc;
import akxc;
import allc;
import almz;
import augj;
import axqw;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$38
  implements Runnable
{
  ARScanEntryView$38(ARScanEntryView paramARScanEntryView) {}
  
  public void run()
  {
    boolean bool2 = akxc.a().a();
    boolean bool3 = akxc.a().b();
    boolean bool4 = this.this$0.jdField_a_of_type_Almz.a().a();
    augj localaugj = this.this$0.jdField_a_of_type_Almz.a();
    if ((ARScanEntryView.d(this.this$0)) && (localaugj != null)) {}
    for (boolean bool1 = localaugj.a(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface);; bool1 = true)
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
        this.this$0.d_(ajyc.a(2131700740));
      }
      label274:
      for (;;)
      {
        ARScanEntryView.a(this.this$0, null);
        return;
        label225:
        if (!ARScanEntryView.d(this.this$0))
        {
          this.this$0.d_(ajyc.a(2131700735));
          axqw.b(null, "dc00898", "", "", "0X80085B3", "0X80085B3", 0, 0, "", "", "", "");
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