package com.tencent.biz.qqstory.support;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.log.IQLog;

public class QLogAdapter
  implements IQLog
{
  public void a(String paramString1, String paramString2)
  {
    SLog.e(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    SLog.c(paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2)
  {
    SLog.b(paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    SLog.a(paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    SLog.b(paramString1, paramString2, paramVarArgs);
  }
  
  public void e(String paramString1, String paramString2)
  {
    SLog.e(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    SLog.c(paramString1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2)
  {
    SLog.c(paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    SLog.b(paramString1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    SLog.c(paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2)
  {
    SLog.b(paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    SLog.a(paramString1, "", paramThrowable);
  }
  
  public void w(String paramString1, String paramString2)
  {
    SLog.d(paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    SLog.b(paramString1, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    SLog.d(paramString1, paramString2);
  }
  
  public void w(String paramString, Throwable paramThrowable)
  {
    SLog.b(paramString, "", paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.support.QLogAdapter
 * JD-Core Version:    0.7.0.1
 */