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
    if (!PrepareAndRenderTask.access$000(this.this$0).tryAcquire()) {
      ImageManagerEnv.getLogger().w("PrepareAndRenderTask", new Object[] { "unRender false:no data to render,just return" });
    }
    for (;;)
    {
      return;
      this.this$0.mGifDrawable.mIsRenderingTriggeredOnDraw = true;
      NewGifDecoder.GifFrame localGifFrame = this.this$0.mGifDrawable.mGifDecoder.doRender(this.this$0.mGifDrawable.mBuffer);
      this.this$0.mGifDrawable.mBuffer = localGifFrame.image;
      PrepareAndRenderTask.access$102(this.this$0, localGifFrame.delay);
      this.this$0.mCurrentIndex = ((this.this$0.mCurrentIndex + 1) % this.this$0.mGifDrawable.getNumberOfFrames());
      PrepareAndRenderTask.access$200(this.this$0).release();
      if (PrepareAndRenderTask.access$100(this.this$0) >= 0L)
      {
        this.this$0.mGifDrawable.mNextFrameRenderTime = 0L;
        if ((!this.this$0.mGifDrawable.mListeners.isEmpty()) && (this.this$0.mGifDrawable.getCurrentFrameIndex() == this.this$0.mGifDrawable.getNumberOfFrames() - 1)) {
          this.this$0.mGifDrawable.scheduleSelf(this.this$0.mNotifyListenersTask, this.this$0.mGifDrawable.mNextFrameRenderTime);
        }
      }
      while ((this.this$0.mGifDrawable.isVisible()) && (!this.this$0.mGifDrawable.mInvalidationHandler.hasMessages(0)) && (this.this$0.mGifDrawable.getCallback() != null))
      {
        this.this$0.mGifDrawable.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        return;
        this.this$0.mGifDrawable.mNextFrameRenderTime = -9223372036854775808L;
        this.this$0.mGifDrawable.mIsRunning = false;
        ImageManagerEnv.getLogger().w("PrepareAndRenderTask", new Object[] { "decode error: invalidationDelay=" + PrepareAndRenderTask.access$100(this.this$0) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.gif.PrepareAndRenderTask.1
 * JD-Core Version:    0.7.0.1
 */