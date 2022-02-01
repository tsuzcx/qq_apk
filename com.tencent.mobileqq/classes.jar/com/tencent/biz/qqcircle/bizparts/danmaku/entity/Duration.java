package com.tencent.biz.qqcircle.bizparts.danmaku.entity;

public class Duration
{
  private long a;
  private long b;
  
  public Duration(long paramLong)
  {
    this.b = paramLong;
    this.a = this.b;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public Duration b()
  {
    return new Duration(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.entity.Duration
 * JD-Core Version:    0.7.0.1
 */