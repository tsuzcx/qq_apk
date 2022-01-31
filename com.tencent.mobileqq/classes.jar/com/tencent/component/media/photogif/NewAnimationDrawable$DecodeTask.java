package com.tencent.component.media.photogif;

import android.os.Handler;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.utils.LruCache;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

class NewAnimationDrawable$DecodeTask
  implements Comparable<DecodeTask>, Runnable
{
  private NewAnimationDrawable$DecodeTask(NewAnimationDrawable paramNewAnimationDrawable) {}
  
  public int compareTo(DecodeTask paramDecodeTask)
  {
    return 0;
  }
  
  public void run()
  {
    long l = 0L;
    if (!this.this$0.canAnimate())
    {
      NewAnimationDrawable.access$300(this.this$0).removeMessages(0);
      NewAnimationDrawable.access$300(this.this$0).sendEmptyMessageDelayed(0, NewAnimationDrawable.access$400(this.this$0));
      ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "canAnimate:false,so don't invalidate" });
    }
    Object localObject2;
    int i;
    label286:
    label297:
    Object localObject4;
    do
    {
      return;
      if (!NewAnimationDrawable.access$500(this.this$0))
      {
        ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "DecodeTask:mIsRunning=false, return" });
        return;
      }
      if ((NewAnimationDrawable.access$600(this.this$0) == -1) || (NewAnimationDrawable.access$600(this.this$0) >= NewAnimationDrawable.access$700(this.this$0).photoList.size())) {
        NewAnimationDrawable.access$602(this.this$0, 0);
      }
      localObject2 = (String)NewAnimationDrawable.access$700(this.this$0).photoList.get(NewAnimationDrawable.access$600(this.this$0));
      ??? = (BitmapReference)NewAnimationDrawable.access$800(this.this$0).get(localObject2);
      if (NewAnimationDrawable.access$100(this.this$0) == null)
      {
        i = 1;
        if (??? == null) {
          break label297;
        }
        NewAnimationDrawable.access$202(this.this$0, (BitmapReference)???);
        NewAnimationDrawable.access$300(this.this$0).removeMessages(0);
        ??? = NewAnimationDrawable.access$300(this.this$0);
        if (i == 0) {
          break label286;
        }
      }
      for (l = 0L;; l = NewAnimationDrawable.access$400(this.this$0))
      {
        ((Handler)???).sendEmptyMessageDelayed(0, l);
        ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "get from cache: index=" + NewAnimationDrawable.access$600(this.this$0) });
        return;
        i = 0;
        break;
      }
      localObject4 = NewAnimationDrawable.access$900(this.this$0, (String)localObject2);
    } while (localObject4 == null);
    for (;;)
    {
      synchronized (NewAnimationDrawable.access$800(this.this$0))
      {
        NewAnimationDrawable.access$202(this.this$0, (BitmapReference)localObject4);
        NewAnimationDrawable.access$800(this.this$0).put(localObject2, localObject4);
        localObject4 = new NewAnimationDrawable.FrameRef((BitmapReference)localObject4);
        NewAnimationDrawable.access$1000(this.this$0).put(localObject2, new WeakReference(localObject4));
        NewAnimationDrawable.access$300(this.this$0).removeMessages(0);
        localObject2 = NewAnimationDrawable.access$300(this.this$0);
        if (i != 0)
        {
          ((Handler)localObject2).sendEmptyMessageDelayed(0, l);
          ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "get from decoder:index=" + NewAnimationDrawable.access$600(this.this$0) });
          return;
        }
      }
      l = NewAnimationDrawable.access$400(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.photogif.NewAnimationDrawable.DecodeTask
 * JD-Core Version:    0.7.0.1
 */