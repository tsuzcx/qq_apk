package com.tencent.luggage.wxa.og;

import com.tencent.luggage.wxa.hv.g;
import com.tencent.luggage.wxa.hv.i;
import com.tencent.luggage.wxa.oe.b;
import com.tencent.luggage.wxa.oe.c;
import com.tencent.luggage.wxa.qz.o;

public class d
  extends b
{
  private static d.a a;
  
  public int a()
  {
    return 3;
  }
  
  public void a(i parami, c paramc)
  {
    if (a == null)
    {
      o.e("MicroMsg.NodeReportIDKey", "sDelegate null");
      return;
    }
    try
    {
      int i = parami.getInt("id");
      int j = parami.getInt("key");
      int k = parami.optInt("val", 1);
      a.a(i, j, k);
      return;
    }
    catch (g parami)
    {
      o.b("MicroMsg.NodeReportIDKey", "execute exception : %s", new Object[] { parami });
      paramc.a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.og.d
 * JD-Core Version:    0.7.0.1
 */