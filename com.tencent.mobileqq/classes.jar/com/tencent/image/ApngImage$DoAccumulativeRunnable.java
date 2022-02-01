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
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.lastRefreshTime;
    if ((l2 != 0L) && (l1 - l2 <= 25L))
    {
      ApngImage.access$100().postDelayed(this, 25L - (l1 - this.lastRefreshTime));
      return;
    }
    run();
    this.lastRefreshTime = l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.ApngImage.DoAccumulativeRunnable
 * JD-Core Version:    0.7.0.1
 */