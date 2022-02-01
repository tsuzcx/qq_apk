package com.tencent.luggage.wxa.gn;

import com.tencent.luggage.wxa.gw.b;
import java.util.ArrayList;

public class c
{
  private static c a;
  private volatile ArrayList<com.tencent.luggage.wxa.gm.c> b = new ArrayList();
  private long c = 50L;
  private volatile int d = 0;
  
  public static c a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new c();
        }
      }
      finally {}
    }
    return a;
  }
  
  public com.tencent.luggage.wxa.gm.c b()
  {
    try
    {
      if (this.b.size() > 0)
      {
        localc = (com.tencent.luggage.wxa.gm.c)this.b.remove(this.b.size() - 1);
        return localc;
      }
      if (this.d >= this.c)
      {
        b.a("MicroMsg.Mix.AudioOutputMixBufferPool", "size >= FIX_SIZE, size:%d", new Object[] { Integer.valueOf(this.d) });
        return null;
      }
      this.d += 1;
      com.tencent.luggage.wxa.gm.c localc = new com.tencent.luggage.wxa.gm.c();
      return localc;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gn.c
 * JD-Core Version:    0.7.0.1
 */