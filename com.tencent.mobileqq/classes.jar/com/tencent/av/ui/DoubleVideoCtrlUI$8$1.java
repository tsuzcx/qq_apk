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
      String str = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$8.this$0.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StartGlassCheck, lCurrent[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("], lLastTickFinal[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("], VideoGlassWaitTime[");
      localStringBuilder.append(localSessionInfo.Q);
      localStringBuilder.append("], DefaultTimeOutRule[");
      localStringBuilder.append(localSessionInfo.R);
      localStringBuilder.append("], GlassSwitch[");
      localStringBuilder.append(localSessionInfo.P);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      if ((this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$8.this$0.a(localSessionInfo.R)) && (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$8.this$0.a.a().P != 0)) {
        DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$8.this$0, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.8.1
 * JD-Core Version:    0.7.0.1
 */