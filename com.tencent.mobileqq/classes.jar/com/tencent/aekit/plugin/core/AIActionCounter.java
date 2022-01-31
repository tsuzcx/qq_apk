package com.tencent.aekit.plugin.core;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AIActionCounter
{
  private static Map<Integer, AIActionCounter.ActionCounter> actionCounterList = new Hashtable();
  private static Map<String, AIActionCounter.ActionCounter> commonActionCounterMap = new Hashtable();
  
  private static void clearAction(int paramInt)
  {
    AIActionCounter.ActionCounter localActionCounter2 = (AIActionCounter.ActionCounter)actionCounterList.get(Integer.valueOf(paramInt));
    AIActionCounter.ActionCounter localActionCounter1 = localActionCounter2;
    if (localActionCounter2 == null) {
      localActionCounter1 = new AIActionCounter.ActionCounter(0, -1L);
    }
    localActionCounter1.clear();
  }
  
  public static void clearAction(AEDetectorType paramAEDetectorType)
  {
    switch (AIActionCounter.1.$SwitchMap$com$tencent$aekit$plugin$core$AEDetectorType[paramAEDetectorType.ordinal()])
    {
    }
    for (;;)
    {
      return;
      paramAEDetectorType = PTHandAttr.handTypes;
      int j = paramAEDetectorType.length;
      int i = 0;
      while (i < j)
      {
        clearAction(paramAEDetectorType[i]);
        i += 1;
      }
      continue;
      Iterator localIterator = commonActionCounterMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)((Map.Entry)localIterator.next()).getKey();
        if (str.startsWith(paramAEDetectorType.value)) {
          clearAction(str);
        }
      }
    }
  }
  
  private static void clearAction(String paramString)
  {
    AIActionCounter.ActionCounter localActionCounter = (AIActionCounter.ActionCounter)commonActionCounterMap.get(paramString);
    paramString = localActionCounter;
    if (localActionCounter == null) {
      paramString = new AIActionCounter.ActionCounter(0, -1L);
    }
    paramString.clear();
  }
  
  public static void clearAll()
  {
    actionCounterList.clear();
    commonActionCounterMap.clear();
  }
  
  public static Map<Integer, Integer> getActions(AEDetectorType paramAEDetectorType)
  {
    HashMap localHashMap = new HashMap();
    switch (AIActionCounter.1.$SwitchMap$com$tencent$aekit$plugin$core$AEDetectorType[paramAEDetectorType.ordinal()])
    {
    default: 
      return localHashMap;
    }
    paramAEDetectorType = PTHandAttr.handTypes;
    int j = paramAEDetectorType.length;
    int i = 0;
    label48:
    int k;
    if (i < j)
    {
      k = paramAEDetectorType[i];
      AIActionCounter.ActionCounter localActionCounter = (AIActionCounter.ActionCounter)actionCounterList.get(Integer.valueOf(k));
      if (localActionCounter == null) {
        break label106;
      }
      localHashMap.put(Integer.valueOf(k), Integer.valueOf(localActionCounter.count));
    }
    for (;;)
    {
      i += 1;
      break label48;
      break;
      label106:
      localHashMap.put(Integer.valueOf(k), Integer.valueOf(0));
    }
  }
  
  public static Map<String, Integer> getCommonActions(AEDetectorType paramAEDetectorType)
  {
    HashMap localHashMap = new HashMap();
    switch (AIActionCounter.1.$SwitchMap$com$tencent$aekit$plugin$core$AEDetectorType[paramAEDetectorType.ordinal()])
    {
    }
    for (;;)
    {
      return localHashMap;
      Iterator localIterator = commonActionCounterMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        if (str.startsWith(paramAEDetectorType.name()))
        {
          str = str.substring(paramAEDetectorType.value.length());
          localObject = (AIActionCounter.ActionCounter)((Map.Entry)localObject).getValue();
          if (localObject != null) {
            localHashMap.put(str, Integer.valueOf(((AIActionCounter.ActionCounter)localObject).count));
          } else {
            localHashMap.put(str, Integer.valueOf(0));
          }
        }
      }
    }
  }
  
  private static void lockAction(int paramInt)
  {
    AIActionCounter.ActionCounter localActionCounter2 = (AIActionCounter.ActionCounter)actionCounterList.get(Integer.valueOf(paramInt));
    AIActionCounter.ActionCounter localActionCounter1 = localActionCounter2;
    if (localActionCounter2 == null) {
      localActionCounter1 = new AIActionCounter.ActionCounter(0, -1L);
    }
    localActionCounter1.lockCounter();
  }
  
  public static void lockAction(AEDetectorType paramAEDetectorType)
  {
    switch (AIActionCounter.1.$SwitchMap$com$tencent$aekit$plugin$core$AEDetectorType[paramAEDetectorType.ordinal()])
    {
    }
    for (;;)
    {
      return;
      paramAEDetectorType = PTHandAttr.handTypes;
      int j = paramAEDetectorType.length;
      int i = 0;
      while (i < j)
      {
        lockAction(paramAEDetectorType[i]);
        i += 1;
      }
      continue;
      Iterator localIterator = commonActionCounterMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)((Map.Entry)localIterator.next()).getKey();
        if (str.startsWith(paramAEDetectorType.name())) {
          lockAction(str);
        }
      }
    }
  }
  
  private static void lockAction(String paramString)
  {
    AIActionCounter.ActionCounter localActionCounter = (AIActionCounter.ActionCounter)commonActionCounterMap.get(paramString);
    paramString = localActionCounter;
    if (localActionCounter == null) {
      paramString = new AIActionCounter.ActionCounter(0, -1L);
    }
    paramString.lockCounter();
  }
  
  public static void updateAction(int paramInt)
  {
    AIActionCounter.ActionCounter localActionCounter2 = (AIActionCounter.ActionCounter)actionCounterList.get(Integer.valueOf(paramInt));
    AIActionCounter.ActionCounter localActionCounter1 = localActionCounter2;
    if (localActionCounter2 == null) {
      localActionCounter1 = new AIActionCounter.ActionCounter(0, -1L);
    }
    if (!localActionCounter1.locked)
    {
      long l = System.currentTimeMillis();
      if (l - localActionCounter1.updateTime > 1000L)
      {
        localActionCounter1.count += 1;
        localActionCounter1.updateTime = l;
      }
      actionCounterList.put(Integer.valueOf(paramInt), localActionCounter1);
    }
  }
  
  public static void updateAction(String paramString)
  {
    AIActionCounter.ActionCounter localActionCounter2 = (AIActionCounter.ActionCounter)commonActionCounterMap.get(paramString);
    AIActionCounter.ActionCounter localActionCounter1 = localActionCounter2;
    if (localActionCounter2 == null) {
      localActionCounter1 = new AIActionCounter.ActionCounter(0, -1L);
    }
    if (!localActionCounter1.locked)
    {
      long l = System.currentTimeMillis();
      if (l - localActionCounter1.updateTime > 1000L)
      {
        localActionCounter1.count += 1;
        localActionCounter1.updateTime = l;
      }
      commonActionCounterMap.put(paramString, localActionCounter1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.AIActionCounter
 * JD-Core Version:    0.7.0.1
 */