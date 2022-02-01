package com.tencent.luggage.wxa.gi;

import com.tencent.luggage.wxa.c.a;
import com.tencent.luggage.wxa.gk.h;

public class b
{
  private static boolean a = false;
  private static b.a b = new b.1();
  
  public static void a()
  {
    if (a)
    {
      c.c.b("MagicBrush", "library already loaded", new Object[0]);
      return;
    }
    long l1 = h.a();
    c.c.b("MagicBrush", "start loadLibraries", new Object[0]);
    long l2 = h.a();
    b.a("mmv8");
    long l3 = h.a();
    b.a("magicbrush");
    a = true;
    c.c.b("MagicBrush", "total[%d]ms load mmv8 cost [%d]ms, load magicbrush cost [%d]ms", new Object[] { Long.valueOf(h.a(l1)), Long.valueOf(l3 - l2), Long.valueOf(h.a(l3)) });
  }
  
  public static void a(b.a parama)
  {
    if (parama != null)
    {
      b = parama;
      b(parama);
    }
  }
  
  public static void a(String paramString)
  {
    b.a(paramString);
  }
  
  private static void b(b.a parama)
  {
    a.a(new b.2(parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gi.b
 * JD-Core Version:    0.7.0.1
 */