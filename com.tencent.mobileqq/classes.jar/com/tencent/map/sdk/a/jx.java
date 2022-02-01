package com.tencent.map.sdk.a;

import android.content.Context;
import org.json.JSONArray;

public final class jx
{
  private static int a = jy.a;
  private static int b = 1000;
  private static int c = jy.b;
  private static int d = 0;
  private static volatile boolean e = false;
  private static int f = 0;
  private static String g = null;
  private static String h = null;
  private static int[] i = new int[0];
  private static byte[] j = new byte[0];
  
  public static int a()
  {
    synchronized (j)
    {
      int k = b;
      return k;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int[] paramArrayOfInt, String paramString2)
  {
    synchronized (j)
    {
      a = paramInt1;
      b = paramInt2;
      c = paramInt3;
      d = paramInt4;
      g = paramString1;
      i = paramArrayOfInt;
      h = paramString2;
      return;
    }
  }
  
  public static void a(Context arg0)
  {
    if (??? == null) {
      return;
    }
    gf localgf = gf.a(???);
    int m = localgf.b("worldMapFrontierVersion");
    int n = localgf.b("worldMapStyle");
    int i1 = localgf.b("worldMapScene");
    int i2 = localgf.b("worldMapVersion");
    int i3 = localgf.b("worldMapProtocolVersion");
    boolean bool = localgf.c("worldMapEnabled");
    String str = localgf.a("worldMapTileUrlRegex");
    int k = 0;
    Object localObject1 = new int[0];
    ??? = (Context)localObject1;
    try
    {
      JSONArray localJSONArray = new JSONArray(localgf.a("worldMapTileUrlRangeJson"));
      ??? = (Context)localObject1;
      localObject3 = new int[localJSONArray.length()];
      for (;;)
      {
        localObject1 = localObject3;
        ??? = (Context)localObject3;
        if (k >= localObject3.length) {
          break;
        }
        ??? = (Context)localObject3;
        localObject3[k] = localJSONArray.getInt(k);
        k += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject3;
        Context localContext = ???;
      }
    }
    localObject3 = localgf.a("worldMapLogoChangeRuleJson");
    synchronized (j)
    {
      b = n;
      a = i1;
      c = i2;
      d = i3;
      e = bool;
      g = str;
      i = (int[])localObject1;
      h = (String)localObject3;
      f = m;
      return;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    synchronized (j)
    {
      e = paramBoolean;
      return;
    }
  }
  
  public static int b()
  {
    synchronized (j)
    {
      int k = a;
      return k;
    }
  }
  
  public static int c()
  {
    synchronized (j)
    {
      int k = c;
      return k;
    }
  }
  
  public static boolean d()
  {
    synchronized (j)
    {
      boolean bool = e;
      return bool;
    }
  }
  
  public static String e()
  {
    synchronized (j)
    {
      String str = g;
      return str;
    }
  }
  
  public static int f()
  {
    synchronized (j)
    {
      int k = d;
      return k;
    }
  }
  
  public static String g()
  {
    synchronized (j)
    {
      String str = h;
      return str;
    }
  }
  
  public static int[] h()
  {
    synchronized (j)
    {
      int[] arrayOfInt = i;
      return arrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jx
 * JD-Core Version:    0.7.0.1
 */