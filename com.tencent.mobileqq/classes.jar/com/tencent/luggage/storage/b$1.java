package com.tencent.luggage.storage;

import com.tencent.luggage.wxa.dd.b.a;
import com.tencent.luggage.wxa.dx.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rb.c;

final class b$1
  implements b.a
{
  b$1(c paramc, a parama) {}
  
  public void a() {}
  
  public void b()
  {
    try
    {
      try
      {
        this.a.a("AppBrandKVData", "drop table AppBrandKVData".toUpperCase());
        this.a.a("AppBrandCommonKVData", "drop table AppBrandCommonKVData".toUpperCase());
        b.a(this.a);
        return;
      }
      finally {}
      return;
    }
    catch (Throwable localThrowable)
    {
      o.a("Luggage.WxaDBRegistry", localThrowable, "drop kv table with userId %s", new Object[] { this.b });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.storage.b.1
 * JD-Core Version:    0.7.0.1
 */