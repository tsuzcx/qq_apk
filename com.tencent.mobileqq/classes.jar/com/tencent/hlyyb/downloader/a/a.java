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
    switch ()
    {
    case 2: 
    default: 
      return 1048576;
    }
    return 524288;
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
    int i;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      i = 1;
      if (i == 0) {
        break label98;
      }
      str1 = b.d();
    }
    label98:
    for (String str1 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/" + str1 + "/HalleyDownload";; str1 = "")
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = com.tencent.hlyyb.common.a.a().getFilesDir().toString();
      }
      localStringBuilder.append(str2);
      return localStringBuilder.toString();
      i = 0;
      break;
    }
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
    return paramString + ".bdcfg";
  }
  
  public static String f(String paramString)
  {
    return paramString + e;
  }
  
  public static boolean g(String paramString)
  {
    return !b.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.a.a
 * JD-Core Version:    0.7.0.1
 */