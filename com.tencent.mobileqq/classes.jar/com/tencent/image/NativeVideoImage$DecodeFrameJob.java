package com.tencent.image;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class NativeVideoImage$DecodeFrameJob
  implements Runnable
{
  final long mNextFrameTime;
  
  public NativeVideoImage$DecodeFrameJob(NativeVideoImage paramNativeVideoImage, long paramLong)
  {
    this.mNextFrameTime = paramLong;
  }
  
  public void run()
  {
    if (this.this$0.getNextFrame())
    {
      long l = SystemClock.uptimeMillis();
      NativeVideoImage.RefreshJob localRefreshJob = new NativeVideoImage.RefreshJob(this.this$0, NativeVideoImage.access$100(this.this$0).get());
      if (l < this.mNextFrameTime)
      {
        NativeVideoImage.sUIHandler.postDelayed(localRefreshJob, this.mNextFrameTime - l);
        NativeVideoImage.access$200(this.this$0).onVideoFrameDroped(false, -1);
        if ((QLog.isColorLevel()) && (this.this$0.debug)) {
          QLog.d(NativeVideoImage.TAG + NativeVideoImage.access$000(this.this$0), 2, "after getFrame, now < mNextFrameTime, delay:" + (this.mNextFrameTime - l) + "ms, index=" + NativeVideoImage.access$100(this.this$0).get());
        }
      }
      do
      {
        return;
        NativeVideoImage.sUIHandler.post(localRefreshJob);
        NativeVideoImage.access$200(this.this$0).onVideoFrameDroped(true, (int)(l - this.mNextFrameTime));
      } while (!QLog.isColorLevel());
      QLog.w(NativeVideoImage.TAG + NativeVideoImage.access$000(this.this$0), 2, "after getFrame, now > mNextFrameTime, delayedTime=" + (l - this.mNextFrameTime) + "ms, index=" + NativeVideoImage.access$100(this.this$0).get());
      return;
    }
    this.this$0.mDecodeNextFrameEnd = true;
    QLog.e(NativeVideoImage.TAG + NativeVideoImage.access$000(this.this$0), 1, "after getFrame, return false ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage.DecodeFrameJob
 * JD-Core Version:    0.7.0.1
 */