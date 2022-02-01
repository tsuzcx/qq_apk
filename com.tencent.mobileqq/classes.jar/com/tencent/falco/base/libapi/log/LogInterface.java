package com.tencent.falco.base.libapi.log;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface LogInterface
  extends ServiceBaseInterface
{
  public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract void init(LogInterface.LogAdapter paramLogAdapter);
  
  public abstract void printException(String paramString, Throwable paramThrowable);
  
  public abstract void printException(String paramString1, Throwable paramThrowable, String paramString2);
  
  public abstract void printException(Throwable paramThrowable);
  
  public abstract void printStackTrace(Throwable paramThrowable);
  
  public abstract void v(String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.log.LogInterface
 * JD-Core Version:    0.7.0.1
 */