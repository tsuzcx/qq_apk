package com.tencent.biz.subscribe.videoplayer;

import android.os.Handler;
import android.view.TextureView;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import zzx;
import zzy;

public class VideoFrameCheckHelper$1
  implements Runnable
{
  public VideoFrameCheckHelper$1(zzx paramzzx, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame");
    if (System.currentTimeMillis() - zzx.a(this.this$0) >= 4000L) {}
    for (boolean bool = true; (this.a.get() == null) || (this.b.get() == null); bool = false)
    {
      QLog.d("VideoFrameCheckHelper", 1, "reference recycled");
      return;
    }
    if ((zzx.a(this.this$0, (TextureView)this.b.get())) && (!bool))
    {
      zzx.a(this.this$0, (TextureView)this.b.get(), (zzy)this.a.get());
      QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame again");
      return;
    }
    zzx.a(this.this$0).post(new VideoFrameCheckHelper.1.1(this, bool));
    zzx.b(this.this$0).removeCallbacksAndMessages(null);
    QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame stop isReachMaxTime:" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoFrameCheckHelper.1
 * JD-Core Version:    0.7.0.1
 */