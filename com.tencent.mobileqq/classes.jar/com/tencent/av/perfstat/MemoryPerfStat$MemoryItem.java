package com.tencent.av.perfstat;

class MemoryPerfStat$MemoryItem
{
  public long a;
  public final String a;
  public long b = 0L;
  public long c = 0L;
  
  public MemoryPerfStat$MemoryItem(String paramString, long paramLong)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    this.b = paramLong;
    this.c = paramLong;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Long < paramLong) {
      this.jdField_a_of_type_Long = paramLong;
    }
    if (this.b > paramLong) {
      this.b = paramLong;
    }
    this.c = ((this.c + paramLong) / 2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.perfstat.MemoryPerfStat.MemoryItem
 * JD-Core Version:    0.7.0.1
 */