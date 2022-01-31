package com.tencent.component.media.gif;

class NewGifDrawable$2
  extends SafeRunnable
{
  NewGifDrawable$2(NewGifDrawable paramNewGifDrawable1, NewGifDrawable paramNewGifDrawable2, int paramInt)
  {
    super(paramNewGifDrawable2);
  }
  
  public void doWork()
  {
    synchronized (this.this$0.mLock4Bmp)
    {
      this.this$0.mBuffer = this.this$0.mGifDecoder.seekToTime(this.val$position, this.this$0.mBuffer);
      if (!this.mGifDrawable.mInvalidationHandler.hasMessages(0)) {
        this.mGifDrawable.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.gif.NewGifDrawable.2
 * JD-Core Version:    0.7.0.1
 */