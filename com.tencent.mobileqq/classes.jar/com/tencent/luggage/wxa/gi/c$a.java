package com.tencent.luggage.wxa.gi;

import android.util.Log;

class c$a
  implements c.b
{
  public void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    String str = paramString2;
    if (paramVarArgs != null) {
      str = paramString2;
    }
    try
    {
      if (paramVarArgs.length > 0) {
        str = String.format(paramString2, paramVarArgs);
      }
      Log.d(paramString1, str);
      return;
    }
    catch (Exception paramString2)
    {
      label33:
      break label33;
    }
    Log.e(paramString1, "", paramString2);
  }
  
  public void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    String str;
    if (paramThrowable != null)
    {
      str = paramString2;
      if (paramVarArgs != null) {
        str = paramString2;
      }
    }
    try
    {
      if (paramVarArgs.length > 0) {
        str = String.format(paramString2, paramVarArgs);
      }
      Log.e(paramString1, str, paramThrowable);
      return;
    }
    catch (Exception paramThrowable)
    {
      label41:
      break label41;
    }
    Log.e(paramString1, "", paramThrowable);
  }
  
  public void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    String str = paramString2;
    if (paramVarArgs != null) {
      str = paramString2;
    }
    try
    {
      if (paramVarArgs.length > 0) {
        str = String.format(paramString2, paramVarArgs);
      }
      Log.i(paramString1, str);
      return;
    }
    catch (Exception paramString2)
    {
      label33:
      break label33;
    }
    Log.e(paramString1, "", paramString2);
  }
  
  public void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    String str = paramString2;
    if (paramVarArgs != null) {
      str = paramString2;
    }
    try
    {
      if (paramVarArgs.length > 0) {
        str = String.format(paramString2, paramVarArgs);
      }
      Log.w(paramString1, str);
      return;
    }
    catch (Exception paramString2)
    {
      label33:
      break label33;
    }
    Log.e(paramString1, "", paramString2);
  }
  
  public void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    String str = paramString2;
    if (paramVarArgs != null) {
      str = paramString2;
    }
    try
    {
      if (paramVarArgs.length > 0) {
        str = String.format(paramString2, paramVarArgs);
      }
      Log.e(paramString1, str);
      return;
    }
    catch (Exception paramString2)
    {
      label33:
      break label33;
    }
    Log.e(paramString1, "", paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gi.c.a
 * JD-Core Version:    0.7.0.1
 */