package com.tencent.biz.pubaccount.weishi_new.net.common;

import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSServiceTimeRecord
{
  private final String a;
  private long b;
  private long c;
  private long d;
  private long e;
  private long f;
  private long g;
  private long h;
  private long i;
  private long j;
  private long k;
  private long l;
  private long m;
  private long n;
  
  public WSServiceTimeRecord(String paramString)
  {
    this.a = paramString;
  }
  
  public void a()
  {
    this.b = SystemClock.uptimeMillis();
  }
  
  public void b()
  {
    this.c = SystemClock.uptimeMillis();
  }
  
  public void c()
  {
    this.d = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onReqEncodeTime] cmd:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", onReqEncodeCost:");
    localStringBuilder.append(n());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public void d()
  {
    this.e = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onReqSendTime] cmd:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", onReqPrepareCost:");
    localStringBuilder.append(o());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public void e()
  {
    this.f = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onRspReceiveTime] cmd:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", onRspReceiveCost:");
    localStringBuilder.append(p());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public void f()
  {
    this.g = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onDecodeWupTime] cmd:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", onDecodeWupTime:");
    localStringBuilder.append(r());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public void g()
  {
    this.h = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onDecodeExpTime] cmd:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", onDecodeExpTime:");
    localStringBuilder.append(s());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public void h()
  {
    this.i = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onDecodeHeaderTime] cmd:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", onDecodeHeaderTime:");
    localStringBuilder.append(t());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public void i()
  {
    this.j = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onDecompressRspTime] cmd:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", onDecompressRspTime:");
    localStringBuilder.append(u());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public void j()
  {
    this.k = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onDecompressDataTime] cmd:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", onDecompressDataTime:");
    localStringBuilder.append(v());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public void k()
  {
    this.l = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onDecodeRspTime] cmd:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", onDecodeRspTime:");
    localStringBuilder.append(w());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public void l()
  {
    this.m = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onWorkThreadTime] cmd:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mWorkThreadTime:");
    localStringBuilder.append(x());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public void m()
  {
    this.n = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onSwitchUIThreadTime] cmd:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", onSwitchUIThreadTime:");
    localStringBuilder.append(y());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onSwitchUIThreadTime] cmd:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", onReqBisCost:");
    localStringBuilder.append(z());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public long n()
  {
    return this.d - this.c;
  }
  
  public long o()
  {
    return this.e - this.b;
  }
  
  public long p()
  {
    return this.f - this.e;
  }
  
  public long q()
  {
    return this.l - this.c;
  }
  
  public long r()
  {
    return this.g - this.f;
  }
  
  public long s()
  {
    return this.h - this.g;
  }
  
  public long t()
  {
    return this.i - this.h;
  }
  
  public long u()
  {
    long l1 = this.j;
    if (l1 == 0L) {
      return -1L;
    }
    return l1 - this.i;
  }
  
  public long v()
  {
    long l1 = this.k;
    if (l1 == 0L) {
      return -1L;
    }
    return l1 - this.j;
  }
  
  public long w()
  {
    long l1 = this.j;
    if ((l1 != 0L) && (this.k != 0L)) {
      return this.l - l1;
    }
    return this.l - this.i;
  }
  
  public long x()
  {
    return this.m - this.l;
  }
  
  public long y()
  {
    return this.n - this.m;
  }
  
  public long z()
  {
    return this.n - this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceTimeRecord
 * JD-Core Version:    0.7.0.1
 */