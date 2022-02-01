package com.tencent.acstat.common;

import android.util.Log;

public final class StatLogger
{
  private String a = "default";
  private boolean b = true;
  private int c = 2;
  
  public StatLogger() {}
  
  public StatLogger(String paramString)
  {
    this.a = paramString;
  }
  
  private String a()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement == null) {}
    for (;;)
    {
      return null;
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        if ((!localStackTraceElement.isNativeMethod()) && (!localStackTraceElement.getClassName().equals(Thread.class.getName())) && (!localStackTraceElement.getClassName().equals(getClass().getName()))) {
          return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + localStackTraceElement.getFileName() + ":" + localStackTraceElement.getLineNumber() + "]";
        }
        i += 1;
      }
    }
  }
  
  public final void d(Object paramObject)
  {
    if (isDebugEnable()) {
      debug(paramObject);
    }
  }
  
  public final void debug(Object paramObject)
  {
    String str;
    if (this.c <= 3)
    {
      str = a();
      if (str != null) {
        break label32;
      }
    }
    label32:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      Log.d(this.a, paramObject);
      return;
    }
  }
  
  public final void e(Object paramObject)
  {
    if (isDebugEnable()) {
      error(paramObject);
    }
  }
  
  public final void e(Throwable paramThrowable)
  {
    if (isDebugEnable()) {
      error(paramThrowable);
    }
  }
  
  public final void error(Object paramObject)
  {
    String str;
    if (this.c <= 6)
    {
      str = a();
      if (str != null) {
        break label33;
      }
    }
    label33:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      Log.e(this.a, paramObject);
      return;
    }
  }
  
  public final void error(Throwable paramThrowable)
  {
    if (this.c <= 6) {
      Log.e(this.a, "", paramThrowable);
    }
  }
  
  public final int getLogLevel()
  {
    return this.c;
  }
  
  public final void i(Object paramObject)
  {
    if (isDebugEnable()) {
      info(paramObject);
    }
  }
  
  public final void info(Object paramObject)
  {
    String str;
    if (this.c <= 4)
    {
      str = a();
      if (str != null) {
        break label32;
      }
    }
    label32:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      Log.i(this.a, paramObject);
      return;
    }
  }
  
  public final boolean isDebugEnable()
  {
    return this.b;
  }
  
  public final void setDebugEnable(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final void setLogLevel(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void setTag(String paramString)
  {
    this.a = paramString;
  }
  
  public final void v(Object paramObject)
  {
    if (isDebugEnable()) {
      verbose(paramObject);
    }
  }
  
  public final void verbose(Object paramObject)
  {
    String str;
    if (this.c <= 2)
    {
      str = a();
      if (str != null) {
        break label32;
      }
    }
    label32:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      Log.v(this.a, paramObject);
      return;
    }
  }
  
  public final void w(Object paramObject)
  {
    if (isDebugEnable()) {
      warn(paramObject);
    }
  }
  
  public final void warn(Object paramObject)
  {
    String str;
    if (this.c <= 5)
    {
      str = a();
      if (str != null) {
        break label32;
      }
    }
    label32:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      Log.w(this.a, paramObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.acstat.common.StatLogger
 * JD-Core Version:    0.7.0.1
 */