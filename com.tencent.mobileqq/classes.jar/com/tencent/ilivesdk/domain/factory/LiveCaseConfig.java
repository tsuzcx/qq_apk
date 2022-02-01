package com.tencent.ilivesdk.domain.factory;

import java.util.HashMap;
import java.util.Map;

public class LiveCaseConfig
{
  private Map<LiveCaseType, Class<? extends LiveUseCase>> caseMap = new HashMap();
  
  public <T extends LiveUseCase> void add(LiveCaseType paramLiveCaseType, Class<? extends LiveUseCase> paramClass)
  {
    this.caseMap.put(paramLiveCaseType, paramClass);
  }
  
  public void clear()
  {
    this.caseMap.clear();
  }
  
  public Map<LiveCaseType, Class<? extends LiveUseCase>> get()
  {
    return this.caseMap;
  }
  
  public void merge(LiveCaseConfig paramLiveCaseConfig)
  {
    this.caseMap.putAll(paramLiveCaseConfig.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.factory.LiveCaseConfig
 * JD-Core Version:    0.7.0.1
 */