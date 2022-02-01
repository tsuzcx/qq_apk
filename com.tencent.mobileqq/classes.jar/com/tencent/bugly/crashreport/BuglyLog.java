package com.tencent.bugly.crashreport;

import android.util.Log;
import com.tencent.bugly.b;
import com.tencent.bugly.proguard.y;

public class BuglyLog
{
  public static void d(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.d(str, paramString1);
    }
    y.a("D", str, paramString1);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.e(str, paramString1);
    }
    y.a("E", str, paramString1);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.e(str, paramString1, paramThrowable);
    }
    y.a("E", str, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.i(str, paramString1);
    }
    y.a("I", str, paramString1);
  }
  
  public static void setCache(int paramInt)
  {
    y.a(paramInt);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.v(str, paramString1);
    }
    y.a("V", str, paramString1);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.w(str, paramString1);
    }
    y.a("W", str, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.crashreport.BuglyLog
 * JD-Core Version:    0.7.0.1
 */