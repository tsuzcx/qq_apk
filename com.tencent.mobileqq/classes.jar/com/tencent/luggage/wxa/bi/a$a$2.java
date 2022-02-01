package com.tencent.luggage.wxa.bi;

import com.tencent.luggage.wxa.iu.d;

class a$a$2
  implements Runnable
{
  a$a$2(a.a parama) {}
  
  public void run()
  {
    if (a.b(this.a.f) != null)
    {
      com.tencent.mm.plugin.appbrand.ui.a.a(a.b(this.a.f));
      a.a(this.a.f, null);
    }
    a.a(this.a.f, this.a.a, this.a.b);
    if (a.c(this.a.f))
    {
      a.d(this.a.f);
      a.a(this.a.f, false);
    }
    else if (a.e(this.a.f))
    {
      d locald = this.a.f.getActiveRuntime();
      if ((locald != null) && (!locald.aQ())) {
        a.f(this.a.f);
      }
    }
    this.a.f.a(this.a.a, this.a.d, this.a.b);
    if (this.a.e != null) {
      this.a.e.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bi.a.a.2
 * JD-Core Version:    0.7.0.1
 */