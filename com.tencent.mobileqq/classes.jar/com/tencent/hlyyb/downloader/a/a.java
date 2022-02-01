package com.tencent.hlyyb.downloader.a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.hlyyb.common.b.b;
import java.io.File;

public final class a
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  public static int d = 50;
  private static String e = ".temp";
  private static volatile int f = 500;
  private static int g = 6000;
  
  public static int a()
  {
    int j = com.tencent.hlyyb.common.a.a.g();
    int i = 1048576;
    if (j != 2)
    {
      if (j != 3) {
        return 1048576;
      }
      i = 524288;
    }
    return i;
  }
  
  public static void a(int paramInt)
  {
    f = Math.min(Math.max(paramInt, 200), 1000);
  }
  
  public static void a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    a = str;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      str = b.d();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject).append("/Download/");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("/HalleyDownload");
      str = ((StringBuilder)localObject).toString();
    }
    else
    {
      str = "";
    }
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = com.tencent.hlyyb.common.a.a().getFilesDir().toString();
    }
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public static void b(int paramInt)
  {
    g = Math.min(Math.max(paramInt, 5000), 30000);
  }
  
  public static void b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    b = str;
  }
  
  public static int c()
  {
    return f;
  }
  
  public static void c(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    c = str;
  }
  
  public static int d()
  {
    return g;
  }
  
  public static void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      e = paramString;
    }
  }
  
  public static String e(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".bdcfg");
    return localStringBuilder.toString();
  }
  
  public static String f(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(e);
    return localStringBuilder.toString();
  }
  
  public static boolean g(String paramString)
  {
    return !b.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.a.a
 * JD-Core Version:    0.7.0.1
 */