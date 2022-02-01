package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

class TimeBase
{
  private long a;
  private double b = 1.0D;
  
  public TimeBase()
  {
    a();
  }
  
  private long d()
  {
    double d1 = System.nanoTime() / 1000L;
    double d2 = this.b;
    Double.isNaN(d1);
    return (d1 * d2);
  }
  
  public void a()
  {
    a(0L);
  }
  
  public void a(long paramLong)
  {
    this.a = (d() - paramLong);
  }
  
  public long b()
  {
    return d() - this.a;
  }
  
  public long b(long paramLong)
  {
    return paramLong - b();
  }
  
  public double c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.TimeBase
 * JD-Core Version:    0.7.0.1
 */