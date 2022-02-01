package com.tencent.av.wtogether.media;

import com.tencent.av.utils.AVUtil;
import com.tencent.av.wtogether.WTDataReportUtil;
import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerStatusCallback;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.av.wtogether.data.WTogetherPlayInfo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class WatchTogetherMediaPlayCtrl$6
  implements Runnable
{
  WatchTogetherMediaPlayCtrl$6(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    WatchTogetherMediaPlayCtrl.a(this.this$0, 9);
    Object localObject = WatchTogetherMediaPlayCtrl.e(this.this$0).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((WatchTogetherMediaPlayerStatusCallback)localWeakReference.get()).a(this.a, this.b, this.c, this.d);
      }
    }
    localObject = WatchTogetherMediaPlayCtrl.f(this.this$0).a;
    AVUtil.a("0X800B62F", ((WTFileInfo)localObject).b(), 0, String.valueOf(this.c), WTDataReportUtil.c(), ((WTFileInfo)localObject).c(), ((WTFileInfo)localObject).d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl.6
 * JD-Core Version:    0.7.0.1
 */