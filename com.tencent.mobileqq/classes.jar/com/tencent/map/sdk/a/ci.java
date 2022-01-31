package com.tencent.map.sdk.a;

import android.os.Build;
import android.os.Build.VERSION;

public final class ci
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public ci()
  {
    try
    {
      this.a = Build.MODEL;
      this.b = Build.VERSION.RELEASE;
      this.c = dg.a();
      this.d = dg.b();
      this.e = dg.f();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.ci
 * JD-Core Version:    0.7.0.1
 */