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
    WSLog.e("[WSService][TimeRecord]", "[WSServiceTimeRecord.java][onReqEncodeTime] cmd:" + this.jdField_a_of_type_JavaLangString + ", onReqEncodeCost:" + a());
  }
  
  public long d()
  {
    return this.k - this.b;
  }
  
  public void d()
  {
    this.d = SystemClock.uptimeMillis();
    WSLog.e("[WSService][TimeRecord]", "[WSServiceTimeRecord.java][onReqSendTime] cmd:" + this.jdField_a_of_type_JavaLangString + ", onReqPrepareCost:" + b());
  }
  
  public long e()
  {
    return this.f - this.e;
  }
  
  public void e()
  {
    this.e = SystemClock.uptimeMillis();
    WSLog.e("[WSService][TimeRecord]", "[WSServiceTimeRecord.java][onRspReceiveTime] cmd:" + this.jdField_a_of_type_JavaLangString + ", onRspReceiveCost:" + c());
  }
  
  public long f()
  {
    return this.g - this.f;
  }
  
  public void f()
  {
    this.f = SystemClock.uptimeMillis();
    WSLog.e("[WSService][TimeRecord]", "[WSServiceTimeRecord.java][onDecodeWupTime] cmd:" + this.jdField_a_of_type_JavaLangString + ", onDecodeWupTime:" + e());
  }
  
  public long g()
  {
    return this.h - this.g;
  }
  
  public void g()
  {
    this.g = SystemClock.uptimeMillis();
    WSLog.e("[WSService][TimeRecord]", "[WSServiceTimeRecord.java][onDecodeExpTime] cmd:" + this.jdField_a_of_type_JavaLangString + ", onDecodeExpTime:" + f());
  }
  
  public long h()
  {
    if (this.i == 0L) {
      return -1L;
    }
    return this.i - this.h;
  }
  
  public void h()
  {
    this.h = SystemClock.uptimeMillis();
    WSLog.e("[WSService][TimeRecord]", "[WSServiceTimeRecord.java][onDecodeHeaderTime] cmd:" + this.jdField_a_of_type_JavaLangString + ", onDecodeHeaderTime:" + g());
  }
  
  public long i()
  {
    if (this.j == 0L) {
      return -1L;
    }
    return this.j - this.i;
  }
  
  public void i()
  {
    this.i = SystemClock.uptimeMillis();
    WSLog.e("[WSService][TimeRecord]", "[WSServiceTimeRecord.java][onDecompressRspTime] cmd:" + this.jdField_a_of_type_JavaLangString + ", onDecompressRspTime:" + h());
  }
  
  public long j()
  {
    if ((this.i == 0L) || (this.j == 0L)) {
      return this.k - this.h;
    }
    return this.k - this.i;
  }
  
  public void j()
  {
    this.j = SystemClock.uptimeMillis();
    WSLog.e("[WSService][TimeRecord]", "[WSServiceTimeRecord.java][onDecompressDataTime] cmd:" + this.jdField_a_of_type_JavaLangString + ", onDecompressDataTime:" + i());
  }
  
  public long k()
  {
    return this.l - this.k;
  }
  
  public void k()
  {
    this.k = SystemClock.uptimeMillis();
    WSLog.e("[WSService][TimeRecord]", "[WSServiceTimeRecord.java][onDecodeRspTime] cmd:" + this.jdField_a_of_type_JavaLangString + ", onDecodeRspTime:" + j());
  }
  
  public long l()
  {
    return this.m - this.l;
  }
  
  public void l()
  {
    this.l = SystemClock.uptimeMillis();
    WSLog.e("[WSService][TimeRecord]", "[WSServiceTimeRecord.java][onWorkThreadTime] cmd:" + this.jdField_a_of_type_JavaLangString + ", mWorkThreadTime:" + k());
  }
  
  public long m()
  {
    return this.m - this.jdField_a_of_type_Long;
  }
  
  public void m()
  {
    this.m = SystemClock.uptimeMillis();
    WSLog.e("[WSService][TimeRecord]", "[WSServiceTimeRecord.java][onSwitchUIThreadTime] cmd:" + this.jdField_a_of_type_JavaLangString + ", onSwitchUIThreadTime:" + l());
    WSLog.e("[WSService][TimeRecord]", "[WSServiceTimeRecord.java][onSwitchUIThreadTime] cmd:" + this.jdField_a_of_type_JavaLangString + ", onReqBisCost:" + m());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceTimeRecord
 * JD-Core Version:    0.7.0.1
 */