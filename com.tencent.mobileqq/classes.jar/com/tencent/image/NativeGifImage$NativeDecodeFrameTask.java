package com.tencent.image;

import android.os.Handler;
import android.os.SystemClock;

class NativeGifImage$NativeDecodeFrameTask
  implements Runnable
{
  final long mNextFrameTime;
  
  public NativeGifImage$NativeDecodeFrameTask(NativeGifImage paramNativeGifImage, long paramLong)
  {
    this.mNextFrameTime = paramLong;
  }
  
  public void run()
  {
    this.this$0.getNextFrame();
    if (this.this$0.mMetaData[NativeGifImage.FRAME_COUNT_INDEX] > 1)
    {
      long l = SystemClock.uptimeMillis();
      NativeGifImage.NativeDecodeFrameTask.1 local1 = new NativeGifImage.NativeDecodeFrameTask.1(this);
      if (l < this.mNextFrameTime)
      {
        AbstractGifImage.sUIThreadHandler.postDelayed(local1, this.mNextFrameTime - l);
        return;
      }
      AbstractGifImage.sUIThreadHandler.post(local1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.NativeGifImage.NativeDecodeFrameTask
 * JD-Core Version:    0.7.0.1
 */