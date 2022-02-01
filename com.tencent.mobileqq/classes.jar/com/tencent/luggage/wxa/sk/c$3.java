package com.tencent.luggage.wxa.sk;

import android.os.Message;

class c$3
  implements d.b
{
  c$3(c paramc, int paramInt) {}
  
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
        if (c.a.a(parame).what == this.a) {
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
 * Qualified Name:     com.tencent.luggage.wxa.sk.c.3
 * JD-Core Version:    0.7.0.1
 */