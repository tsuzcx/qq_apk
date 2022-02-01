package com.huawei.hms.stats;

import java.nio.charset.Charset;

public final class e
{
  public static final Charset a = Charset.forName("UTF-8");
  private static e b;
  private i c;
  
  public static e a()
  {
    if (b == null) {
      b();
    }
    return b;
  }
  
  private static void b()
  {
    try
    {
      if (b == null) {
        b = new e();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public i a(e.a parama)
  {
    switch (e.1.a[parama.ordinal()])
    {
    default: 
      af.b("CryptFactory", "crypt type is other");
    }
    for (;;)
    {
      return this.c;
      this.c = new d();
      continue;
      this.c = new h();
      continue;
      this.c = new j();
    }
  }
  
  public String a(String paramString)
  {
    return f.a(paramString);
  }
  
  public String a(char[] paramArrayOfChar, byte[] paramArrayOfByte)
  {
    return f.a(paramArrayOfChar, paramArrayOfByte);
  }
  
  public String b(e.a parama)
  {
    return g.a(parama.a());
  }
  
  public byte[] b(String paramString)
  {
    return g.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.e
 * JD-Core Version:    0.7.0.1
 */