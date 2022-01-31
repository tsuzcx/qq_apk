package com.tencent.image;

import android.os.Handler;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class NativeVideoImage$DoAccumulativeRunnable
  extends ArgumentsRunnable<WeakReference<NativeVideoImage.WrappedRefreshImg>>
{
  public int delay = 0;
  long lastRefreshTime = 0L;
  
  protected void run(List<WeakReference<NativeVideoImage.WrappedRefreshImg>> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (WeakReference)paramList.next();
      if (localObject != null)
      {
        localObject = (NativeVideoImage.WrappedRefreshImg)((WeakReference)localObject).get();
        if (localObject != null) {
          ((NativeVideoImage.WrappedRefreshImg)localObject).img.doApplyNextFrame(((NativeVideoImage.WrappedRefreshImg)localObject).refeshId);
        }
      }
    }
    this.lastRefreshTime = SystemClock.uptimeMillis();
  }
  
  protected void submit()
  {
    long l1 = SystemClock.uptimeMillis();
    if ((this.lastRefreshTime == 0L) || (l1 - this.lastRefreshTime >= this.delay))
    {
      run();
      this.lastRefreshTime = l1;
      return;
    }
    long l2 = this.delay;
    long l3 = this.lastRefreshTime;
    NativeVideoImage.sUIHandler.postDelayed(this, l2 - (l1 - l3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage.DoAccumulativeRunnable
 * JD-Core Version:    0.7.0.1
 */