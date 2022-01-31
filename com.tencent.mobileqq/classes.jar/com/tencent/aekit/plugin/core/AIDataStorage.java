package com.tencent.aekit.plugin.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AIDataStorage
{
  Map<String, Object> aiDataMap = new HashMap();
  
  public void clear()
  {
    try
    {
      this.aiDataMap.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public AIDataSet genNewAIDataSet()
  {
    try
    {
      AIDataSet localAIDataSet1 = new AIDataSet();
      Iterator localIterator = this.aiDataMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        AIData localAIData = new AIData((String)localEntry.getKey(), localEntry.getValue());
        localAIDataSet1.addAIData((String)localEntry.getKey(), localAIData);
      }
    }
    finally {}
    return localAIDataSet2;
  }
  
  public AIDataSet genNewAIDataSet(Map<String, Boolean> paramMap)
  {
    AIDataSet localAIDataSet = null;
    if (paramMap != null) {
      try
      {
        localAIDataSet = new AIDataSet();
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          if (((Boolean)localEntry.getValue()).booleanValue())
          {
            AIData localAIData = new AIData((String)localEntry.getKey(), this.aiDataMap.get(localEntry.getKey()));
            localAIDataSet.addAIData((String)localEntry.getKey(), localAIData);
          }
        }
      }
      finally {}
    }
    return localAIDataSet;
  }
  
  public void init(List<IDetect> paramList)
  {
    int i;
    if (paramList != null) {
      i = 0;
    }
    try
    {
      while (i < paramList.size())
      {
        IDetect localIDetect = (IDetect)paramList.get(i);
        this.aiDataMap.put(localIDetect.getModuleType(), null);
        i += 1;
      }
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public void put(IDetect paramIDetect)
  {
    if (paramIDetect != null) {}
    try
    {
      this.aiDataMap.put(paramIDetect.getModuleType(), null);
      return;
    }
    finally
    {
      paramIDetect = finally;
      throw paramIDetect;
    }
  }
  
  public void remove(String paramString)
  {
    if (paramString != null) {}
    try
    {
      this.aiDataMap.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void reset(String paramString)
  {
    try
    {
      this.aiDataMap.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void update(String paramString, Object paramObject)
  {
    try
    {
      this.aiDataMap.put(paramString, paramObject);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.AIDataStorage
 * JD-Core Version:    0.7.0.1
 */