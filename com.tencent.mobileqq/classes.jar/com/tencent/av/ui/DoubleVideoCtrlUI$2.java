package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import lff;
import mbb;

class DoubleVideoCtrlUI$2
  implements Runnable
{
  DoubleVideoCtrlUI$2(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if (this.this$0.h()) {}
    do
    {
      return;
      long l = AudioHelper.b();
      if ((!this.this$0.jdField_a_of_type_ComTencentAvVideoController.f()) && (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().f == 1) && (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().j))
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.this$0.d, 1, "FixTerSwitchStatus ,switch to pc ,local close camera, seq[" + l + "]");
        }
        this.this$0.j(l);
        this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
        mbb.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1021);
      }
      this.this$0.i(l, 65535);
    } while (!this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().g);
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(true, this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.2
 * JD-Core Version:    0.7.0.1
 */