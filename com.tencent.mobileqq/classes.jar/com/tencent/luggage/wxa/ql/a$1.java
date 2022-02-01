package com.tencent.luggage.wxa.ql;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.qqmusic.mediaplayer.ILog;

final class a$1
  implements ILog
{
  public void d(String paramString1, String paramString2)
  {
    o.e(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    o.b(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    o.a(paramString1, paramThrowable, paramString2, new Object[0]);
  }
  
  public void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    o.b(paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public void e(String paramString, Throwable paramThrowable)
  {
    o.a(paramString, paramThrowable, " throwable", new Object[0]);
  }
  
  public void i(String paramString1, String paramString2)
  {
    o.d(paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    o.a(paramString1, paramThrowable, paramString2, new Object[0]);
  }
  
  public void w(String paramString1, String paramString2)
  {
    o.c(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ql.a.1
 * JD-Core Version:    0.7.0.1
 */