package com.tencent.luggage.wxa.rz;

import android.util.Log;

class c$b
  implements c.a
{
  public void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    Log.i(paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    Log.w(paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    Log.e(paramString1, String.format(paramString2, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rz.c.b
 * JD-Core Version:    0.7.0.1
 */