package com.tencent.image;

import android.os.Handler;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class AbstractGifImage$DoAccumulativeRunnable
  extends ArgumentsRunnable<WeakReference<AbstractGifImage>>
{
  public static int DELAY = 100;
  private long lastRefreshTime = 0L;
  
  protected void run(List<WeakReference<AbstractGifImage>> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (WeakReference)paramList.next();
      if (localObject != null)
      {
        localObject = (AbstractGifImage)((WeakReference)localObject).get();
        if (localObject != null) {
          ((AbstractGifImage)localObject).doApplyNextFrame();
        }
      }
    }
    this.lastRefreshTime = SystemClock.uptimeMillis();
  }
  
  protected void submit()
  {
    long l1 = SystemClock.uptimeMillis();
    if (NativeGifImage.QZONE_DELAY == -1)
    {
      long l2 = this.lastRefreshTime;
      if ((l2 != 0L) && (l1 - l2 <= DELAY))
      {
        AbstractGifImage.sUIThreadHandler.postDelayed(this, DELAY - (l1 - this.lastRefreshTime));
        return;
      }
      run();
      this.lastRefreshTime = l1;
      return;
    }
    run();
    this.lastRefreshTime = l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.AbstractGifImage.DoAccumulativeRunnable
 * JD-Core Version:    0.7.0.1
 */