package com.tencent.luggage.wxa.og;

import com.tencent.luggage.wxa.hv.g;
import com.tencent.luggage.wxa.hv.i;
import com.tencent.luggage.wxa.oe.b;
import com.tencent.luggage.wxa.oe.c;
import com.tencent.luggage.wxa.qz.o;

public class e
  extends b
{
  private static e.a a;
  
  public int a()
  {
    return 8;
  }
  
  protected void a(i parami, c paramc)
  {
    if (a == null)
    {
      o.e("MicroMsg.NodeReportKV", "sDelegate null");
      return;
    }
    try
    {
      int i = parami.getInt("id");
      parami = parami.optString("val");
      a.a(i, parami);
      return;
    }
    catch (g parami)
    {
      o.b("MicroMsg.NodeReportKV", "execute exception : %s", new Object[] { parami });
      paramc.a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.og.e
 * JD-Core Version:    0.7.0.1
 */