package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class DoubleVideoCtrlUI$10
  implements Runnable
{
  DoubleVideoCtrlUI$10(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong) {}
  
  public void run()
  {
    if (!this.this$0.h())
    {
      SessionInfo localSessionInfo = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(localSessionInfo.d, 239);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(239);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(localSessionInfo.d, 9);
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localSessionInfo.d, Boolean.valueOf(true) });
      QLog.w(this.this$0.d, 1, "onCreate, exit when OnCreate, seq[" + this.a + "]");
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a, 1008);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.10
 * JD-Core Version:    0.7.0.1
 */