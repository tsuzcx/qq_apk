package com.tencent.image;

import android.os.Handler;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class ApngImage$DoAccumulativeRunnable
  extends ArgumentsRunnable<WeakReference<ApngImage>>
{
  private long lastRefreshTime = 0L;
  
  protected void run(List<WeakReference<ApngImage>> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (WeakReference)paramList.next();
      if (localObject != null)
      {
        localObject = (ApngImage)((WeakReference)localObject).get();
        if (localObject != null) {
          ((ApngImage)localObject).doApplyNextFrame();
        }
      }
    }
    this.lastRefreshTime = SystemClock.uptimeMillis();
  }
  
  protected void submit()
  {
    long l = SystemClock.uptimeMillis();
    if ((this.lastRefreshTime == 0L) || (l - this.lastRefreshTime > 25L))
    {
      run();
      this.lastRefreshTime = l;
      return;
    }
    ApngImage.access$100().postDelayed(this, 25L - (l - this.lastRefreshTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.ApngImage.DoAccumulativeRunnable
 * JD-Core Version:    0.7.0.1
 */