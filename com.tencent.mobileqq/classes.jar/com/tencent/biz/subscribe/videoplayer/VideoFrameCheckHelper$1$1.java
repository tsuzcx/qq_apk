package com.tencent.biz.subscribe.videoplayer;

import mqq.util.WeakReference;

class VideoFrameCheckHelper$1$1
  implements Runnable
{
  VideoFrameCheckHelper$1$1(VideoFrameCheckHelper.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.b.a.get() != null) {
      ((VideoFrameCheckHelper.DarkFrameCheckListener)this.b.a.get()).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoFrameCheckHelper.1.1
 * JD-Core Version:    0.7.0.1
 */