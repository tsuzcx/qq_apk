package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.V8;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

public final class y
{
  private static int a = -1;
  private static int b = -1;
  private static y.a c;
  
  private static int a()
  {
    int i = a;
    if (i > 0) {
      return i;
    }
    c();
    return a;
  }
  
  private static int a(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("=");
    paramString2 = localStringBuilder.toString();
    if (paramString1.indexOf(paramString2) >= 0) {
      return af.a(paramString1.replaceFirst(paramString2, ""), paramInt);
    }
    return -2147483648;
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5)
  {
    if (c != null)
    {
      paramString = String.format("%d,%d,%d,%d,%d,%s,%d,%d,%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(a()), Integer.valueOf(b()), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      o.f("MicroMsg.V8GCReporter", "report str:%s", new Object[] { paramString });
      c.a(paramString);
    }
  }
  
  private static int b()
  {
    int i = b;
    if (i > 0) {
      return i;
    }
    c();
    return b;
  }
  
  private static void c()
  {
    Object localObject = V8.getFlags();
    int i = 0;
    o.d("MicroMsg.V8GCReporter", "initV8GCSpaceSizeFromFlags : %s", new Object[] { localObject });
    if (af.c((String)localObject))
    {
      a = 1;
      b = 8;
      return;
    }
    localObject = ((String)localObject).split(" ", -1);
    while (i < localObject.length)
    {
      int j = a(localObject[i], "--min_semi_space_size", 1);
      if (j != -2147483648)
      {
        a = j;
      }
      else
      {
        j = a(localObject[i], "--max_semi_space_size", 8);
        if (j != -2147483648) {
          b = j;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.y
 * JD-Core Version:    0.7.0.1
 */