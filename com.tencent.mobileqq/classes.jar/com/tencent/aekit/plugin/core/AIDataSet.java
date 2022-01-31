package com.tencent.aekit.plugin.core;

import java.util.Hashtable;
import java.util.Map;

public class AIDataSet
{
  private Map<String, AIData> aiDataMap = new Hashtable();
  
  public void addAIData(String paramString, AIData paramAIData)
  {
    this.aiDataMap.put(paramString, paramAIData);
  }
  
  public void clear()
  {
    if (this.aiDataMap != null) {
      this.aiDataMap.clear();
    }
  }
  
  public AIData getAIData(String paramString)
  {
    return (AIData)this.aiDataMap.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.AIDataSet
 * JD-Core Version:    0.7.0.1
 */