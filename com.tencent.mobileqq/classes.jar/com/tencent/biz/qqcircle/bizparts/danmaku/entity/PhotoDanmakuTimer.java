package com.tencent.biz.qqcircle.bizparts.danmaku.entity;

public class PhotoDanmakuTimer
{
  private long a;
  private long b;
  
  public long a()
  {
    return this.a;
  }
  
  public long a(long paramLong)
  {
    this.b = (paramLong - this.a);
    this.a = paramLong;
    return this.b;
  }
  
  public long b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.entity.PhotoDanmakuTimer
 * JD-Core Version:    0.7.0.1
 */