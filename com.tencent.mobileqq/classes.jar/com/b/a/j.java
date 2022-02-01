package com.b.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.qq.ac.sdk.f.a;
import java.util.Map;

public class j
{
  private static String d;
  private static String e;
  private static Context f;
  private static String g;
  private static String h;
  private static String i;
  private static String j;
  private static String k;
  private static String l;
  public byte[] a;
  public final Map<String, String> b;
  public final boolean c;
  
  public j(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    this.a = paramArrayOfByte;
    this.b = paramMap;
    this.c = paramBoolean;
  }
  
  public j(byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    this(200, paramArrayOfByte, paramMap, false, 0L);
  }
  
  public static String a()
  {
    return d;
  }
  
  public static void a(Context paramContext)
  {
    f = paramContext;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        d = paramContext.metaData.getString("APP_KEY");
        e = paramContext.metaData.getString("APP_ID");
      }
    }
    catch (Exception paramContext)
    {
      label54:
      break label54;
    }
    new a();
    g = "slG2OHH2";
    h = "hpWgxJTsg8";
    com.qq.ac.sdk.g.a.e = "https://android.ac.qq.com/sdk/QQComic/index.php";
    com.qq.ac.sdk.g.a.b = "1.1.0";
    com.qq.ac.sdk.g.a.d = "1.1.0";
    com.qq.ac.sdk.g.a.c = "0.8.8";
  }
  
  public static void a(String paramString)
  {
    d = paramString;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    i = paramString1;
    j = paramString3;
    k = paramString2;
  }
  
  public static String b()
  {
    return e;
  }
  
  public static void b(String paramString)
  {
    l = paramString;
  }
  
  public static Context c()
  {
    return f;
  }
  
  public static void c(String paramString)
  {
    e = paramString;
  }
  
  public static String d()
  {
    return g;
  }
  
  public static String e()
  {
    return h;
  }
  
  public static String f()
  {
    return i;
  }
  
  public static String g()
  {
    return k;
  }
  
  public static String h()
  {
    return j;
  }
  
  public static String i()
  {
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.b.a.j
 * JD-Core Version:    0.7.0.1
 */