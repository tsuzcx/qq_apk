package com.tencent.biz.pubaccount.weishi_new.net.common;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSGzipCompressInfo
{
  private float jdField_a_of_type_Float = -1.0F;
  private long jdField_a_of_type_Long = -1L;
  private long b = -1L;
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGzipCompressInfo.java][setRadio] radio:");
    localStringBuilder.append(paramFloat);
    WSLog.e("[WSService][GzipCompressInfo]", localStringBuilder.toString());
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSGzipCompressInfo
 * JD-Core Version:    0.7.0.1
 */