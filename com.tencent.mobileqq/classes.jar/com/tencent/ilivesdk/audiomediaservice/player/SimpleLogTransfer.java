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
    LogInterface localLogInterface = this.a;
    if (localLogInterface != null) {
      localLogInterface.d(paramString1, paramString2, paramVarArgs);
    }
    super.d(paramString1, paramString2, paramVarArgs);
  }
  
  public void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogInterface localLogInterface = this.a;
    if (localLogInterface != null) {
      localLogInterface.e(paramString1, paramString2, paramVarArgs);
    }
    super.e(paramString1, paramString2, paramVarArgs);
  }
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogInterface localLogInterface = this.a;
    if (localLogInterface != null) {
      localLogInterface.i(paramString1, paramString2, paramVarArgs);
    }
    super.i(paramString1, paramString2, paramVarArgs);
  }
  
  public void printException(String paramString, Throwable paramThrowable)
  {
    LogInterface localLogInterface = this.a;
    if (localLogInterface != null) {
      localLogInterface.printException(paramString, paramThrowable);
    }
    super.printException(paramString, paramThrowable);
  }
  
  public void printException(String paramString1, Throwable paramThrowable, String paramString2)
  {
    LogInterface localLogInterface = this.a;
    if (localLogInterface != null) {
      localLogInterface.printException(paramString1, paramThrowable, paramString2);
    }
    super.printException(paramString1, paramThrowable, paramString2);
  }
  
  public void printException(Throwable paramThrowable)
  {
    LogInterface localLogInterface = this.a;
    if (localLogInterface != null) {
      localLogInterface.printException(paramThrowable);
    }
    super.printException(paramThrowable);
  }
  
  public void printStackTrace(Throwable paramThrowable)
  {
    LogInterface localLogInterface = this.a;
    if (localLogInterface != null) {
      localLogInterface.printStackTrace(paramThrowable);
    }
    super.printStackTrace(paramThrowable);
  }
  
  public void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogInterface localLogInterface = this.a;
    if (localLogInterface != null) {
      localLogInterface.v(paramString1, paramString2, paramVarArgs);
    }
    super.v(paramString1, paramString2, paramVarArgs);
  }
  
  public void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogInterface localLogInterface = this.a;
    if (localLogInterface != null) {
      localLogInterface.w(paramString1, paramString2, paramVarArgs);
    }
    super.w(paramString1, paramString2, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.SimpleLogTransfer
 * JD-Core Version:    0.7.0.1
 */