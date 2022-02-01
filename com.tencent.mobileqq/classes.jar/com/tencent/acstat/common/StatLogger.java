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
    Object localObject2 = Thread.currentThread().getStackTrace();
    if (localObject2 == null) {
      return null;
    }
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = localObject2[i];
      if ((!localObject1.isNativeMethod()) && (!localObject1.getClassName().equals(Thread.class.getName())) && (!localObject1.getClassName().equals(getClass().getName())))
      {
        localObject2 = new StringBuilder("[");
        ((StringBuilder)localObject2).append(Thread.currentThread().getName());
        ((StringBuilder)localObject2).append("(");
        ((StringBuilder)localObject2).append(Thread.currentThread().getId());
        ((StringBuilder)localObject2).append("): ");
        ((StringBuilder)localObject2).append(localObject1.getFileName());
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(localObject1.getLineNumber());
        ((StringBuilder)localObject2).append("]");
        return ((StringBuilder)localObject2).toString();
      }
      i += 1;
    }
    return null;
  }
  
  public final void d(Object paramObject)
  {
    if (isDebugEnable()) {
      debug(paramObject);
    }
  }
  
  public final void debug(Object paramObject)
  {
    if (this.c <= 3)
    {
      String str = a();
      if (str == null)
      {
        paramObject = paramObject.toString();
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(" - ");
        localStringBuilder.append(paramObject);
        paramObject = localStringBuilder.toString();
      }
      Log.d(this.a, paramObject);
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
    if (this.c <= 6)
    {
      String str = a();
      if (str == null)
      {
        paramObject = paramObject.toString();
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(" - ");
        localStringBuilder.append(paramObject);
        paramObject = localStringBuilder.toString();
      }
      Log.e(this.a, paramObject);
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
    if (this.c <= 4)
    {
      String str = a();
      if (str == null)
      {
        paramObject = paramObject.toString();
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(" - ");
        localStringBuilder.append(paramObject);
        paramObject = localStringBuilder.toString();
      }
      Log.i(this.a, paramObject);
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
    if (this.c <= 2)
    {
      String str = a();
      if (str == null)
      {
        paramObject = paramObject.toString();
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(" - ");
        localStringBuilder.append(paramObject);
        paramObject = localStringBuilder.toString();
      }
      Log.v(this.a, paramObject);
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
    if (this.c <= 5)
    {
      String str = a();
      if (str == null)
      {
        paramObject = paramObject.toString();
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(" - ");
        localStringBuilder.append(paramObject);
        paramObject = localStringBuilder.toString();
      }
      Log.w(this.a, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.common.StatLogger
 * JD-Core Version:    0.7.0.1
 */