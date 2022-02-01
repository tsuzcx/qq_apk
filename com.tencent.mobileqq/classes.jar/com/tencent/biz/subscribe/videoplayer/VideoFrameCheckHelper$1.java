package com.tencent.biz.subscribe.videoplayer;

import aanx;
import aany;
import android.os.Handler;
import android.view.TextureView;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class VideoFrameCheckHelper$1
  implements Runnable
{
  public VideoFrameCheckHelper$1(aanx paramaanx, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame");
    if (System.currentTimeMillis() - aanx.a(this.this$0) >= 4000L) {}
    for (boolean bool = true; (this.a.get() == null) || (this.b.get() == null); bool = false)
    {
      QLog.d("VideoFrameCheckHelper", 1, "reference recycled");
      return;
    }
    if ((aanx.a(this.this$0, (TextureView)this.b.get())) && (!bool))
    {
      aanx.a(this.this$0, (TextureView)this.b.get(), (aany)this.a.get());
      QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame again");
      return;
    }
    aanx.a(this.this$0).post(new VideoFrameCheckHelper.1.1(this, bool));
    aanx.b(this.this$0).removeCallbacksAndMessages(null);
    QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame stop isReachMaxTime:" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoFrameCheckHelper.1
 * JD-Core Version:    0.7.0.1
 */