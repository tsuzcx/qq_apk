package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import kvq;

class DoubleVideoCtrlUI$9
  implements Runnable
{
  DoubleVideoCtrlUI$9(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if (this.this$0.g()) {
      return;
    }
    String str = this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().O;
    QLog.w(this.this$0.c, 1, "onResume, setGlass, nCurrentSwitch[" + i + "]");
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(42), str, Integer.valueOf(i) });
    DoubleVideoCtrlUI.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.9
 * JD-Core Version:    0.7.0.1
 */