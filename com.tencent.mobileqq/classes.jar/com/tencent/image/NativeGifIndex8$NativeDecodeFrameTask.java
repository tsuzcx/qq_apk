package com.tencent.image;

import android.os.Handler;
import android.os.SystemClock;

class NativeGifIndex8$NativeDecodeFrameTask
  implements Runnable
{
  final long mNextFrameTime;
  
  public NativeGifIndex8$NativeDecodeFrameTask(NativeGifIndex8 paramNativeGifIndex8, long paramLong)
  {
    this.mNextFrameTime = paramLong;
  }
  
  public void run()
  {
    this.this$0.getNextFrame();
    if (this.this$0.mFrameNumber > 1)
    {
      long l = SystemClock.uptimeMillis();
      NativeGifIndex8.NativeDecodeFrameTask.1 local1 = new NativeGifIndex8.NativeDecodeFrameTask.1(this);
      if (l < this.mNextFrameTime)
      {
        AbstractGifImage.sUIThreadHandler.postDelayed(local1, this.mNextFrameTime - l);
        return;
      }
      AbstractGifImage.sUIThreadHandler.post(local1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.NativeGifIndex8.NativeDecodeFrameTask
 * JD-Core Version:    0.7.0.1
 */