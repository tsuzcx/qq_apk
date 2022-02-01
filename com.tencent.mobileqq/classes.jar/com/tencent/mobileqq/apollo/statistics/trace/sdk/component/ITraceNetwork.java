package com.tencent.mobileqq.apollo.statistics.trace.sdk.component;

import com.tencent.mobileqq.apollo.api.statistics.trace.data.TraceData;
import java.util.List;

public abstract interface ITraceNetwork
{
  public abstract void a(ITraceReportStrategyListener paramITraceReportStrategyListener);
  
  public abstract void a(List<TraceData> paramList);
  
  public abstract void b(List<TraceData> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.component.ITraceNetwork
 * JD-Core Version:    0.7.0.1
 */