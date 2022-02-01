package com.tencent.av;

class VideoCallStateMonitor$MemoryDetail
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  long b;
  long c;
  long d;
  long e;
  long f;
  
  VideoCallStateMonitor$MemoryDetail(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramLong4;
    this.e = paramLong5;
    this.f = paramLong6;
  }
  
  boolean a()
  {
    return (this.jdField_a_of_type_Long > 0L) && (this.b > 0L) && (this.c > 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoCallStateMonitor.MemoryDetail
 * JD-Core Version:    0.7.0.1
 */