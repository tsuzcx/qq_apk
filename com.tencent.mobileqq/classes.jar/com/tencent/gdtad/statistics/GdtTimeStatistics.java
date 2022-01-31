package com.tencent.gdtad.statistics;

import android.os.SystemClock;

public class GdtTimeStatistics
{
  private long a = -1L;
  private long b = -1L;
  private long c = -1L;
  
  private void c()
  {
    if ((this.b >= this.a) && (this.a != -1L) && (this.b != -1L)) {}
    for (long l = this.b - this.a;; l = -1L)
    {
      if (l != -1L)
      {
        if (this.c == -1L) {
          this.c = 0L;
        }
        this.c = (l + this.c);
      }
      this.a = -1L;
      this.b = -1L;
      return;
    }
  }
  
  public long a()
  {
    return this.c;
  }
  
  public void a()
  {
    this.a = SystemClock.elapsedRealtime();
  }
  
  public void b()
  {
    this.b = SystemClock.elapsedRealtime();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtTimeStatistics
 * JD-Core Version:    0.7.0.1
 */