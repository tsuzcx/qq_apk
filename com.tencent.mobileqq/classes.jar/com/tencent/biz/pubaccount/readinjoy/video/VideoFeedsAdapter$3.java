package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsAdapter$3
  extends Handler
{
  VideoFeedsAdapter$3(VideoFeedsAdapter paramVideoFeedsAdapter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "mUIHandler handleMessage() msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    case 1: 
    case 4: 
    case 5: 
    case 6: 
    default: 
      super.handleMessage(paramMessage);
      return;
    case 0: 
      VideoFeedsAdapter.a(this.a);
      return;
    case 2: 
      VideoFeedsAdapter.b(this.a);
      return;
    case 3: 
      VideoFeedsAdapter.c(this.a);
      return;
    case 7: 
      VideoFeedsAdapter.d(this.a);
      return;
    }
    VideoFeedsAdapter.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.3
 * JD-Core Version:    0.7.0.1
 */