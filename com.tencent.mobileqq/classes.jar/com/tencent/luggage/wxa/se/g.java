package com.tencent.luggage.wxa.se;

import android.os.Handler;
import android.os.Looper;

public class g
  implements f
{
  private Handler a = new Handler(Looper.getMainLooper());
  
  public void execute(Runnable paramRunnable)
  {
    if (Thread.currentThread().getId() == this.a.getLooper().getThread().getId())
    {
      paramRunnable.run();
      return;
    }
    this.a.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.se.g
 * JD-Core Version:    0.7.0.1
 */