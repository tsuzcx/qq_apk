package com.tencent.luggage.wxa.jm;

import android.util.Log;

final class a$1
  implements b
{
  public void a(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public void a(String paramString1, Throwable paramThrowable, String paramString2)
  {
    paramThrowable.printStackTrace();
  }
  
  public void b(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jm.a.1
 * JD-Core Version:    0.7.0.1
 */