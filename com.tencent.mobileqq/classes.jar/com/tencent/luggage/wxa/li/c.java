package com.tencent.luggage.wxa.li;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.ot.d;
import com.tencent.luggage.wxa.qz.o;

public class c
{
  public static void a(String paramString)
  {
    o.d("MicroMsg.HCEReportManager", "alvinluo reportHCEtimeExceeded appId: %s", new Object[] { paramString });
    ((d)e.b(d.class)).a(14838, paramString);
  }
  
  public static void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, -1);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    o.d("MicroMsg.HCEReportManager", "alvinluo reportStartHCEResult appId: %s, result: %d, diff: %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ((d)e.b(d.class)).a(14837, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.li.c
 * JD-Core Version:    0.7.0.1
 */