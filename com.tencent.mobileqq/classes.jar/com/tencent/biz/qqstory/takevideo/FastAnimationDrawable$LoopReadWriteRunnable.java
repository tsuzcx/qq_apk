package com.tencent.biz.qqstory.takevideo;

import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IGifAntishakeApi;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class FastAnimationDrawable$LoopReadWriteRunnable
  implements Runnable
{
  public FastAnimationDrawable$LoopReadWriteRunnable(FastAnimationDrawable paramFastAnimationDrawable) {}
  
  public void run()
  {
    while (this.this$0.isRunning())
    {
      FastAnimationDrawable.a(this.this$0).set(FastAnimationDrawable.a(this.this$0).incrementAndGet() % FastAnimationDrawable.a(this.this$0).size());
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("LoopReadWriteRunnable index:");
        ((StringBuilder)localObject1).append(FastAnimationDrawable.a(this.this$0).get());
        QLog.d("FastAnimationDrawable", 2, ((StringBuilder)localObject1).toString());
      }
      if ((this.this$0.a != null) && (this.this$0.a.get(Integer.valueOf(FastAnimationDrawable.a(this.this$0).get())) != null))
      {
        localObject1 = this.this$0;
        FastAnimationDrawable.a((FastAnimationDrawable)localObject1, (BitmapDrawable)((FastAnimationDrawable)localObject1).a.get(Integer.valueOf(FastAnimationDrawable.a(this.this$0).get())));
        try
        {
          Thread.sleep(FastAnimationDrawable.a(this.this$0));
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        FastAnimationDrawable.a(this.this$0).sendEmptyMessage(0);
      }
      else
      {
        long l = System.currentTimeMillis();
        Object localObject2 = this.this$0;
        localObject2 = FastAnimationDrawable.a((FastAnimationDrawable)localObject2, (String)FastAnimationDrawable.a((FastAnimationDrawable)localObject2).get(FastAnimationDrawable.a(this.this$0).get()));
        if (localObject2 != null)
        {
          l = System.currentTimeMillis() - l;
          FastAnimationDrawable.a(this.this$0, (BitmapDrawable)localObject2);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("LoopReadWriteRunnable decodeBitmap index:");
            localStringBuilder.append(FastAnimationDrawable.a(this.this$0).get());
            localStringBuilder.append(" cost:");
            localStringBuilder.append(l);
            localStringBuilder.append(" delay:");
            localStringBuilder.append(FastAnimationDrawable.a(this.this$0));
            QLog.d("FastAnimationDrawable", 2, localStringBuilder.toString());
          }
          this.this$0.a.put(Integer.valueOf(FastAnimationDrawable.a(this.this$0).get()), localObject2);
          if ((this.this$0.a.size() == FastAnimationDrawable.a(this.this$0).size()) && (FastAnimationDrawable.a(this.this$0) != null) && (this.this$0.a.size() <= ((IGifAntishakeApi)QRoute.api(IGifAntishakeApi.class)).getMaxGifAntishakeFrameNum())) {
            FastAnimationDrawable.a(this.this$0).a(this.this$0.a);
          }
          if (!FastAnimationDrawable.a(this.this$0).hasMessages(0)) {
            if (FastAnimationDrawable.a(this.this$0) > l) {
              FastAnimationDrawable.a(this.this$0).sendEmptyMessageDelayed(0, FastAnimationDrawable.a(this.this$0) - l);
            } else {
              FastAnimationDrawable.a(this.this$0).sendEmptyMessage(0);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.FastAnimationDrawable.LoopReadWriteRunnable
 * JD-Core Version:    0.7.0.1
 */