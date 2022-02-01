package com.tencent.component.media.gif;

import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

class PrepareAndRenderTask$1
  implements Runnable
{
  PrepareAndRenderTask$1(PrepareAndRenderTask paramPrepareAndRenderTask) {}
  
  public void run()
  {
    if (!PrepareAndRenderTask.access$000(this.this$0).tryAcquire())
    {
      ImageManagerEnv.getLogger().w("PrepareAndRenderTask", new Object[] { "unRender false:no data to render,just return" });
      return;
    }
    this.this$0.mGifDrawable.mIsRenderingTriggeredOnDraw = true;
    Object localObject = this.this$0.mGifDrawable.mGifDecoder.doRender(this.this$0.mGifDrawable.mBuffer);
    this.this$0.mGifDrawable.mBuffer = ((NewGifDecoder.GifFrame)localObject).image;
    PrepareAndRenderTask.access$102(this.this$0, ((NewGifDecoder.GifFrame)localObject).delay);
    localObject = this.this$0;
    ((PrepareAndRenderTask)localObject).mCurrentIndex = ((((PrepareAndRenderTask)localObject).mCurrentIndex + 1) % this.this$0.mGifDrawable.getNumberOfFrames());
    PrepareAndRenderTask.access$200(this.this$0).release();
    if (PrepareAndRenderTask.access$100(this.this$0) >= 0L)
    {
      this.this$0.mGifDrawable.mNextFrameRenderTime = 0L;
      if ((!this.this$0.mGifDrawable.mListeners.isEmpty()) && (this.this$0.mGifDrawable.getCurrentFrameIndex() == this.this$0.mGifDrawable.getNumberOfFrames() - 1)) {
        this.this$0.mGifDrawable.scheduleSelf(this.this$0.mNotifyListenersTask, this.this$0.mGifDrawable.mNextFrameRenderTime);
      }
    }
    else
    {
      this.this$0.mGifDrawable.mNextFrameRenderTime = -9223372036854775808L;
      this.this$0.mGifDrawable.mIsRunning = false;
      localObject = ImageManagerEnv.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decode error: invalidationDelay=");
      localStringBuilder.append(PrepareAndRenderTask.access$100(this.this$0));
      ((ILog)localObject).w("PrepareAndRenderTask", new Object[] { localStringBuilder.toString() });
    }
    if ((this.this$0.mGifDrawable.isVisible()) && (!this.this$0.mGifDrawable.mInvalidationHandler.hasMessages(0)) && (this.this$0.mGifDrawable.getCallback() != null)) {
      this.this$0.mGifDrawable.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.gif.PrepareAndRenderTask.1
 * JD-Core Version:    0.7.0.1
 */