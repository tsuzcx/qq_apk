package com.tencent.luggage.wxa.gn;

import com.tencent.luggage.wxa.gm.e;
import com.tencent.luggage.wxa.gw.b;
import java.util.ArrayList;

public class d
{
  private static d a;
  private ArrayList<e> b = new ArrayList();
  private Object c = new Object();
  private long d = 3000000L;
  private int e = 0;
  private int f = 0;
  
  public static d a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new d();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(e parame)
  {
    if (parame != null)
    {
      if (parame.f == null) {
        return;
      }
      if (!parame.b()) {
        return;
      }
      parame.a();
      synchronized (this.c)
      {
        this.b.add(0, parame);
        return;
      }
    }
  }
  
  public e b()
  {
    synchronized (this.c)
    {
      if (this.b.size() > 0)
      {
        e locale = (e)this.b.remove(this.b.size() - 1);
        return locale;
      }
      if (this.e >= this.d)
      {
        b.a("MicroMsg.Mix.AudioPcmDataTrackFixedSizePool", "size >= FIX_SIZE, size:%d", new Object[] { Integer.valueOf(this.e) });
        return null;
      }
      this.f += 1;
      this.e = (this.f * 3536);
      b.b("MicroMsg.Mix.AudioPcmDataTrackFixedSizePool", "pool tract count:%d", new Object[] { Integer.valueOf(this.f) });
      ??? = new e();
      ((e)???).a(true);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gn.d
 * JD-Core Version:    0.7.0.1
 */