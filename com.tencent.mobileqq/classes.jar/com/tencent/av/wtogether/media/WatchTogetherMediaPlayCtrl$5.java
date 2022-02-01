package com.tencent.av.wtogether.media;

import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerStatusCallback;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class WatchTogetherMediaPlayCtrl$5
  implements Runnable
{
  WatchTogetherMediaPlayCtrl$5(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl, int paramInt, long paramLong1, long paramLong2, Object paramObject) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 112)
    {
      if (i == 113) {
        WatchTogetherMediaPlayCtrl.b(this.this$0, 11);
      }
    }
    else {
      WatchTogetherMediaPlayCtrl.b(this.this$0, 3);
    }
    Iterator localIterator = WatchTogetherMediaPlayCtrl.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((WatchTogetherMediaPlayerStatusCallback)localWeakReference.get()).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.b, this.jdField_a_of_type_JavaLangObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl.5
 * JD-Core Version:    0.7.0.1
 */