package com.tencent.mm.ui;

import android.util.Log;

public class f
{
  private static f.a a = new f.1();
  private static f.a b = a;
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (b != null)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      b.a(paramString1, paramVarArgs);
    }
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (b != null)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramVarArgs);
      paramString2.append("  ");
      paramString2.append(Log.getStackTraceString(paramThrowable));
      paramThrowable = paramString2.toString();
      b.e(paramString1, paramThrowable);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (b != null)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      b.b(paramString1, paramVarArgs);
    }
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (b != null)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      b.c(paramString1, paramVarArgs);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (b != null)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      b.d(paramString1, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (b != null)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      b.e(paramString1, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.f
 * JD-Core Version:    0.7.0.1
 */