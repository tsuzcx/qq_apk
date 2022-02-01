package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class MultiVideoCtrlLayerUI4NewGroupChat$AutoCheckVideoRunnable
  implements Runnable
{
  MultiVideoCtrlLayerUI4NewGroupChat$AutoCheckVideoRunnable(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.d, 2, "AutoCheckVideoRunnable");
    }
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().ab = true;
    }
    MultiVideoCtrlLayerUI4NewGroupChat.e(this.this$0);
    if (this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.this$0.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat.AutoCheckVideoRunnable
 * JD-Core Version:    0.7.0.1
 */