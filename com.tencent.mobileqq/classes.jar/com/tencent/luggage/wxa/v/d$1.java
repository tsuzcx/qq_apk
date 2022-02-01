package com.tencent.luggage.wxa.v;

import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.x.g;
import com.tencent.luggage.wxa.y.c;

final class d$1
  implements d
{
  public boolean a(k paramk)
  {
    paramk = paramk.f;
    return ("application/id3".equals(paramk)) || ("application/x-emsg".equals(paramk)) || ("application/x-scte35".equals(paramk));
  }
  
  public b b(k paramk)
  {
    paramk = paramk.f;
    int i = paramk.hashCode();
    if (i != -1248341703)
    {
      if (i != 1154383568)
      {
        if ((i == 1652648887) && (paramk.equals("application/x-scte35")))
        {
          i = 2;
          break label75;
        }
      }
      else if (paramk.equals("application/x-emsg"))
      {
        i = 1;
        break label75;
      }
    }
    else if (paramk.equals("application/id3"))
    {
      i = 0;
      break label75;
    }
    i = -1;
    label75:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          return new c();
        }
        throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
      }
      return new com.tencent.luggage.wxa.w.b();
    }
    return new g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.v.d.1
 * JD-Core Version:    0.7.0.1
 */