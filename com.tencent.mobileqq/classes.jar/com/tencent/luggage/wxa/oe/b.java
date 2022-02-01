package com.tencent.luggage.wxa.oe;

import com.tencent.luggage.wxa.hv.g;
import com.tencent.luggage.wxa.hv.i;

public abstract class b
  implements a
{
  public String a(String paramString, c paramc)
  {
    try
    {
      paramString = new i(paramString);
      a(paramString, paramc);
      return null;
    }
    catch (g paramString)
    {
      label17:
      break label17;
    }
    return paramc.a(2);
  }
  
  protected abstract void a(i parami, c paramc);
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oe.b
 * JD-Core Version:    0.7.0.1
 */