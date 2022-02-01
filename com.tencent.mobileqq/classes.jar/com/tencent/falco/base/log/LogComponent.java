package com.tencent.falco.base.log;

import android.content.Context;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.log.LogInterface.LogAdapter;

public class LogComponent
  implements LogInterface
{
  private LogInterface.LogAdapter adapter;
  private Context context;
  
  public void clearEventOutput() {}
  
  public void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    this.adapter.getLog().d(paramString1, paramString2, paramVarArgs);
    sendToConsole(paramString2);
  }
  
  public void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    this.adapter.getLog().e(paramString1, paramString2, paramVarArgs);
    sendToConsole(paramString2);
  }
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    this.adapter.getLog().i(paramString1, paramString2, paramVarArgs);
    sendToConsole(paramString2);
  }
  
  public void init(LogInterface.LogAdapter paramLogAdapter)
  {
    this.adapter = paramLogAdapter;
  }
  
  public void onCreate(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void onDestroy() {}
  
  public void printException(String paramString, Throwable paramThrowable)
  {
    this.adapter.getLog().printException(paramString, paramThrowable);
  }
  
  public void printException(String paramString1, Throwable paramThrowable, String paramString2)
  {
    this.adapter.getLog().printException(paramString1, paramThrowable, paramString2);
  }
  
  public void printException(Throwable paramThrowable)
  {
    this.adapter.getLog().printException(paramThrowable);
  }
  
  public void printStackTrace(Throwable paramThrowable)
  {
    this.adapter.getLog().printStackTrace(paramThrowable);
  }
  
  void sendToConsole(String paramString) {}
  
  public void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    this.adapter.getLog().v(paramString1, paramString2, paramVarArgs);
    sendToConsole(paramString2);
  }
  
  public void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    this.adapter.getLog().w(paramString1, paramString2, paramVarArgs);
    sendToConsole(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.log.LogComponent
 * JD-Core Version:    0.7.0.1
 */