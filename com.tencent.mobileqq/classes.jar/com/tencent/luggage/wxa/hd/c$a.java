package com.tencent.luggage.wxa.hd;

import android.text.TextUtils;

abstract class c$a
{
  private boolean a = false;
  private boolean b = false;
  private String c = null;
  private final byte[] d = new byte[0];
  
  String a(String paramString)
  {
    synchronized (this.d)
    {
      if (this.a)
      {
        paramString = this.c;
        return paramString;
      }
      this.c = c();
      if (this.c != null)
      {
        this.a = true;
        paramString = this.c;
        return paramString;
      }
      return paramString;
    }
  }
  
  void b(String paramString)
  {
    synchronized (this.d)
    {
      if ((this.a) && (TextUtils.equals(this.c, paramString))) {
        return;
      }
      this.c = paramString;
      this.a = true;
      this.b = true;
      c(paramString);
      return;
    }
  }
  
  protected abstract boolean b();
  
  protected abstract String c();
  
  protected abstract void c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.c.a
 * JD-Core Version:    0.7.0.1
 */