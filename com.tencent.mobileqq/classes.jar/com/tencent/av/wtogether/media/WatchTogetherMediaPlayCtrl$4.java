package com.tencent.av.wtogether.media;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import myk;

class WatchTogetherMediaPlayCtrl$4
  implements Runnable
{
  WatchTogetherMediaPlayCtrl$4(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl, int paramInt, long paramLong1, long paramLong2, Object paramObject) {}
  
  public void run()
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      Iterator localIterator = WatchTogetherMediaPlayCtrl.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((myk)localWeakReference.get()).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.b, this.jdField_a_of_type_JavaLangObject);
        }
      }
      WatchTogetherMediaPlayCtrl.b(this.this$0, 3);
      continue;
      WatchTogetherMediaPlayCtrl.b(this.this$0, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl.4
 * JD-Core Version:    0.7.0.1
 */