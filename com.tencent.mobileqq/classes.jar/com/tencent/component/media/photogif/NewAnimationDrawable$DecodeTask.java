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
    if (!this.this$0.canAnimate())
    {
      NewAnimationDrawable.access$300(this.this$0).removeMessages(0);
      NewAnimationDrawable.access$300(this.this$0).sendEmptyMessageDelayed(0, NewAnimationDrawable.access$400(this.this$0));
      ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "canAnimate:false,so don't invalidate" });
      return;
    }
    if (!NewAnimationDrawable.access$500(this.this$0))
    {
      ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "DecodeTask:mIsRunning=false, return" });
      return;
    }
    if ((NewAnimationDrawable.access$600(this.this$0) == -1) || (NewAnimationDrawable.access$600(this.this$0) >= NewAnimationDrawable.access$700(this.this$0).photoList.size())) {
      NewAnimationDrawable.access$602(this.this$0, 0);
    }
    Object localObject2 = (String)NewAnimationDrawable.access$700(this.this$0).photoList.get(NewAnimationDrawable.access$600(this.this$0));
    ??? = (BitmapReference)NewAnimationDrawable.access$800(this.this$0).get(localObject2);
    int i;
    if (NewAnimationDrawable.access$100(this.this$0) == null) {
      i = 1;
    } else {
      i = 0;
    }
    long l = 0L;
    if (??? != null)
    {
      NewAnimationDrawable.access$202(this.this$0, (BitmapReference)???);
      NewAnimationDrawable.access$300(this.this$0).removeMessages(0);
      ??? = NewAnimationDrawable.access$300(this.this$0);
      if (i == 0) {
        l = NewAnimationDrawable.access$400(this.this$0);
      }
      ((Handler)???).sendEmptyMessageDelayed(0, l);
      ??? = ImageManagerEnv.getLogger();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("get from cache: index=");
      ((StringBuilder)localObject2).append(NewAnimationDrawable.access$600(this.this$0));
      ((ILog)???).d("NewAnimationDrawable", new Object[] { ((StringBuilder)localObject2).toString() });
      return;
    }
    Object localObject4 = NewAnimationDrawable.access$900(this.this$0, (String)localObject2);
    if (localObject4 != null) {
      synchronized (NewAnimationDrawable.access$800(this.this$0))
      {
        NewAnimationDrawable.access$202(this.this$0, (BitmapReference)localObject4);
        NewAnimationDrawable.access$800(this.this$0).put(localObject2, localObject4);
        localObject4 = new NewAnimationDrawable.FrameRef((BitmapReference)localObject4);
        NewAnimationDrawable.access$1000(this.this$0).put(localObject2, new WeakReference(localObject4));
        NewAnimationDrawable.access$300(this.this$0).removeMessages(0);
        localObject2 = NewAnimationDrawable.access$300(this.this$0);
        if (i == 0) {
          l = NewAnimationDrawable.access$400(this.this$0);
        }
        ((Handler)localObject2).sendEmptyMessageDelayed(0, l);
        localObject2 = ImageManagerEnv.getLogger();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("get from decoder:index=");
        ((StringBuilder)localObject4).append(NewAnimationDrawable.access$600(this.this$0));
        ((ILog)localObject2).d("NewAnimationDrawable", new Object[] { ((StringBuilder)localObject4).toString() });
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.photogif.NewAnimationDrawable.DecodeTask
 * JD-Core Version:    0.7.0.1
 */