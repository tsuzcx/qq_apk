package com.tencent.mobileqq.activity.aio.doodle;

class PointInfo
{
  float a = 0.0F;
  float b = 0.0F;
  float c = 0.0F;
  long d = 0L;
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramLong;
  }
  
  void a(PointInfo paramPointInfo)
  {
    this.a = paramPointInfo.a;
    this.b = paramPointInfo.b;
    this.c = paramPointInfo.c;
    this.d = paramPointInfo.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PointInfo
 * JD-Core Version:    0.7.0.1
 */