package com.tencent.av.wtogether.media;

import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.superplayer.api.ISuperPlayer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import myk;
import myv;
import naf;

class WatchTogetherMediaPlayCtrl$3
  implements Runnable
{
  WatchTogetherMediaPlayCtrl$3(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl, ISuperPlayer paramISuperPlayer) {}
  
  public void run()
  {
    long l = this.a.getDurationMs();
    WatchTogetherMediaPlayCtrl.a(this.this$0, (int)l);
    Object localObject = WatchTogetherMediaPlayCtrl.a(this.this$0).a;
    WatchTogetherMediaPlayCtrl.a(this.this$0).a(((WTFileInfo)localObject).c(), WatchTogetherMediaPlayCtrl.a(this.this$0));
    localObject = WatchTogetherMediaPlayCtrl.a(this.this$0).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((myk)localWeakReference.get()).a((int)l);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl.3
 * JD-Core Version:    0.7.0.1
 */