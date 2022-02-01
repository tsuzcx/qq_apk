package com.tencent.luggage.wxa.rt;

import android.net.Uri;
import android.util.Pair;
import java.util.Map;

public final class p
  extends h.a
{
  public static final p.a CREATOR = new p.a(null);
  
  public static p a()
  {
    return p.a.a;
  }
  
  public Pair<d, String> a(h.c paramc, Uri paramUri)
  {
    d locald = (d)((g)paramc).b.get(paramUri.getAuthority());
    paramc = paramUri.getPath();
    if (paramc == null) {
      paramc = "";
    } else {
      paramc = o.a(paramc, true, true);
    }
    return new Pair(locald, paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.p
 * JD-Core Version:    0.7.0.1
 */