package com.tencent.luggage.wxa.qm;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.t.a;

final class a$1
  implements a
{
  public void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    try
    {
      o.d(paramString1, paramString2, paramVarArgs);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("i: ");
      paramString2.append(paramString1.getMessage());
      o.c("MicroMsg.ExoPlayer", paramString2.toString());
    }
  }
  
  public void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    try
    {
      o.c(paramString1, paramString2, paramVarArgs);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("w: ");
      paramString2.append(paramString1.getMessage());
      o.c("MicroMsg.ExoPlayer", paramString2.toString());
    }
  }
  
  public void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    try
    {
      o.b(paramString1, paramString2, paramVarArgs);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("e: ");
      paramString2.append(paramString1.getMessage());
      o.c("MicroMsg.ExoPlayer", paramString2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qm.a.1
 * JD-Core Version:    0.7.0.1
 */