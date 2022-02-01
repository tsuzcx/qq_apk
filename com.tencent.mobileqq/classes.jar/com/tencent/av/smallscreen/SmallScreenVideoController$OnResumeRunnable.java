package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.ControlUIObserver;

class SmallScreenVideoController$OnResumeRunnable
  implements Runnable
{
  long a;
  
  SmallScreenVideoController$OnResumeRunnable(SmallScreenVideoController paramSmallScreenVideoController, long paramLong)
  {
    this.a = paramLong;
  }
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a() == null) {
      return;
    }
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().b())
    {
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().c, 226);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(226);
      int i = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().d;
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().c, 21);
      if (i == 1) {
        this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().a(this.a, "small.onResume.1", 3);
      } else if (i == 2) {
        this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().a(this.a, "small.onResume.2", 4);
      }
      if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().c()) {
        this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int = 1;
      } else {
        this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int = 3000;
      }
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().c(this.a, false);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().d("SmallScreen.onResume", 0);
    }
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean) && (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().ap) && (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().Q > 0)) {
      SmallScreenVideoController.a(this.this$0);
    }
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) {
      this.this$0.jdField_a_of_type_ComTencentAvUiControlUIObserver.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.OnResumeRunnable
 * JD-Core Version:    0.7.0.1
 */