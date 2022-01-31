package com.tencent.component.network.utils.http.pool;

public class PoolStats
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[leased: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("; pending: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("; available: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("; max: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.PoolStats
 * JD-Core Version:    0.7.0.1
 */