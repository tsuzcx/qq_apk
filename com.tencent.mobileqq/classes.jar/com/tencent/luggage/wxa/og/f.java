package com.tencent.luggage.wxa.og;

import com.tencent.luggage.wxa.hv.g;
import com.tencent.luggage.wxa.hv.i;
import com.tencent.luggage.wxa.oe.b;
import com.tencent.luggage.wxa.oe.c;
import com.tencent.luggage.wxa.qz.o;

public class f
  extends b
{
  public int a()
  {
    return 4;
  }
  
  public void a(i parami, c paramc)
  {
    try
    {
      int i = parami.getInt("level");
      parami = parami.optString("message");
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            o.e("MicroMsg.NodeJs", parami);
            return;
          }
          o.b("MicroMsg.NodeJs", parami);
          return;
        }
        o.c("MicroMsg.NodeJs", parami);
        return;
      }
      o.d("MicroMsg.NodeJs", parami);
      return;
    }
    catch (g parami)
    {
      o.b("MicroMsg.NodeToXLog", "execute exception : %s", new Object[] { parami });
      paramc.a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.og.f
 * JD-Core Version:    0.7.0.1
 */