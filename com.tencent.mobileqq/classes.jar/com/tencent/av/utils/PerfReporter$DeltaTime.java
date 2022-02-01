package com.tencent.av.utils;

import java.util.Vector;

class PerfReporter$DeltaTime
{
  public long a = 0L;
  public Vector<Integer> b = new Vector(10000);
  public PerfReporter.CalResult c = new PerfReporter.CalResult(null);
  
  public void a()
  {
    this.a = 0L;
    this.b.clear();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeltaTime{start=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", deltas=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PerfReporter.DeltaTime
 * JD-Core Version:    0.7.0.1
 */