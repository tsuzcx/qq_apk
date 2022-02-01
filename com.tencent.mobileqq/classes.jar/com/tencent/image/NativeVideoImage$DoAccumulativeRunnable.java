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
    long l2 = this.lastRefreshTime;
    if (l2 != 0L)
    {
      int i = this.delay;
      if (l1 - l2 < i)
      {
        long l3 = i;
        NativeVideoImage.sUIHandler.postDelayed(this, l3 - (l1 - l2));
        return;
      }
    }
    run();
    this.lastRefreshTime = l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage.DoAccumulativeRunnable
 * JD-Core Version:    0.7.0.1
 */