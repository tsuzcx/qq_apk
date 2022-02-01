package com.tencent.luggage.wxa.pp;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.pc.h;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.Collection;
import java.util.Iterator;

final class e
{
  private static final h<u, ab> a = new h();
  
  public static ab a(@Nullable u paramu, @Nullable e.a parama)
  {
    if (paramu != null)
    {
      if (parama == null) {
        return null;
      }
      paramu = a.a(paramu);
      if (paramu != null)
      {
        paramu = paramu.iterator();
        while (paramu.hasNext())
        {
          ab localab = (ab)paramu.next();
          if ((localab != null) && (parama.a(localab))) {
            return localab;
          }
        }
      }
    }
    return null;
  }
  
  public static void a(@Nullable u paramu)
  {
    a.b(paramu);
  }
  
  public static void a(@Nullable u paramu, @Nullable ab paramab)
  {
    a.a(paramu, paramab);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.e
 * JD-Core Version:    0.7.0.1
 */