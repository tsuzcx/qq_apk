package com.tencent.aekit.plugin.core;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class AIActionCounter
{
  private static Map<Integer, AIActionCounter.ActionCounter> actionCounterList = new Hashtable();
  
  private static void clearAction(int paramInt)
  {
    AIActionCounter.ActionCounter localActionCounter2 = (AIActionCounter.ActionCounter)actionCounterList.get(Integer.valueOf(paramInt));
    AIActionCounter.ActionCounter localActionCounter1 = localActionCounter2;
    if (localActionCounter2 == null) {
      localActionCounter1 = new AIActionCounter.ActionCounter(0, -1L);
    }
    localActionCounter1.clear();
  }
  
  public static void clearAction(AIActionCounter.AI_TYPE paramAI_TYPE)
  {
    switch (AIActionCounter.1.$SwitchMap$com$tencent$aekit$plugin$core$AIActionCounter$AI_TYPE[paramAI_TYPE.ordinal()])
    {
    }
    for (;;)
    {
      return;
      paramAI_TYPE = PTHandAttr.handTypes;
      int j = paramAI_TYPE.length;
      int i = 0;
      while (i < j)
      {
        clearAction(paramAI_TYPE[i]);
        i += 1;
      }
    }
  }
  
  public static void clearAll()
  {
    actionCounterList.clear();
  }
  
  public static Map<Integer, Integer> getActions(AIActionCounter.AI_TYPE paramAI_TYPE)
  {
    HashMap localHashMap = new HashMap();
    switch (AIActionCounter.1.$SwitchMap$com$tencent$aekit$plugin$core$AIActionCounter$AI_TYPE[paramAI_TYPE.ordinal()])
    {
    default: 
      return localHashMap;
    }
    paramAI_TYPE = PTHandAttr.handTypes;
    int j = paramAI_TYPE.length;
    int i = 0;
    label48:
    int k;
    if (i < j)
    {
      k = paramAI_TYPE[i];
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
  
  private static void lockAction(int paramInt)
  {
    AIActionCounter.ActionCounter localActionCounter2 = (AIActionCounter.ActionCounter)actionCounterList.get(Integer.valueOf(paramInt));
    AIActionCounter.ActionCounter localActionCounter1 = localActionCounter2;
    if (localActionCounter2 == null) {
      localActionCounter1 = new AIActionCounter.ActionCounter(0, -1L);
    }
    localActionCounter1.lockCounter();
  }
  
  public static void lockAction(AIActionCounter.AI_TYPE paramAI_TYPE)
  {
    switch (AIActionCounter.1.$SwitchMap$com$tencent$aekit$plugin$core$AIActionCounter$AI_TYPE[paramAI_TYPE.ordinal()])
    {
    }
    for (;;)
    {
      return;
      paramAI_TYPE = PTHandAttr.handTypes;
      int j = paramAI_TYPE.length;
      int i = 0;
      while (i < j)
      {
        lockAction(paramAI_TYPE[i]);
        i += 1;
      }
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.AIActionCounter
 * JD-Core Version:    0.7.0.1
 */