package com.tencent.luggage.wxa.hb;

import com.tencent.luggage.wxa.hg.c;
import com.tencent.luggage.wxa.qz.o;

public class a
{
  public static boolean a(int paramInt, a.a parama)
  {
    if (parama == null)
    {
      o.e("MicroMsg.ApiTask", "empty task");
      return false;
    }
    if (c.a(paramInt))
    {
      parama.a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hb.a
 * JD-Core Version:    0.7.0.1
 */