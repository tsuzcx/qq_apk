package com.tencent.av.wtogether.media;

import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerStatusCallback;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class WatchTogetherMediaPlayCtrl$9
  implements Runnable
{
  WatchTogetherMediaPlayCtrl$9(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl) {}
  
  public void run()
  {
    WatchTogetherMediaPlayCtrl.a(this.this$0, 10);
    Iterator localIterator = WatchTogetherMediaPlayCtrl.e(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((WatchTogetherMediaPlayerStatusCallback)localWeakReference.get()).a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl.9
 * JD-Core Version:    0.7.0.1
 */