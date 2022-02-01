package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.tips.TipsUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class SmallScreenMultiVideoControlUI$RequestVideoTimeOutRunnable
  implements Runnable
{
  SmallScreenMultiVideoControlUI$RequestVideoTimeOutRunnable(SmallScreenMultiVideoControlUI paramSmallScreenMultiVideoControlUI) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a("Small_RequestVideoTimeOutRunnable");
      TipsUtil.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
      TipsUtil.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
      TipsUtil.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030, 2131695880);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().b(this.this$0.jdField_a_of_type_Long, true, true);
      this.this$0.a(true, false, true);
      if (this.this$0.d == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8004425", "0X8004425", 0, 0, "", "", "", "");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("SmallScreenMultiVideoControlUI", 2, "RequestVideoTimeOutRunnable, mVideoController = null!!!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.RequestVideoTimeOutRunnable
 * JD-Core Version:    0.7.0.1
 */