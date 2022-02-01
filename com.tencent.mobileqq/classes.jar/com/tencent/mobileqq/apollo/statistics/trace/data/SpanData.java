package com.tencent.mobileqq.apollo.statistics.trace.data;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

public class SpanData
{
  public int a;
  public long b;
  public long c;
  public long d;
  public ResultData e;
  public boolean f;
  public BlockingQueue<AnnotationData> g;
  public Map<Integer, Long> h;
  
  public SpanData(int paramInt)
  {
    this.a = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("spanId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",result:");
    localStringBuilder.append(this.e);
    Iterator localIterator;
    if (this.h != null)
    {
      localStringBuilder.append(",extra:[");
      localIterator = this.h.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (QLog.isColorLevel())
        {
          localStringBuilder.append("{");
          localStringBuilder.append(localEntry.getKey());
          localStringBuilder.append(",");
          localStringBuilder.append(localEntry.getValue());
          localStringBuilder.append("}");
        }
        else
        {
          localStringBuilder.append("{");
          localStringBuilder.append(localEntry.getKey());
          localStringBuilder.append("}");
        }
      }
      localStringBuilder.append("]");
    }
    if (this.g != null)
    {
      localStringBuilder.append(",anno:[");
      localIterator = this.g.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((AnnotationData)localIterator.next()).toString());
      }
      localStringBuilder.append("]");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.data.SpanData
 * JD-Core Version:    0.7.0.1
 */