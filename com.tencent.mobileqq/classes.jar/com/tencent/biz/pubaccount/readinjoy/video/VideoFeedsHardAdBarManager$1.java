package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsHardAdBarManager$1
  extends Handler
{
  VideoFeedsHardAdBarManager$1(VideoFeedsHardAdBarManager paramVideoFeedsHardAdBarManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mUIHandler handleMessage() msg.what = ");
      localStringBuilder.append(paramMessage.what);
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsHardAdBarManager", 2, localStringBuilder.toString());
    }
    int i = paramMessage.what;
    if (i != 4)
    {
      if (i != 6)
      {
        if (i != 7)
        {
          if (i == 8) {
            this.a.b();
          }
          super.handleMessage(paramMessage);
          return;
        }
        this.a.a(paramMessage);
        return;
      }
      this.a.a();
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHardAdBarManager.1
 * JD-Core Version:    0.7.0.1
 */