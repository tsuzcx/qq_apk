package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.V8;
import com.tencent.luggage.wxa.hg.f;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.c;
import com.tencent.luggage.wxa.qz.o;

public final class g
{
  private static boolean a = false;
  
  static
  {
    V8.setLoadLibraryDelegate(new g.1());
  }
  
  public static long a()
  {
    c();
    return V8.getNativeTransManager();
  }
  
  public static i a(c.a parama)
  {
    return i.a(parama);
  }
  
  public static z b(c.a parama)
  {
    return z.b(parama);
  }
  
  public static z c(c.a parama)
  {
    return b.a(parama);
  }
  
  private static void c()
  {
    try
    {
      if (a)
      {
        o.d("MicroMsg.JSRuntimeCreator", "loadJSRuntimeSo already");
        return;
      }
      try
      {
        long l = af.d();
        f.a("mmv8", i.class.getClassLoader());
        f.a("mmnode", i.class.getClassLoader());
        f.a("mmj2v8", i.class.getClassLoader());
        y.a(6, af.d() - l, -1, null, -1, -1, -1);
      }
      catch (Exception localException)
      {
        o.a("MicroMsg.JSRuntimeCreator", localException, "", new Object[0]);
        if (c.a) {
          break label124;
        }
      }
      if (!c.b)
      {
        o.d("MicroMsg.JSRuntimeCreator", "loadJSRuntimeSo done");
        try
        {
          a = true;
          return;
        }
        finally {}
      }
      label124:
      throw localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.g
 * JD-Core Version:    0.7.0.1
 */