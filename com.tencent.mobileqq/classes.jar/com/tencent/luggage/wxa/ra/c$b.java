package com.tencent.luggage.wxa.ra;

import android.os.Message;
import java.util.Vector;

class c$b
{
  private Vector<c.a> a = new Vector();
  private int b = 20;
  private int c = 0;
  private int d = 0;
  private boolean e = false;
  
  void a(c paramc, Message paramMessage, String paramString, a parama1, a parama2, a parama3)
  {
    try
    {
      this.d += 1;
      if (this.a.size() < this.b)
      {
        this.a.add(new c.a(paramc, paramMessage, paramString, parama1, parama2, parama3));
      }
      else
      {
        c.a locala = (c.a)this.a.get(this.c);
        this.c += 1;
        if (this.c >= this.b) {
          this.c = 0;
        }
        locala.a(paramc, paramMessage, paramString, parama1, parama2, parama3);
      }
      return;
    }
    finally {}
  }
  
  boolean a()
  {
    try
    {
      boolean bool = this.e;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void b()
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ra.c.b
 * JD-Core Version:    0.7.0.1
 */