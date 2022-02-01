package com.tencent.biz.pubaccount.weishi_new.net.common;

import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSServiceTimeRecord
{
  private long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
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
  
  public WSServiceTimeRecord(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public long a()
  {
    return this.c - this.b;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public long b()
  {
    return this.d - this.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    this.b = SystemClock.uptimeMillis();
  }
  
  public long c()
  {
    return this.e - this.d;
  }
  
  public void c()
  {
    this.c = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onReqEncodeTime] cmd:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", onReqEncodeCost:");
    localStringBuilder.append(a());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public long d()
  {
    return this.k - this.b;
  }
  
  public void d()
  {
    this.d = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onReqSendTime] cmd:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", onReqPrepareCost:");
    localStringBuilder.append(b());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public long e()
  {
    return this.f - this.e;
  }
  
  public void e()
  {
    this.e = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onRspReceiveTime] cmd:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", onRspReceiveCost:");
    localStringBuilder.append(c());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public long f()
  {
    return this.g - this.f;
  }
  
  public void f()
  {
    this.f = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onDecodeWupTime] cmd:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", onDecodeWupTime:");
    localStringBuilder.append(e());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public long g()
  {
    return this.h - this.g;
  }
  
  public void g()
  {
    this.g = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onDecodeExpTime] cmd:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", onDecodeExpTime:");
    localStringBuilder.append(f());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public long h()
  {
    long l1 = this.i;
    if (l1 == 0L) {
      return -1L;
    }
    return l1 - this.h;
  }
  
  public void h()
  {
    this.h = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onDecodeHeaderTime] cmd:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", onDecodeHeaderTime:");
    localStringBuilder.append(g());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public long i()
  {
    long l1 = this.j;
    if (l1 == 0L) {
      return -1L;
    }
    return l1 - this.i;
  }
  
  public void i()
  {
    this.i = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onDecompressRspTime] cmd:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", onDecompressRspTime:");
    localStringBuilder.append(h());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public long j()
  {
    long l1 = this.i;
    if ((l1 != 0L) && (this.j != 0L)) {
      return this.k - l1;
    }
    return this.k - this.h;
  }
  
  public void j()
  {
    this.j = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onDecompressDataTime] cmd:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", onDecompressDataTime:");
    localStringBuilder.append(i());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public long k()
  {
    return this.l - this.k;
  }
  
  public void k()
  {
    this.k = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onDecodeRspTime] cmd:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", onDecodeRspTime:");
    localStringBuilder.append(j());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public long l()
  {
    return this.m - this.l;
  }
  
  public void l()
  {
    this.l = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onWorkThreadTime] cmd:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", mWorkThreadTime:");
    localStringBuilder.append(k());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
  
  public long m()
  {
    return this.m - this.jdField_a_of_type_Long;
  }
  
  public void m()
  {
    this.m = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onSwitchUIThreadTime] cmd:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", onSwitchUIThreadTime:");
    localStringBuilder.append(l());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSServiceTimeRecord.java][onSwitchUIThreadTime] cmd:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", onReqBisCost:");
    localStringBuilder.append(m());
    WSLog.e("[WSService][TimeRecord]", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceTimeRecord
 * JD-Core Version:    0.7.0.1
 */