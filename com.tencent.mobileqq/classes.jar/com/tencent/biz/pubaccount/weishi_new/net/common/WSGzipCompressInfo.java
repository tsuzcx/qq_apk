package com.tencent.biz.pubaccount.weishi_new.net.common;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSGzipCompressInfo
{
  private long a = -1L;
  private long b = -1L;
  private float c = -1.0F;
  
  public long a()
  {
    return this.a;
  }
  
  public void a(float paramFloat)
  {
    this.c = paramFloat;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGzipCompressInfo.java][setRadio] radio:");
    localStringBuilder.append(paramFloat);
    WSLog.e("[WSService][GzipCompressInfo]", localStringBuilder.toString());
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGzipCompressInfo.java][setCompressSize] compressSize:");
    localStringBuilder.append(paramLong);
    WSLog.e("[WSService][GzipCompressInfo]", localStringBuilder.toString());
  }
  
  public long b()
  {
    return this.b;
  }
  
  public void b(long paramLong)
  {
    this.b = paramLong;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGzipCompressInfo.java][decompressSize] decompressSize:");
    localStringBuilder.append(paramLong);
    WSLog.e("[WSService][GzipCompressInfo]", localStringBuilder.toString());
  }
  
  public float c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSGzipCompressInfo
 * JD-Core Version:    0.7.0.1
 */