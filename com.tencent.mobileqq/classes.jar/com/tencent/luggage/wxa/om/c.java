package com.tencent.luggage.wxa.om;

import android.annotation.SuppressLint;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public class c
{
  private static long a;
  private static final List<c.a> b = Collections.synchronizedList(new LinkedList());
  
  public static void a(String paramString1, String paramString2, String paramString3, double paramDouble)
  {
    long l = System.currentTimeMillis();
    a(paramString1, paramString2, paramString3, "C", l, l, String.format("{\"%s\":%f}", new Object[] { paramString3, Double.valueOf(paramDouble) }));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5)
  {
    c.a locala = new c.a();
    c.a.a(locala, paramString1);
    c.a.b(locala, paramString3);
    c.a.c(locala, paramString2);
    c.a.d(locala, paramString4);
    c.a.a(locala, paramLong1);
    c.a.b(locala, paramLong2);
    if (paramString5 != null) {
      paramString1 = URLEncoder.encode(paramString5);
    } else {
      paramString1 = "";
    }
    c.a.e(locala, paramString1);
    if (b.size() < 10000) {
      b.add(locala);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.om.c
 * JD-Core Version:    0.7.0.1
 */