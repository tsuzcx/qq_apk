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
    long l = this.this$0.z();
    if (l > 0L)
    {
      l %= 60L;
      if (l % 30L == 0L)
      {
        String str = UITools.a(this.this$0.z());
        QAVNotification.a(this.this$0.e).a(this.this$0.k().f, this.this$0.k().g, str);
        if ((this.this$0.e.isBackgroundStop) && (l % 10L == 0L))
        {
          str = VideoController.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("chattingTimerRunnale -->updateNotification() sessionId = ");
          localStringBuilder.append(this.this$0.k().f);
          QLog.w(str, 1, localStringBuilder.toString());
        }
      }
    }
    this.this$0.e.a().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.37
 * JD-Core Version:    0.7.0.1
 */