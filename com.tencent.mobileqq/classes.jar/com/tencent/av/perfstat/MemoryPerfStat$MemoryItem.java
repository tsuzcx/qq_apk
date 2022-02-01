package com.tencent.av.perfstat;

class MemoryPerfStat$MemoryItem
{
  public final String a;
  public long b = 0L;
  public long c = 0L;
  public long d = 0L;
  
  public MemoryPerfStat$MemoryItem(String paramString, long paramLong)
  {
    this.a = paramString;
    this.b = paramLong;
    this.c = paramLong;
    this.d = paramLong;
  }
  
  public void a(long paramLong)
  {
    if (this.b < paramLong) {
      this.b = paramLong;
    }
    if (this.c > paramLong) {
      this.c = paramLong;
    }
    this.d = ((this.d + paramLong) / 2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.perfstat.MemoryPerfStat.MemoryItem
 * JD-Core Version:    0.7.0.1
 */