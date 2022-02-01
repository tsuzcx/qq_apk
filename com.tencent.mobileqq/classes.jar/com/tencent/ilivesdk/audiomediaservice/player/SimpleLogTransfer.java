package com.tencent.ilivesdk.audiomediaservice.player;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.opensdk.loginterface.SimpleLogInterface;

public class SimpleLogTransfer
  extends SimpleLogInterface
{
  LogInterface a;
  
  public SimpleLogTransfer(LogInterface paramLogInterface)
  {
    this.a = paramLogInterface;
  }
  
  public void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.a != null) {
      this.a.d(paramString1, paramString2, paramVarArgs);
    }
    super.d(paramString1, paramString2, paramVarArgs);
  }
  
  public void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.a != null) {
      this.a.e(paramString1, paramString2, paramVarArgs);
    }
    super.e(paramString1, paramString2, paramVarArgs);
  }
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.a != null) {
      this.a.i(paramString1, paramString2, paramVarArgs);
    }
    super.i(paramString1, paramString2, paramVarArgs);
  }
  
  public void printException(String paramString, Throwable paramThrowable)
  {
    if (this.a != null) {
      this.a.printException(paramString, paramThrowable);
    }
    super.printException(paramString, paramThrowable);
  }
  
  public void printException(String paramString1, Throwable paramThrowable, String paramString2)
  {
    if (this.a != null) {
      this.a.printException(paramString1, paramThrowable, paramString2);
    }
    super.printException(paramString1, paramThrowable, paramString2);
  }
  
  public void printException(Throwable paramThrowable)
  {
    if (this.a != null) {
      this.a.printException(paramThrowable);
    }
    super.printException(paramThrowable);
  }
  
  public void printStackTrace(Throwable paramThrowable)
  {
    if (this.a != null) {
      this.a.printStackTrace(paramThrowable);
    }
    super.printStackTrace(paramThrowable);
  }
  
  public void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.a != null) {
      this.a.v(paramString1, paramString2, paramVarArgs);
    }
    super.v(paramString1, paramString2, paramVarArgs);
  }
  
  public void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.a != null) {
      this.a.w(paramString1, paramString2, paramVarArgs);
    }
    super.w(paramString1, paramString2, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.SimpleLogTransfer
 * JD-Core Version:    0.7.0.1
 */