package com.tencent.biz.qqcircle.localphoto.scan;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PerformanceRecorder
{
  private int a;
  private long b;
  private final Map<QCirclePhotoScanner.Task, Long> c = new HashMap();
  private final Map<QCirclePhotoScanner.Task, Long> d = new HashMap();
  private final Map<QCirclePhotoScanner.Task, Long> e = new HashMap();
  
  public int a()
  {
    return this.a;
  }
  
  public void a(long paramLong)
  {
    this.a += 1;
    this.b += paramLong;
  }
  
  public void a(QCirclePhotoScanner.Task paramTask, long paramLong)
  {
    Long localLong = (Long)this.c.get(paramTask);
    if (localLong == null) {
      this.c.put(paramTask, Long.valueOf(paramLong));
    } else {
      this.c.put(paramTask, Long.valueOf(localLong.longValue() + paramLong));
    }
    localLong = (Long)this.d.get(paramTask);
    if (localLong == null) {
      this.d.put(paramTask, Long.valueOf(paramLong));
    } else {
      this.d.put(paramTask, Long.valueOf(Math.min(localLong.longValue(), paramLong)));
    }
    localLong = (Long)this.e.get(paramTask);
    if (localLong == null)
    {
      this.e.put(paramTask, Long.valueOf(paramLong));
      return;
    }
    this.e.put(paramTask, Long.valueOf(Math.max(localLong.longValue(), paramLong)));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("totalCount=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("totalCost=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    if (this.a != 0)
    {
      localStringBuilder.append("averageCost=");
      localStringBuilder.append((float)this.b * 1.0F / this.a);
      localStringBuilder.append(", ");
    }
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append("\n");
      localStringBuilder.append("task[");
      localStringBuilder.append(localEntry.getKey());
      localStringBuilder.append("]: ");
      localStringBuilder.append("cost=");
      localStringBuilder.append(localEntry.getValue());
      localStringBuilder.append(", ");
      localStringBuilder.append("minCost=");
      localStringBuilder.append(this.d.get(localEntry.getKey()));
      localStringBuilder.append(", ");
      localStringBuilder.append("maxCost=");
      localStringBuilder.append(this.e.get(localEntry.getKey()));
      if (this.a != 0)
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("averageCost=");
        localStringBuilder.append((float)((Long)localEntry.getValue()).longValue() * 1.0F / this.a);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.PerformanceRecorder
 * JD-Core Version:    0.7.0.1
 */