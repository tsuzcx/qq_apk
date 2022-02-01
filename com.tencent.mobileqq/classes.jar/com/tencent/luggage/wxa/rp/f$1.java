package com.tencent.luggage.wxa.rp;

import com.tencent.luggage.wxa.rl.a;
import com.tencent.luggage.wxa.rl.b;

class f$1
  implements Runnable
{
  f$1(f paramf, b paramb, Object paramObject, RuntimeException paramRuntimeException) {}
  
  public void run()
  {
    if (f.a(this.d) != null) {
      f.a(this.d).a();
    }
    try
    {
      Object localObject = a.a(this.a, this.b);
      if (f.a(this.d) != null) {
        f.a(this.d).a(localObject);
      }
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      this.c.initCause(localClassCastException);
      throw this.c;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rp.f.1
 * JD-Core Version:    0.7.0.1
 */