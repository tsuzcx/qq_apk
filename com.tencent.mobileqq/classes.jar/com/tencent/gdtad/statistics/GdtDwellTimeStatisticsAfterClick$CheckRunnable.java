package com.tencent.gdtad.statistics;

import java.lang.ref.WeakReference;

final class GdtDwellTimeStatisticsAfterClick$CheckRunnable
  implements Runnable
{
  WeakReference<GdtDwellTimeStatisticsAfterClick> a;
  
  public GdtDwellTimeStatisticsAfterClick$CheckRunnable(WeakReference<GdtDwellTimeStatisticsAfterClick> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void run()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference != null)
    {
      if (localWeakReference.get() == null) {
        return;
      }
      GdtDwellTimeStatisticsAfterClick.a((GdtDwellTimeStatisticsAfterClick)this.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick.CheckRunnable
 * JD-Core Version:    0.7.0.1
 */