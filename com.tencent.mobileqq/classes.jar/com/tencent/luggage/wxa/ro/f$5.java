package com.tencent.luggage.wxa.ro;

import android.util.Pair;
import com.tencent.luggage.wxa.rl.b;

class f$5
  implements b<Void, Void>
{
  f$5(f paramf, Pair paramPair, Object paramObject, RuntimeException paramRuntimeException) {}
  
  public Void a(Void paramVoid)
  {
    try
    {
      ((e.c)this.a.first).a(this.b);
      return g;
    }
    catch (ClassCastException paramVoid)
    {
      if (this.c.getCause() == null) {
        this.c.initCause(paramVoid);
      }
      throw this.c;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ro.f.5
 * JD-Core Version:    0.7.0.1
 */