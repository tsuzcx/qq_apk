package com.tencent.luggage.wxa.oe;

import com.tencent.luggage.wxa.hv.g;
import com.tencent.luggage.wxa.hv.i;

public abstract class d
  implements a
{
  protected abstract String a(i parami, c paramc);
  
  public String a(String paramString, c paramc)
  {
    try
    {
      paramString = new i(paramString);
      return a(paramString, paramc);
    }
    catch (g paramString)
    {
      label16:
      break label16;
    }
    return paramc.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oe.d
 * JD-Core Version:    0.7.0.1
 */