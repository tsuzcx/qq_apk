package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import mjg;

class VideoControlUI$TimmerRunnable
  implements Runnable
{
  VideoControlUI$TimmerRunnable(VideoControlUI paramVideoControlUI) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController != null) && (this.this$0.g))
    {
      String str = mjg.a(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a());
      VideoControlUI localVideoControlUI = this.this$0;
      localVideoControlUI.l += 1;
      str = this.this$0.a(str);
      this.this$0.h(str);
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.TimmerRunnable
 * JD-Core Version:    0.7.0.1
 */