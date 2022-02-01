package com.tencent.mobileqq.activity.aio.doodle;

class PointInfo
{
  float jdField_a_of_type_Float = 0.0F;
  long jdField_a_of_type_Long = 0L;
  float b = 0.0F;
  float c = 0.0F;
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  void a(PointInfo paramPointInfo)
  {
    this.jdField_a_of_type_Float = paramPointInfo.jdField_a_of_type_Float;
    this.b = paramPointInfo.b;
    this.c = paramPointInfo.c;
    this.jdField_a_of_type_Long = paramPointInfo.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PointInfo
 * JD-Core Version:    0.7.0.1
 */