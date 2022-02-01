package com.tencent.map.sdk.a;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class aa
  implements au
{
  protected y a;
  public String b;
  public String c;
  protected AtomicInteger d = new AtomicInteger(0);
  protected bc e;
  private int f;
  private int g = 5000;
  private long h;
  private int i = 0;
  
  public aa(y paramy)
  {
    this.a = paramy;
    this.b = paramy.a;
    this.c = paramy.a;
    this.f = paramy.f;
    this.h = SystemClock.elapsedRealtime();
  }
  
  public bh a()
  {
    try
    {
      this.g = as.a("app_http_proxy_timeout", 0, 20000, 5000);
      if (this.f <= 0) {
        this.f = as.a("app_req_timeout", 1000, 1000000, 15000);
      }
      if ((this.a.k > 0) && (this.a.k < this.f)) {
        this.f = this.a.k;
      }
      int j = this.f;
      bh localbh;
      for (;;)
      {
        localbh = a(j);
        j = dg.a((int)(this.f - (SystemClock.elapsedRealtime() - this.h)), this.f);
        if ((localbh.a != 0) || (localbh.c < 300) || (localbh.c >= 400) || (!this.a.e) || (j <= 200)) {
          break;
        }
        String str = localbh.a("location");
        if (TextUtils.isEmpty(str))
        {
          localbh.a = -6;
          break;
        }
        this.c = str;
        this.i += 1;
        if (this.i > 5)
        {
          localbh.a = -5;
          break;
        }
        this.e.a(true);
      }
      if (this.a.j)
      {
        localbh.a = -20;
        localbh.b = "";
      }
      if (this.a.n)
      {
        this.e.k = true;
        this.e.j = true;
        this.e.l = this.a.k;
      }
      else
      {
        this.e.l = (SystemClock.elapsedRealtime() - this.h);
      }
      this.e.a(false);
      return localbh;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return new bh(-1, dg.a(localThrowable));
    }
  }
  
  protected abstract bh a(int paramInt);
  
  public final boolean b()
  {
    try
    {
      if (this.e != null) {
        this.e.b();
      }
      label15:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label15;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.aa
 * JD-Core Version:    0.7.0.1
 */