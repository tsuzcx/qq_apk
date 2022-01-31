package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class SmallScreenMultiVideoControlUI$1$AutoCheckVideoRunnable
  implements Runnable
{
  SmallScreenMultiVideoControlUI$1$AutoCheckVideoRunnable(SmallScreenMultiVideoControlUI.1 param1) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "AutoCheckVideoRunnable");
    }
    if (this.a.a.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.a.a.jdField_a_of_type_ComTencentAvVideoController.a().ak = true;
    }
    this.a.a.n();
    if ((this.a.a.c == 1) && (this.a.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.a.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.a.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.1.AutoCheckVideoRunnable
 * JD-Core Version:    0.7.0.1
 */