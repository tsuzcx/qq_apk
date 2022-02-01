package com.tencent.luggage.wxa.ga;

import com.tencent.luggage.wxa.qz.o;

class a$9
  implements Runnable
{
  a$9(a parama, String paramString) {}
  
  public void run()
  {
    if (a.i(this.b) == null)
    {
      o.c(a.b(this.b), "run#operate, adapter is null");
      return;
    }
    a.i(this.b).a(this.a, null);
    a.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ga.a.9
 * JD-Core Version:    0.7.0.1
 */