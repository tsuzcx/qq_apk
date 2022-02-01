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
      FastAnimationDrawable.b(this.this$0).set(FastAnimationDrawable.b(this.this$0).incrementAndGet() % FastAnimationDrawable.c(this.this$0).size());
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("LoopReadWriteRunnable index:");
        ((StringBuilder)localObject1).append(FastAnimationDrawable.b(this.this$0).get());
        QLog.d("FastAnimationDrawable", 2, ((StringBuilder)localObject1).toString());
      }
      if ((this.this$0.b != null) && (this.this$0.b.get(Integer.valueOf(FastAnimationDrawable.b(this.this$0).get())) != null))
      {
        localObject1 = this.this$0;
        FastAnimationDrawable.a((FastAnimationDrawable)localObject1, (BitmapDrawable)((FastAnimationDrawable)localObject1).b.get(Integer.valueOf(FastAnimationDrawable.b(this.this$0).get())));
        try
        {
          Thread.sleep(FastAnimationDrawable.d(this.this$0));
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        FastAnimationDrawable.e(this.this$0).sendEmptyMessage(0);
      }
      else
      {
        long l = System.currentTimeMillis();
        Object localObject2 = this.this$0;
        localObject2 = FastAnimationDrawable.a((FastAnimationDrawable)localObject2, (String)FastAnimationDrawable.c((FastAnimationDrawable)localObject2).get(FastAnimationDrawable.b(this.this$0).get()));
        if (localObject2 != null)
        {
          l = System.currentTimeMillis() - l;
          FastAnimationDrawable.a(this.this$0, (BitmapDrawable)localObject2);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("LoopReadWriteRunnable decodeBitmap index:");
            localStringBuilder.append(FastAnimationDrawable.b(this.this$0).get());
            localStringBuilder.append(" cost:");
            localStringBuilder.append(l);
            localStringBuilder.append(" delay:");
            localStringBuilder.append(FastAnimationDrawable.d(this.this$0));
            QLog.d("FastAnimationDrawable", 2, localStringBuilder.toString());
          }
          this.this$0.b.put(Integer.valueOf(FastAnimationDrawable.b(this.this$0).get()), localObject2);
          if ((this.this$0.b.size() == FastAnimationDrawable.c(this.this$0).size()) && (FastAnimationDrawable.f(this.this$0) != null) && (this.this$0.b.size() <= ((IGifAntishakeApi)QRoute.api(IGifAntishakeApi.class)).getMaxGifAntishakeFrameNum())) {
            FastAnimationDrawable.f(this.this$0).a(this.this$0.b);
          }
          if (!FastAnimationDrawable.e(this.this$0).hasMessages(0)) {
            if (FastAnimationDrawable.d(this.this$0) > l) {
              FastAnimationDrawable.e(this.this$0).sendEmptyMessageDelayed(0, FastAnimationDrawable.d(this.this$0) - l);
            } else {
              FastAnimationDrawable.e(this.this$0).sendEmptyMessage(0);
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