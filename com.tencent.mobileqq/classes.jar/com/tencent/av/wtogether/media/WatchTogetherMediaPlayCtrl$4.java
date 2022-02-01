package com.tencent.av.wtogether.media;

import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerStatusCallback;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.av.wtogether.data.WTogetherPlayInfo;
import com.tencent.av.wtogether.util.WatchTogetherDataReportHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class WatchTogetherMediaPlayCtrl$4
  implements Runnable
{
  WatchTogetherMediaPlayCtrl$4(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl, ISuperPlayer paramISuperPlayer) {}
  
  public void run()
  {
    if (WatchTogetherMediaPlayCtrl.a(this.this$0) == null) {
      return;
    }
    long l1 = this.a.getDurationMs();
    long l2 = this.a.getCurrentPositionMs();
    Object localObject = this.this$0;
    int i = (int)l1;
    WatchTogetherMediaPlayCtrl.a((WatchTogetherMediaPlayCtrl)localObject, i);
    localObject = WatchTogetherMediaPlayCtrl.a(this.this$0).a;
    WatchTogetherMediaPlayCtrl.a(this.this$0).a(((WTFileInfo)localObject).c(), WatchTogetherMediaPlayCtrl.a(this.this$0));
    localObject = WatchTogetherMediaPlayCtrl.a(this.this$0).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((WatchTogetherMediaPlayerStatusCallback)localWeakReference.get()).a(i);
      }
    }
    if (l1 - l2 <= 60000L)
    {
      QLog.d("WatchTogetherMediaPlayCtrl", 1, "onVideoPrepared, video less than 1 min, seek to 0");
      WatchTogetherMediaPlayCtrl.a(this.this$0).seekTo(0);
    }
    WatchTogetherMediaPlayCtrl.a(this.this$0).start();
    WatchTogetherMediaPlayCtrl.a(this.this$0, 5);
    localObject = WatchTogetherMediaPlayCtrl.b(this.this$0).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Runnable)((Iterator)localObject).next()).run();
    }
    WatchTogetherMediaPlayCtrl.b(this.this$0).clear();
    WatchTogetherMediaPlayCtrl.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl.4
 * JD-Core Version:    0.7.0.1
 */