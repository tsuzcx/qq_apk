package com.tencent.luggage.wxa.gn;

import java.util.ArrayList;

public class e
{
  private static e a;
  private ArrayList<com.tencent.luggage.wxa.gm.e> b = new ArrayList();
  private Object c = new Object();
  
  public static e a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new e();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(com.tencent.luggage.wxa.gm.e parame)
  {
    if (parame != null)
    {
      if (parame.f == null) {
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
  
  public com.tencent.luggage.wxa.gm.e b()
  {
    synchronized (this.c)
    {
      if (this.b.size() > 0)
      {
        com.tencent.luggage.wxa.gm.e locale = (com.tencent.luggage.wxa.gm.e)this.b.remove(this.b.size() - 1);
        return locale;
      }
      return new com.tencent.luggage.wxa.gm.e();
    }
  }
  
  public long c()
  {
    try
    {
      int i = this.b.size();
      long l = i * 3536;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gn.e
 * JD-Core Version:    0.7.0.1
 */