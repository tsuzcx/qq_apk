package com.huawei.hms.framework.network.grs.c;

import android.os.SystemClock;

public class d$a
{
  private long a;
  private long b;
  
  public d$a(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public boolean a()
  {
    return SystemClock.elapsedRealtime() - this.b <= this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.d.a
 * JD-Core Version:    0.7.0.1
 */