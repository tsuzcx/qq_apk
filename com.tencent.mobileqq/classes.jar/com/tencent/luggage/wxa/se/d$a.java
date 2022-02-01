package com.tencent.luggage.wxa.se;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;

class d$a
  extends Handler
{
  private final String a;
  
  d$a(String paramString, Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper, paramCallback);
    this.a = paramString;
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.se.d.a
 * JD-Core Version:    0.7.0.1
 */