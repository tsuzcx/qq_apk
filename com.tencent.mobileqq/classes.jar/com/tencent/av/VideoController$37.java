package com.tencent.av;

import android.os.Handler;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.UITools;
import com.tencent.qphone.base.util.QLog;

class VideoController$37
  implements Runnable
{
  VideoController$37(VideoController paramVideoController) {}
  
  public void run()
  {
    long l = this.this$0.a();
    if (l > 0L)
    {
      l %= 60L;
      if (l % 30L == 0L)
      {
        String str = UITools.a(this.this$0.a());
        QAVNotification.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(this.this$0.a().b, this.this$0.a().d, str);
        if ((this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop) && (l % 10L == 0L))
        {
          str = VideoController.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("chattingTimerRunnale -->updateNotification() sessionId = ");
          localStringBuilder.append(this.this$0.a().b);
          QLog.w(str, 1, localStringBuilder.toString());
        }
      }
    }
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.37
 * JD-Core Version:    0.7.0.1
 */