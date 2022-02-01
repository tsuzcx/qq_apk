package com.tencent.av.wtogether.media;

import java.lang.ref.WeakReference;
import java.util.TimerTask;

class WatchTogetherMediaPlayCtrl$TimeUpdateTimerTask
  extends TimerTask
{
  private WeakReference<WatchTogetherMediaPlayCtrl> a;
  
  WatchTogetherMediaPlayCtrl$TimeUpdateTimerTask(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl)
  {
    this.a = new WeakReference(paramWatchTogetherMediaPlayCtrl);
  }
  
  public void run()
  {
    if (this.a != null)
    {
      WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = (WatchTogetherMediaPlayCtrl)this.a.get();
      if (localWatchTogetherMediaPlayCtrl != null) {
        WatchTogetherMediaPlayCtrl.c(localWatchTogetherMediaPlayCtrl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl.TimeUpdateTimerTask
 * JD-Core Version:    0.7.0.1
 */