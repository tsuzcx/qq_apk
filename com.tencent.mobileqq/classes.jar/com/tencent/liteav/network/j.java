package com.tencent.liteav.network;

import android.content.Context;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.f;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class j
{
  private Context a;
  private String b;
  private String c;
  private String d;
  private String e;
  private long f;
  private long g;
  private String h;
  private long i;
  private long j;
  private long k;
  private long l;
  private long m;
  private long n;
  private long o;
  private long p;
  private long q;
  private long r;
  private long s;
  private long t;
  private long u;
  private long v;
  private boolean w = true;
  
  public j(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = f.b(this.a);
    this.d = "Android";
    i.a().a(this.a);
    a();
  }
  
  private boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  private boolean c(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  private void e()
  {
    long l1 = this.p;
    long l2 = this.q;
    a();
    this.n = l1;
    this.o = l2;
  }
  
  private void f()
  {
    if ((this.f != 0L) && (!b(this.b)))
    {
      if (b(this.e)) {
        return;
      }
      String str1 = TXCCommonUtil.getStreamIDByStreamUrl(this.e);
      long l5 = System.currentTimeMillis() - this.f;
      long l1 = this.p;
      long l2 = this.n;
      if (l1 > l2) {
        l1 -= l2;
      } else {
        l1 = 0L;
      }
      l2 = this.q;
      long l3 = this.o;
      if (l2 > l3) {
        l2 -= l3;
      } else {
        l2 = 0L;
      }
      l3 = this.v;
      long l4;
      if (l3 > 0L)
      {
        l4 = this.r / l3;
        l3 = this.s / l3;
      }
      else
      {
        l3 = 0L;
        l4 = 0L;
      }
      String str2 = TXCDRApi.txCreateToken();
      TXCDRExtInfo localTXCDRExtInfo = new TXCDRExtInfo();
      localTXCDRExtInfo.report_common = false;
      localTXCDRExtInfo.report_status = false;
      localTXCDRExtInfo.url = this.e;
      TXCDRApi.InitEvent(this.a, str2, a.T, a.al, localTXCDRExtInfo);
      TXCDRApi.txSetEventValue(str2, a.T, "str_user_id", this.b);
      TXCDRApi.txSetEventValue(str2, a.T, "str_stream_id", str1);
      TXCDRApi.txSetEventValue(str2, a.T, "str_access_id", this.c);
      TXCDRApi.txSetEventValue(str2, a.T, "str_platform", this.d);
      TXCDRApi.txSetEventIntValue(str2, a.T, "u32_server_type", this.g);
      TXCDRApi.txSetEventValue(str2, a.T, "str_server_addr", this.h);
      TXCDRApi.txSetEventIntValue(str2, a.T, "u32_dns_timecost", this.i);
      TXCDRApi.txSetEventIntValue(str2, a.T, "u32_connect_timecost", this.j);
      TXCDRApi.txSetEventIntValue(str2, a.T, "u32_handshake_timecost", this.k);
      TXCDRApi.txSetEventIntValue(str2, a.T, "u32_push_type", this.l);
      TXCDRApi.txSetEventIntValue(str2, a.T, "u32_totaltime", l5);
      TXCDRApi.txSetEventIntValue(str2, a.T, "u32_block_count", this.m);
      TXCDRApi.txSetEventIntValue(str2, a.T, "u32_video_drop", l1);
      TXCDRApi.txSetEventIntValue(str2, a.T, "u32_audio_drop", l2);
      TXCDRApi.txSetEventIntValue(str2, a.T, "u32_video_que_avg", l4);
      TXCDRApi.txSetEventIntValue(str2, a.T, "u32_audio_que_avg", l3);
      TXCDRApi.txSetEventIntValue(str2, a.T, "u32_video_que_max", this.t);
      TXCDRApi.txSetEventIntValue(str2, a.T, "u32_audio_que_max", this.u);
      TXCDRApi.nativeReportEvent(str2, a.T);
      if (l5 > 0L)
      {
        l1 = this.m;
        if (l1 != 0L)
        {
          f2 = (float)l1 * 60000.0F / (float)l5;
          break label496;
        }
      }
      float f2 = 0.0F;
      label496:
      l1 = this.v;
      float f1;
      if (l1 > 0L)
      {
        l2 = this.r;
        if (l2 == 0L) {
          f1 = 0.0F;
        } else {
          f1 = (float)l2 / (float)l1;
        }
        l1 = this.s;
        if (l1 != 0L)
        {
          f3 = (float)l1 / (float)this.v;
          break label568;
        }
      }
      else
      {
        f1 = 0.0F;
      }
      float f3 = 0.0F;
      label568:
      if ((this.w) && (!b(this.c)) && (this.k != -1L)) {
        i.a().a(this.c, this.g, l5, this.k, f2, f1, f3);
      }
    }
  }
  
  public void a()
  {
    this.c = "";
    this.f = 0L;
    this.g = -1L;
    this.h = "";
    this.i = -1L;
    this.j = -1L;
    this.k = -1L;
    this.l = -1L;
    this.e = "";
    this.m = 0L;
    this.n = 0L;
    this.o = 0L;
    this.p = 0L;
    this.q = 0L;
    this.r = 0L;
    this.s = 0L;
    this.t = 0L;
    this.u = 0L;
    this.v = 0L;
    this.w = true;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.p = paramLong1;
    this.q = paramLong2;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    this.i = paramLong1;
    this.j = paramLong2;
    this.k = paramLong3;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    long l1;
    if (paramBoolean) {
      l1 = 2L;
    } else {
      l1 = 1L;
    }
    this.l = l1;
    if (paramBoolean) {
      this.w = false;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.h = paramString;
    if (paramBoolean)
    {
      this.g = 1L;
      return;
    }
    if (paramString != null)
    {
      int i2 = paramString.indexOf(":");
      int i1 = 0;
      String str = paramString;
      if (i2 != -1) {
        str = paramString.substring(0, i2);
      }
      if (str != null)
      {
        paramString = str.split("[.]");
        i2 = paramString.length;
        while (i1 < i2)
        {
          if (!c(paramString[i1]))
          {
            this.g = 3L;
            return;
          }
          i1 += 1;
        }
        this.g = 2L;
      }
    }
  }
  
  public void b()
  {
    this.f = System.currentTimeMillis();
    this.c = i.a().b();
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    this.v += 1L;
    this.r += paramLong1;
    this.s += paramLong2;
    if (paramLong1 > this.t) {
      this.t = paramLong1;
    }
    if (paramLong2 > this.u) {
      this.u = paramLong2;
    }
  }
  
  public void c()
  {
    f();
    e();
  }
  
  public void d()
  {
    this.m += 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.network.j
 * JD-Core Version:    0.7.0.1
 */