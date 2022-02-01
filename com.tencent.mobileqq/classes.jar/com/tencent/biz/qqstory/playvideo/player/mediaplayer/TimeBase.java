package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

class TimeBase
{
  private double jdField_a_of_type_Double = 1.0D;
  private long jdField_a_of_type_Long;
  
  public TimeBase()
  {
    a();
  }
  
  private long b()
  {
    double d1 = System.nanoTime() / 1000L;
    double d2 = this.jdField_a_of_type_Double;
    Double.isNaN(d1);
    return (d1 * d2);
  }
  
  public double a()
  {
    return this.jdField_a_of_type_Double;
  }
  
  public long a()
  {
    return b() - this.jdField_a_of_type_Long;
  }
  
  public long a(long paramLong)
  {
    return paramLong - a();
  }
  
  public void a()
  {
    a(0L);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = (b() - paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.TimeBase
 * JD-Core Version:    0.7.0.1
 */