package com.tencent.av.wtogether.media;

import com.tencent.av.wtogether.data.WTFileInfo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mrr;
import myk;
import myv;

class WatchTogetherMediaPlayCtrl$5
  implements Runnable
{
  WatchTogetherMediaPlayCtrl$5(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    WatchTogetherMediaPlayCtrl.a(this.this$0, 9);
    Object localObject = WatchTogetherMediaPlayCtrl.a(this.this$0).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((myk)localWeakReference.get()).a(this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_JavaLangString);
      }
    }
    localObject = WatchTogetherMediaPlayCtrl.a(this.this$0).a;
    mrr.a("0X800B62F", ((WTFileInfo)localObject).a(), 0, String.valueOf(this.c), "", ((WTFileInfo)localObject).a(), ((WTFileInfo)localObject).b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl.5
 * JD-Core Version:    0.7.0.1
 */