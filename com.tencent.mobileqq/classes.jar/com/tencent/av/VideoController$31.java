package com.tencent.av;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import ley;
import msp;
import mue;

class VideoController$31
  implements Runnable
{
  VideoController$31(VideoController paramVideoController) {}
  
  public void run()
  {
    if (this.this$0.f) {
      return;
    }
    long l = this.this$0.a();
    if (l > 0L)
    {
      l %= 60L;
      if (l % 30L == 0L)
      {
        String str = mue.a(this.this$0.a());
        msp.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(this.this$0.a().c, this.this$0.a().d, str);
        if ((this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop) && (l % 10L == 0L)) {
          QLog.w(VideoController.jdField_a_of_type_JavaLangString, 1, "chattingTimerRunnale -->updateNotification() sessionId = " + this.this$0.a().c);
        }
      }
    }
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.31
 * JD-Core Version:    0.7.0.1
 */