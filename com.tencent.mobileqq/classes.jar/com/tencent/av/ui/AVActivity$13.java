package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;

class AVActivity$13
  implements Runnable
{
  AVActivity$13(AVActivity paramAVActivity, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    SessionInfo localSessionInfo = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localSessionInfo.b())
    {
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(localSessionInfo.c, 229);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(229);
      int i = localSessionInfo.d;
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(localSessionInfo.c, 21);
      if (i == 1) {
        localSessionInfo.a(this.a, "av.onResume.1", 3);
      } else if (i == 2) {
        localSessionInfo.a(this.a, "av.onResume.2", 4);
      }
      if (localSessionInfo.c()) {
        localSessionInfo.k = 1;
      } else {
        localSessionInfo.k = 3000;
      }
      localSessionInfo.c(this.a, false);
      localSessionInfo.d("AVActivity.onResume", 0);
      this.this$0.jdField_a_of_type_ComTencentAvUiControlUIObserver.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.13
 * JD-Core Version:    0.7.0.1
 */