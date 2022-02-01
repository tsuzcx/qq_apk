package com.tencent.luggage.wxa.pp;

import android.widget.EditText;
import com.tencent.luggage.wxa.mn.e;
import com.tencent.luggage.wxa.mn.e.f;
import com.tencent.luggage.wxa.qz.o;

class ah$2
  implements Runnable
{
  ah$2(ah paramah) {}
  
  public void run()
  {
    if (!ah.c(this.a)) {
      return;
    }
    e.f localf = e.a(this.a.a);
    if ((ah.d(this.a) != null) && (Math.abs(ah.d(this.a).b - localf.b) <= 1.0F) && (Math.abs(ah.d(this.a).c - localf.c) <= 1.0F))
    {
      if (ah.e(this.a) == null) {
        return;
      }
      ah.a(this.a, false);
      this.a.a.removeCallbacks(ah.f(this.a));
      return;
    }
    o.f(ah.a(this.a), "check long press timeout, but view has moved.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.ah.2
 * JD-Core Version:    0.7.0.1
 */