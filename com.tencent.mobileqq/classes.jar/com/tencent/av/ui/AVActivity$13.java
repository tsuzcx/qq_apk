package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;

class AVActivity$13
  implements Runnable
{
  AVActivity$13(AVActivity paramAVActivity, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) {}
    SessionInfo localSessionInfo;
    do
    {
      return;
      localSessionInfo = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (!localSessionInfo.b());
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(localSessionInfo.jdField_d_of_type_JavaLangString, 229);
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(229);
    int i = localSessionInfo.jdField_d_of_type_Int;
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(localSessionInfo.jdField_d_of_type_JavaLangString, 21);
    if (i == 1)
    {
      localSessionInfo.a(this.a, "av.onResume.1", 3);
      if (!localSessionInfo.c()) {
        break label158;
      }
    }
    label158:
    for (localSessionInfo.j = 1;; localSessionInfo.j = 3000)
    {
      localSessionInfo.b(this.a, false);
      localSessionInfo.c("AVActivity.onResume", 0);
      this.this$0.jdField_a_of_type_ComTencentAvUiControlUIObserver.a(this.a);
      return;
      if (i != 2) {
        break;
      }
      localSessionInfo.a(this.a, "av.onResume.2", 4);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.13
 * JD-Core Version:    0.7.0.1
 */