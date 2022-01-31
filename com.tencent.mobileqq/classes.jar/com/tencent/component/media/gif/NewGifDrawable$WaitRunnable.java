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
    long l = 0L;
    NewGifDrawable.access$000(this.this$0);
    NewGifDrawable localNewGifDrawable = this.this$0;
    ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = this.this$0.mExecutor;
    RenderTask localRenderTask = NewGifDrawable.access$200(this.this$0);
    if (this.lastFrameRemainder > 0L) {
      l = this.lastFrameRemainder;
    }
    localNewGifDrawable.mSchedule = localScheduledThreadPoolExecutor.schedule(localRenderTask, l, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.gif.NewGifDrawable.WaitRunnable
 * JD-Core Version:    0.7.0.1
 */