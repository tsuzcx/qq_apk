package com.tencent.avgame.business.observer;

import android.os.Handler;
import android.os.Looper;
import mqq.os.MqqHandler;

public class WrapperHandler
{
  private final MqqHandler a;
  private final Handler b;
  
  public WrapperHandler(Looper paramLooper)
  {
    this.a = new MqqHandler(paramLooper);
    this.b = new Handler(paramLooper);
  }
  
  public WrapperHandler(MqqHandler paramMqqHandler)
  {
    this.a = paramMqqHandler;
    this.b = new Handler(paramMqqHandler.getLooper());
  }
  
  public final boolean a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.b.postAtFrontOfQueue(paramRunnable);
    }
    return this.a.postAtFrontOfQueue(paramRunnable);
  }
  
  public final boolean b(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.b.post(paramRunnable);
    }
    return this.a.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.observer.WrapperHandler
 * JD-Core Version:    0.7.0.1
 */