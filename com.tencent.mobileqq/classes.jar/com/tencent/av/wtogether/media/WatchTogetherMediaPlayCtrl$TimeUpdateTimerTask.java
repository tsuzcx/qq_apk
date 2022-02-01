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
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (WatchTogetherMediaPlayCtrl)((WeakReference)localObject).get();
      if (localObject != null) {
        WatchTogetherMediaPlayCtrl.c((WatchTogetherMediaPlayCtrl)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl.TimeUpdateTimerTask
 * JD-Core Version:    0.7.0.1
 */