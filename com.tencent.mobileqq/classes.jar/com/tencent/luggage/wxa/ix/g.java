package com.tencent.luggage.wxa.ix;

import android.os.Looper;
import android.text.TextUtils;

public abstract class g
  extends h
{
  private final String[] a = { "invokeEnterMethods", "invokeExitMethods", "handleMessage:", "quit" };
  private boolean b = false;
  
  public g(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    super.b(true);
  }
  
  public abstract void a(f paramf);
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString = this.a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.startsWith(arrayOfString[i]))
      {
        i = 1;
        break label50;
      }
      i += 1;
    }
    i = 0;
    label50:
    if (i != 0) {
      super.c(paramString);
    } else {
      super.b(paramString);
    }
    if (paramString.startsWith("handleMessage: E")) {
      this.b = true;
    }
    if (paramString.startsWith("handleMessage: X")) {
      this.b = false;
    }
  }
  
  protected final boolean j()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ix.g
 * JD-Core Version:    0.7.0.1
 */