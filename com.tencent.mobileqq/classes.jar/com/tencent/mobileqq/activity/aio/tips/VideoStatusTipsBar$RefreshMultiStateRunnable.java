package com.tencent.mobileqq.activity.aio.tips;

import java.lang.ref.WeakReference;

class VideoStatusTipsBar$RefreshMultiStateRunnable
  implements Runnable
{
  final WeakReference<VideoStatusTipsBar> a;
  
  public VideoStatusTipsBar$RefreshMultiStateRunnable(VideoStatusTipsBar paramVideoStatusTipsBar)
  {
    this.a = new WeakReference(paramVideoStatusTipsBar);
  }
  
  public void run()
  {
    VideoStatusTipsBar localVideoStatusTipsBar = (VideoStatusTipsBar)this.a.get();
    if (localVideoStatusTipsBar != null) {
      localVideoStatusTipsBar.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar.RefreshMultiStateRunnable
 * JD-Core Version:    0.7.0.1
 */