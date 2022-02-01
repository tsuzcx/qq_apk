package com.tencent.luggage.wxa.ma;

import com.tencent.luggage.wxa.am.g.a;
import com.tencent.luggage.wxa.me.a;
import com.tencent.luggage.wxa.qz.af;

public class j
  implements g
{
  private static j a;
  private boolean b = false;
  private boolean c = true;
  private boolean d = false;
  private a e = new j.1(this);
  
  public static j a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new j();
        }
      }
      finally {}
    }
    return a;
  }
  
  private boolean b(String paramString)
  {
    return (!af.c(paramString)) && (paramString.startsWith("http://127.0.0.1"));
  }
  
  public long a(String paramString, long paramLong1, long paramLong2)
  {
    if (!this.c) {
      return c.a().a(paramString, paramLong1, paramLong2);
    }
    try
    {
      paramLong1 = com.tencent.luggage.wxa.me.b.a().b(paramString);
      return paramLong1;
    }
    catch (Exception paramString)
    {
      com.tencent.luggage.wxa.mf.b.a(6, "MicroMsg.SameLayer.VideoCore", "getCachedBytes exception", paramString);
    }
    return 0L;
  }
  
  public String a(String paramString)
  {
    if (!this.c) {
      return c.a().a(paramString);
    }
    if (!af.c(paramString))
    {
      if (b(paramString)) {
        return paramString;
      }
      try
      {
        String str = com.tencent.luggage.wxa.me.b.a().a(paramString);
        return str;
      }
      catch (Exception localException)
      {
        com.tencent.luggage.wxa.mf.b.a(6, "MicroMsg.SameLayer.VideoCore", "getProxyUrl exception", localException);
      }
    }
    return paramString;
  }
  
  public g.a b()
  {
    if (!this.c) {
      return c.a().e();
    }
    return null;
  }
  
  public boolean c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ma.j
 * JD-Core Version:    0.7.0.1
 */