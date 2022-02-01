package com.tencent.av.wtogether.data;

import android.os.SystemClock;

public class WTSyncPlayInfo
{
  private int a;
  private long b;
  private float c;
  private long d;
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt, long paramLong, float paramFloat)
  {
    this.d = SystemClock.elapsedRealtime();
    this.a = paramInt;
    this.b = paramLong;
    this.c = paramFloat;
  }
  
  public void a(WTSyncPlayInfo paramWTSyncPlayInfo)
  {
    if (paramWTSyncPlayInfo == null) {
      return;
    }
    this.d = SystemClock.elapsedRealtime();
    this.a = paramWTSyncPlayInfo.a;
    this.b = paramWTSyncPlayInfo.b;
    this.c = paramWTSyncPlayInfo.c;
  }
  
  public long b()
  {
    long l2 = this.b;
    long l1 = l2;
    if (this.c == 0.0F)
    {
      l1 = l2;
      if (this.d != 0L)
      {
        l1 = SystemClock.elapsedRealtime();
        l2 = this.b;
        l1 = ((float)(l1 - this.d) * this.c) + l2;
      }
    }
    return l1;
  }
  
  public float c()
  {
    return this.c;
  }
  
  public void d()
  {
    this.a = 2;
    this.b = 0L;
    this.c = 1.0F;
    this.d = 0L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WTSyncPlayInfo[playState: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", playTimeMills[");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", playRate:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", syncTimeMills:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.WTSyncPlayInfo
 * JD-Core Version:    0.7.0.1
 */