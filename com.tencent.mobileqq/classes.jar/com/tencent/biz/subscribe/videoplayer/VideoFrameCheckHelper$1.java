package com.tencent.biz.subscribe.videoplayer;

import android.os.Handler;
import android.view.TextureView;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class VideoFrameCheckHelper$1
  implements Runnable
{
  VideoFrameCheckHelper$1(VideoFrameCheckHelper paramVideoFrameCheckHelper, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame");
    boolean bool;
    if (System.currentTimeMillis() - VideoFrameCheckHelper.a(this.this$0) >= 4000L) {
      bool = true;
    } else {
      bool = false;
    }
    if ((this.a.get() != null) && (this.b.get() != null))
    {
      if ((VideoFrameCheckHelper.a(this.this$0, (TextureView)this.b.get())) && (!bool))
      {
        VideoFrameCheckHelper.a(this.this$0, (TextureView)this.b.get(), (VideoFrameCheckHelper.DarkFrameCheckListener)this.a.get());
        QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame again");
        return;
      }
      VideoFrameCheckHelper.b(this.this$0).post(new VideoFrameCheckHelper.1.1(this, bool));
      VideoFrameCheckHelper.c(this.this$0).removeCallbacksAndMessages(null);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doCheckCurrentFrame stop isReachMaxTime:");
      localStringBuilder.append(bool);
      QLog.d("VideoFrameCheckHelper", 1, localStringBuilder.toString());
      return;
    }
    QLog.d("VideoFrameCheckHelper", 1, "reference recycled");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoFrameCheckHelper.1
 * JD-Core Version:    0.7.0.1
 */