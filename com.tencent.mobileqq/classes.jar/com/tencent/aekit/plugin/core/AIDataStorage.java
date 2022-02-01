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
      AIDataSet localAIDataSet = new AIDataSet();
      Iterator localIterator = this.aiDataMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        AIData localAIData = new AIData((String)localEntry.getKey(), localEntry.getValue());
        localAIDataSet.addAIData((String)localEntry.getKey(), localAIData);
      }
      return localAIDataSet;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public AIDataSet genNewAIDataSet(Map<String, Boolean> paramMap)
  {
    Object localObject = null;
    if (paramMap != null) {
      try
      {
        AIDataSet localAIDataSet = new AIDataSet();
        paramMap = paramMap.entrySet().iterator();
        for (;;)
        {
          localObject = localAIDataSet;
          if (!paramMap.hasNext()) {
            break;
          }
          localObject = (Map.Entry)paramMap.next();
          if (((Boolean)((Map.Entry)localObject).getValue()).booleanValue())
          {
            AIData localAIData = new AIData((String)((Map.Entry)localObject).getKey(), this.aiDataMap.get(((Map.Entry)localObject).getKey()));
            localAIDataSet.addAIData((String)((Map.Entry)localObject).getKey(), localAIData);
          }
        }
      }
      finally {}
    }
    return localObject;
  }
  
  public void init(List<IDetect> paramList)
  {
    int i;
    if (paramList != null) {
      i = 0;
    }
    try
    {
      if (i < paramList.size())
      {
        IDetect localIDetect = (IDetect)paramList.get(i);
        this.aiDataMap.put(localIDetect.getModuleType(), null);
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void put(IDetect paramIDetect)
  {
    if (paramIDetect != null) {}
    try
    {
      this.aiDataMap.put(paramIDetect.getModuleType(), null);
    }
    finally {}
  }
  
  public void remove(String paramString)
  {
    if (paramString != null) {}
    try
    {
      this.aiDataMap.remove(paramString);
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.AIDataStorage
 * JD-Core Version:    0.7.0.1
 */