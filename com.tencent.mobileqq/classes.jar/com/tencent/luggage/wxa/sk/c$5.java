package com.tencent.luggage.wxa.sk;

import android.os.Message;

class c$5
  implements d.a
{
  c$5(c paramc, int paramInt) {}
  
  public boolean a(e parame)
  {
    parame = parame.k();
    boolean bool3 = parame instanceof c.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      parame = (c.a)parame;
      bool1 = bool2;
      if (parame.a == this.b)
      {
        bool1 = bool2;
        if (c.a.a(parame).what == this.a) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sk.c.5
 * JD-Core Version:    0.7.0.1
 */