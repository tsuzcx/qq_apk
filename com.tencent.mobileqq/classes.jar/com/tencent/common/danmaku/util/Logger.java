package com.tencent.common.danmaku.util;

import com.tencent.common.danmaku.DanmakuDependImp;
import com.tencent.common.danmaku.IDanmakuDepend;
import com.tencent.common.danmaku.inject.VideoDanmakuConfig.ILogger;

public class Logger
{
  public static final int a;
  private static VideoDanmakuConfig.ILogger b;
  private static final StringBuilder c = new StringBuilder();
  
  static
  {
    int i;
    if (DanmakuDependImp.a().b().a()) {
      i = 4;
    } else {
      i = 3;
    }
    a = i;
  }
  
  public static VideoDanmakuConfig.ILogger a()
  {
    return b;
  }
  
  public static void a(VideoDanmakuConfig.ILogger paramILogger)
  {
    b = paramILogger;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a >= 5)
    {
      VideoDanmakuConfig.ILogger localILogger = b;
      if (localILogger != null) {
        localILogger.a(paramString1, paramString2);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a >= 1)
    {
      VideoDanmakuConfig.ILogger localILogger = b;
      if (localILogger != null) {
        localILogger.a(paramString1, paramString2, paramThrowable);
      }
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if ((a >= 5) && (b != null))
    {
      Object localObject = c;
      int i = 0;
      ((StringBuilder)localObject).setLength(0);
      int j = paramVarArgs.length;
      while (i < j)
      {
        localObject = paramVarArgs[i];
        c.append(localObject);
        i += 1;
      }
      b.a(paramString, c.toString());
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a >= 4)
    {
      VideoDanmakuConfig.ILogger localILogger = b;
      if (localILogger != null) {
        localILogger.b(paramString1, paramString2);
      }
    }
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if ((a >= 4) && (b != null))
    {
      Object localObject = c;
      int i = 0;
      ((StringBuilder)localObject).setLength(0);
      int j = paramVarArgs.length;
      while (i < j)
      {
        localObject = paramVarArgs[i];
        c.append(localObject);
        i += 1;
      }
      b.b(paramString, c.toString());
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (a >= 3)
    {
      VideoDanmakuConfig.ILogger localILogger = b;
      if (localILogger != null) {
        localILogger.c(paramString1, paramString2);
      }
    }
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    if ((a >= 3) && (b != null))
    {
      Object localObject = c;
      int i = 0;
      ((StringBuilder)localObject).setLength(0);
      int j = paramVarArgs.length;
      while (i < j)
      {
        localObject = paramVarArgs[i];
        c.append(localObject);
        i += 1;
      }
      b.c(paramString, c.toString());
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (a >= 2)
    {
      VideoDanmakuConfig.ILogger localILogger = b;
      if (localILogger != null) {
        localILogger.d(paramString1, paramString2);
      }
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if ((a >= 1) && (b != null))
    {
      Object localObject = c;
      int i = 0;
      ((StringBuilder)localObject).setLength(0);
      int j = paramVarArgs.length;
      while (i < j)
      {
        localObject = paramVarArgs[i];
        c.append(localObject);
        i += 1;
      }
      b.e(paramString, c.toString());
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (a >= 1)
    {
      VideoDanmakuConfig.ILogger localILogger = b;
      if (localILogger != null) {
        localILogger.e(paramString1, paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.util.Logger
 * JD-Core Version:    0.7.0.1
 */