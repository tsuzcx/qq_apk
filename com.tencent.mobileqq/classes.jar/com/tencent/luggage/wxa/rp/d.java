package com.tencent.luggage.wxa.rp;

import android.os.Looper;
import com.tencent.luggage.wxa.rq.a;
import com.tencent.luggage.wxa.rq.b;

public abstract class d
{
  public static final h a = new h(Looper.getMainLooper(), "Vending.UI");
  public static final h b = new h(b.a().b(), "Vending.LOGIC");
  public static final h c = new h(a.a().b(), "Vending.HEAVY_WORK");
  
  static
  {
    g.b();
  }
  
  public abstract void a();
  
  public abstract void a(Runnable paramRunnable);
  
  public abstract void a(Runnable paramRunnable, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rp.d
 * JD-Core Version:    0.7.0.1
 */