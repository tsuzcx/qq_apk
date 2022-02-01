package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;

class AVActivity$11$1
  implements Runnable
{
  AVActivity$11$1(AVActivity.11 param11) {}
  
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
        this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(-1028L, 16777215);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.11.1
 * JD-Core Version:    0.7.0.1
 */