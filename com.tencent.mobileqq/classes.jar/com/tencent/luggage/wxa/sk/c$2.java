package com.tencent.luggage.wxa.sk;

import android.os.Message;

class c$2
  implements d.b
{
  c$2(c paramc, Runnable paramRunnable) {}
  
  public boolean a(e parame)
  {
    parame = parame.k();
    boolean bool1 = parame instanceof c.a;
    boolean bool2 = false;
    boolean bool3 = false;
    if (bool1)
    {
      parame = (c.a)parame;
      bool1 = bool3;
      if (parame.a == this.b)
      {
        bool1 = bool3;
        if (c.a.a(parame).getCallback() == this.a) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        parame.b();
        bool2 = bool1;
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sk.c.2
 * JD-Core Version:    0.7.0.1
 */