package com.tencent.luggage.wxa.iu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.tencent.luggage.wxa.iv.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class g
{
  private static final Map<String, g> p = new ArrayMap();
  private static final g q = new g();
  public b a = new b();
  public volatile String b;
  public final AtomicInteger c = new AtomicInteger();
  public final AtomicBoolean d = new AtomicBoolean(false);
  public i.a e = null;
  public volatile String f;
  public volatile String g;
  public volatile boolean h = false;
  public volatile boolean i = false;
  public volatile boolean j = false;
  public volatile boolean k = false;
  public volatile boolean l = false;
  public volatile int m = -1;
  public volatile int n = 0;
  public volatile boolean o = false;
  
  public static g a(String paramString)
  {
    return a(paramString, true);
  }
  
  @NonNull
  private static g a(String paramString, boolean paramBoolean)
  {
    if (af.c(paramString)) {
      return null;
    }
    synchronized (p)
    {
      g localg = (g)p.get(paramString);
      if ((localg == null) || (paramBoolean))
      {
        localg = new g();
        p.put(paramString, localg);
      }
      return localg;
    }
  }
  
  public static void b(String paramString)
  {
    if (af.c(paramString)) {
      return;
    }
    synchronized (p)
    {
      p.remove(paramString);
      return;
    }
  }
  
  @NonNull
  public static g c(String paramString)
  {
    g localg = e(paramString);
    paramString = localg;
    if (localg == null) {
      paramString = q;
    }
    return paramString;
  }
  
  @NonNull
  public static g d(String paramString)
  {
    return a(paramString, false);
  }
  
  @Nullable
  private static g e(String paramString)
  {
    if (af.c(paramString)) {
      return null;
    }
    synchronized (p)
    {
      paramString = (g)p.get(paramString);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.g
 * JD-Core Version:    0.7.0.1
 */