package com.tencent.common.danmaku.tool;

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
  
  public void a(float paramFloat)
  {
    this.b = (((float)this.b * paramFloat));
  }
  
  public Duration b()
  {
    return new Duration(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.tool.Duration
 * JD-Core Version:    0.7.0.1
 */