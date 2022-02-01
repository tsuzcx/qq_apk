package com.tencent.luggage.wxa.ct;

import com.tencent.luggage.wxa.dq.c;
import com.tencent.luggage.wxa.oi.f;

class e$1
  implements Runnable
{
  e$1(e parame, c paramc) {}
  
  public void run()
  {
    f localf = (f)this.a.d(f.class);
    if (localf != null)
    {
      localf.b(true);
      localf.a(false);
    }
    else if (this.a.L())
    {
      localf.b(true);
    }
    this.a.aB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.e.1
 * JD-Core Version:    0.7.0.1
 */