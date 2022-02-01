package com.tencent.mobileqq.apollo.statistics.trace.sdk.component;

import com.tencent.mobileqq.apollo.statistics.trace.data.TraceData;
import java.util.List;

public abstract interface ITraceStorage
{
  public abstract List<TraceData> a();
  
  public abstract boolean a(List<TraceData> paramList);
  
  public abstract boolean b(List<TraceData> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceStorage
 * JD-Core Version:    0.7.0.1
 */