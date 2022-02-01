package com.tencent.component.media.gif;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class NewGifDrawable$WaitRunnable
  implements Runnable
{
  long lastFrameRemainder;
  
  public NewGifDrawable$WaitRunnable(NewGifDrawable paramNewGifDrawable, long paramLong)
  {
    this.lastFrameRemainder = paramLong;
  }
  
  public void run()
  {
    NewGifDrawable.access$000(this.this$0);
    NewGifDrawable localNewGifDrawable = this.this$0;
    ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = localNewGifDrawable.mExecutor;
    RenderTask localRenderTask = NewGifDrawable.access$200(this.this$0);
    long l = this.lastFrameRemainder;
    if (l <= 0L) {
      l = 0L;
    }
    localNewGifDrawable.mSchedule = localScheduledThreadPoolExecutor.schedule(localRenderTask, l, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.gif.NewGifDrawable.WaitRunnable
 * JD-Core Version:    0.7.0.1
 */