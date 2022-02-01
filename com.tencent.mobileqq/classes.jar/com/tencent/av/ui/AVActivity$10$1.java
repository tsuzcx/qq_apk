package com.tencent.av.ui;

import com.tencent.av.VideoController;
import lez;
import mas;

public class AVActivity$10$1
  implements Runnable
{
  public AVActivity$10$1(mas parammas) {}
  
  public void run()
  {
    if ((this.a.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.a.jdField_a_of_type_ComTencentAvVideoController.a().g != 4) && (this.a.a.b == 1) && (!this.a.a.jdField_a_of_type_Boolean))
    {
      this.a.a.b(false);
      this.a.a.f(false);
      if ((this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
      {
        ((DoubleVideoCtrlUI)this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).a();
        ((DoubleVideoCtrlUI)this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).b(true);
        this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(-1028L, 65535);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.10.1
 * JD-Core Version:    0.7.0.1
 */