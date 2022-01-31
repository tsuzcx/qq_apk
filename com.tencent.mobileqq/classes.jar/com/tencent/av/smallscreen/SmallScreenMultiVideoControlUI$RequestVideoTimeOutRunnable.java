package com.tencent.av.smallscreen;

import awqx;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import kvq;
import lqb;

class SmallScreenMultiVideoControlUI$RequestVideoTimeOutRunnable
  implements Runnable
{
  SmallScreenMultiVideoControlUI$RequestVideoTimeOutRunnable(SmallScreenMultiVideoControlUI paramSmallScreenMultiVideoControlUI) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.f();
      lqb.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
      lqb.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
      lqb.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030, 2131630474);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().a(this.this$0.jdField_a_of_type_Long, true, true);
      this.this$0.a(true, false, true);
      if (this.this$0.d == 2) {
        awqx.b(null, "CliOper", "", "", "0X8004425", "0X8004425", 0, 0, "", "", "", "");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("SmallScreenMultiVideoControlUI", 2, "RequestVideoTimeOutRunnable, mVideoController = null!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.RequestVideoTimeOutRunnable
 * JD-Core Version:    0.7.0.1
 */