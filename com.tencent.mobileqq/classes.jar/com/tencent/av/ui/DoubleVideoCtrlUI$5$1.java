package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import lgf;

class DoubleVideoCtrlUI$5$1
  implements Runnable
{
  DoubleVideoCtrlUI$5$1(DoubleVideoCtrlUI.5 param5, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$5.this$0.a != null) && (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$5.this$0.a.a() != null))
    {
      lgf locallgf = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$5.this$0.a.a();
      QLog.w(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$5.this$0.c, 1, "StartGlassCheck, lCurrent[" + this.jdField_a_of_type_Long + "], lLastTickFinal[" + this.b + "], VideoGlassWaitTime[" + locallgf.R + "], DefaultTimeOutRule[" + locallgf.S + "], GlassSwitch[" + locallgf.Q + "]");
      if ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$5.this$0.a(locallgf.S)) && (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$5.this$0.a.a().Q != 0)) {
        DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$5.this$0, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.5.1
 * JD-Core Version:    0.7.0.1
 */