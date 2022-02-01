package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class DoubleVideoCtrlUI$8$1
  implements Runnable
{
  DoubleVideoCtrlUI$8$1(DoubleVideoCtrlUI.8 param8, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$8.this$0.a != null) && (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$8.this$0.a.a() != null))
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$8.this$0.a.a();
      QLog.w(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$8.this$0.d, 1, "StartGlassCheck, lCurrent[" + this.jdField_a_of_type_Long + "], lLastTickFinal[" + this.b + "], VideoGlassWaitTime[" + localSessionInfo.S + "], DefaultTimeOutRule[" + localSessionInfo.T + "], GlassSwitch[" + localSessionInfo.R + "]");
      if ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$8.this$0.a(localSessionInfo.T)) && (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$8.this$0.a.a().R != 0)) {
        DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$8.this$0, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.8.1
 * JD-Core Version:    0.7.0.1
 */