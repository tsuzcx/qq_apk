package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import ley;

class DoubleVideoCtrlUI$13
  implements Runnable
{
  DoubleVideoCtrlUI$13(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController != null) && (this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().d, 233);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(233);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().d, 9);
      QLog.d(this.this$0.d, 1, "exit when onBackPressed");
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a, 1008);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.13
 * JD-Core Version:    0.7.0.1
 */