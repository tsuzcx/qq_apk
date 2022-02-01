package com.tencent.luggage.wxa.rp;

import android.os.Handler;
import android.os.Looper;

public class b
  implements a
{
  private Handler a;
  
  public b(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public Looper a()
  {
    return this.a.getLooper();
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    this.a.postDelayed(paramRunnable, paramLong);
  }
  
  public void b()
  {
    this.a.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rp.b
 * JD-Core Version:    0.7.0.1
 */