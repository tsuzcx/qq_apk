package com.tencent.image;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
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
    Object localObject1;
    Object localObject2;
    if (this.this$0.getNextFrame())
    {
      long l = SystemClock.uptimeMillis();
      localObject1 = this.this$0;
      localObject1 = new NativeVideoImage.RefreshJob((NativeVideoImage)localObject1, NativeVideoImage.access$100((NativeVideoImage)localObject1).get());
      StringBuilder localStringBuilder;
      if (l < this.mNextFrameTime)
      {
        NativeVideoImage.sUIHandler.postDelayed((Runnable)localObject1, this.mNextFrameTime - l);
        NativeVideoImage.access$200(this.this$0).onVideoFrameDroped(false, -1);
        if ((URLDrawable.depImp.mLog.isColorLevel()) && (this.this$0.debug))
        {
          localObject1 = URLDrawable.depImp.mLog;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(NativeVideoImage.TAG);
          ((StringBuilder)localObject2).append(NativeVideoImage.access$000(this.this$0));
          localObject2 = ((StringBuilder)localObject2).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("after getFrame, now < mNextFrameTime, delay:");
          localStringBuilder.append(this.mNextFrameTime - l);
          localStringBuilder.append("ms, index=");
          localStringBuilder.append(NativeVideoImage.access$100(this.this$0).get());
          ((ILog)localObject1).d((String)localObject2, 2, localStringBuilder.toString());
        }
      }
      else
      {
        NativeVideoImage.sUIHandler.post((Runnable)localObject1);
        NativeVideoImage.access$200(this.this$0).onVideoFrameDroped(true, (int)(l - this.mNextFrameTime));
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          localObject1 = URLDrawable.depImp.mLog;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(NativeVideoImage.TAG);
          ((StringBuilder)localObject2).append(NativeVideoImage.access$000(this.this$0));
          localObject2 = ((StringBuilder)localObject2).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("after getFrame, now > mNextFrameTime, delayedTime=");
          localStringBuilder.append(l - this.mNextFrameTime);
          localStringBuilder.append("ms, index=");
          localStringBuilder.append(NativeVideoImage.access$100(this.this$0).get());
          ((ILog)localObject1).w((String)localObject2, 2, localStringBuilder.toString());
        }
      }
    }
    else
    {
      this.this$0.mDecodeNextFrameEnd = true;
      localObject1 = URLDrawable.depImp.mLog;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(NativeVideoImage.TAG);
      ((StringBuilder)localObject2).append(NativeVideoImage.access$000(this.this$0));
      ((ILog)localObject1).e(((StringBuilder)localObject2).toString(), 1, "after getFrame, return false ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage.DecodeFrameJob
 * JD-Core Version:    0.7.0.1
 */