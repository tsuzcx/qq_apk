package com.tencent.luggage.wxa.si;

import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.wxa.sj.i;
import java.util.concurrent.TimeUnit;

class f$a
  implements a.a
{
  private Handler a = new f.a.1(this, Looper.getMainLooper());
  
  public void a(i<?> parami)
  {
    this.a.postDelayed(parami, parami.getDelay(TimeUnit.MILLISECONDS));
  }
  
  void a(Runnable paramRunnable)
  {
    this.a.removeCallbacks(paramRunnable);
  }
  
  public void b(i<?> parami)
  {
    this.a.postAtFrontOfQueue(parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.si.f.a
 * JD-Core Version:    0.7.0.1
 */