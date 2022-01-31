package com.tencent.biz.subscribe.videoplayer;

import android.os.Handler;
import android.view.TextureView;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import yii;
import yij;

public class VideoFrameCheckHelper$1
  implements Runnable
{
  public VideoFrameCheckHelper$1(yii paramyii, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame");
    if (System.currentTimeMillis() - yii.a(this.this$0) >= 4000L) {}
    for (boolean bool = true; (this.a.get() == null) || (this.b.get() == null); bool = false)
    {
      QLog.d("VideoFrameCheckHelper", 1, "reference recycled");
      return;
    }
    if ((yii.a(this.this$0, (TextureView)this.b.get())) && (!bool))
    {
      yii.a(this.this$0, (TextureView)this.b.get(), (yij)this.a.get());
      QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame again");
      return;
    }
    yii.a(this.this$0).post(new VideoFrameCheckHelper.1.1(this, bool));
    yii.b(this.this$0).removeCallbacksAndMessages(null);
    QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame stop isReachMaxTime:" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoFrameCheckHelper.1
 * JD-Core Version:    0.7.0.1
 */