package com.tencent.featuretoggle.hltxkg.access.http.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.access.http.a.d;
import com.tencent.featuretoggle.hltxkg.common.a.i;
import com.tencent.featuretoggle.hltxkg.common.a.k;
import com.tencent.featuretoggle.hltxkg.common.b.a.f;
import com.tencent.featuretoggle.hltxkg.common.e.c;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
  implements k
{
  protected d a;
  public String b;
  public String c;
  protected AtomicInteger d = new AtomicInteger(0);
  protected com.tencent.featuretoggle.hltxkg.common.b.a.a e;
  private int f;
  private int g = 5000;
  private long h;
  private int i = 0;
  
  public a(d paramd)
  {
    this.a = paramd;
    this.b = paramd.a;
    this.c = paramd.a;
    this.f = paramd.f;
    this.h = SystemClock.elapsedRealtime();
  }
  
  public f a()
  {
    try
    {
      this.g = i.a("app_http_proxy_timeout", 0, 20000, 5000);
      int j = this.g;
      if (this.f <= 0) {
        this.f = i.a("app_req_timeout", 1000, 1000000, 15000);
      }
      if ((this.a.k > 0) && (this.a.k < this.f)) {
        this.f = this.a.k;
      }
      j = this.f;
      f localf;
      for (;;)
      {
        localf = a(j);
        j = c.a((int)(this.f - (SystemClock.elapsedRealtime() - this.h)), 0, this.f);
        if ((localf.a != 0) || (localf.c < 300) || (localf.c >= 400) || (!this.a.e) || (j <= 200)) {
          break;
        }
        String str = localf.a("location");
        if (TextUtils.isEmpty(str))
        {
          localf.a = -6;
          break;
        }
        this.c = str;
        this.i += 1;
        if (this.i > 5)
        {
          localf.a = -5;
          break;
        }
        this.e.a(true);
      }
      if (this.a.j)
      {
        localf.a = -20;
        localf.b = "";
      }
      if (this.a.m)
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
      return localf;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return new f(-1, c.a(localThrowable), 0);
    }
  }
  
  protected abstract f a(int paramInt);
  
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
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.access.http.b.a
 * JD-Core Version:    0.7.0.1
 */