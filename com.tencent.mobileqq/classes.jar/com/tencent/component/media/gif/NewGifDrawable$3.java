package com.tencent.component.media.gif;

class NewGifDrawable$3
  extends SafeRunnable
{
  NewGifDrawable$3(NewGifDrawable paramNewGifDrawable1, NewGifDrawable paramNewGifDrawable2, int paramInt)
  {
    super(paramNewGifDrawable2);
  }
  
  public void doWork()
  {
    synchronized (this.this$0.mLock4Bmp)
    {
      this.this$0.mBuffer = this.this$0.mGifDecoder.seekToFrame(this.val$frameIndex, this.this$0.mBuffer);
      if (!this.this$0.mInvalidationHandler.hasMessages(0)) {
        this.this$0.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.gif.NewGifDrawable.3
 * JD-Core Version:    0.7.0.1
 */