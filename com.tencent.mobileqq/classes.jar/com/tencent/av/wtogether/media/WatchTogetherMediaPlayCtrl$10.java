package com.tencent.av.wtogether.media;

import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerStatusCallback;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.av.wtogether.data.WTogetherPlayInfo;
import com.tencent.av.wtogether.util.WatchTogetherDataReportHelper;
import com.tencent.superplayer.api.ISuperPlayer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class WatchTogetherMediaPlayCtrl$10
  implements Runnable
{
  WatchTogetherMediaPlayCtrl$10(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl) {}
  
  public void run()
  {
    if ((!WatchTogetherMediaPlayCtrl.a(this.this$0)) && (WatchTogetherMediaPlayCtrl.b(this.this$0)))
    {
      Object localObject = WatchTogetherMediaPlayCtrl.a(this.this$0);
      Iterator localIterator = WatchTogetherMediaPlayCtrl.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((WatchTogetherMediaPlayCtrl.a(this.this$0) != null) && (localWeakReference != null) && (localWeakReference.get() != null))
        {
          ((WatchTogetherMediaPlayerStatusCallback)localWeakReference.get()).a((int)((ISuperPlayer)localObject).getCurrentPositionMs(), (int)((ISuperPlayer)localObject).getDurationMs());
          ((WatchTogetherMediaPlayerStatusCallback)localWeakReference.get()).b((int)((ISuperPlayer)localObject).getCurrentPositionMs(), (int)((ISuperPlayer)localObject).getDurationMs());
        }
      }
      if (this.this$0.a())
      {
        localObject = WatchTogetherMediaPlayCtrl.a(this.this$0).a.c();
        WatchTogetherMediaPlayCtrl.a(this.this$0).a((String)localObject, WatchTogetherMediaPlayCtrl.a(this.this$0));
        WatchTogetherMediaPlayCtrl.a(this.this$0).b((String)localObject, 200);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl.10
 * JD-Core Version:    0.7.0.1
 */