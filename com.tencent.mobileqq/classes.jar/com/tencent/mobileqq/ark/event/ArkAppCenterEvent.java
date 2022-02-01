package com.tencent.mobileqq.ark.event;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ArkAppCenterEvent
{
  private static final ArkAppCenterEvent.DictObservers a = new ArkAppCenterEvent.DictObservers();
  
  public static void a(int paramInt, String paramString, Object paramObject)
  {
    Object localObject = (ArkAppCenterEvent.Observers)a.get(paramString);
    if (localObject != null)
    {
      localObject = ((ArkAppCenterEvent.Observers)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (localEntry.getValue() != null) {
          ((IArkAppLifeEventCallback)localEntry.getValue()).a(paramInt, paramString, paramObject);
        }
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      paramString1 = a.entrySet().iterator();
      while (paramString1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramString1.next();
        if (localEntry.getValue() != null) {
          ((ArkAppCenterEvent.Observers)localEntry.getValue()).remove(paramString2);
        }
      }
    }
    paramString1 = (ArkAppCenterEvent.Observers)a.get(paramString1);
    if (paramString1 != null) {
      paramString1.remove(paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, IArkAppLifeEventCallback paramIArkAppLifeEventCallback)
  {
    if (paramString1 == null) {
      return;
    }
    ArkAppCenterEvent.Observers localObservers2 = (ArkAppCenterEvent.Observers)a.get(paramString1);
    ArkAppCenterEvent.Observers localObservers1 = localObservers2;
    if (localObservers2 == null)
    {
      localObservers1 = new ArkAppCenterEvent.Observers();
      a.put(paramString1, localObservers1);
    }
    localObservers1.put(paramString2, paramIArkAppLifeEventCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.event.ArkAppCenterEvent
 * JD-Core Version:    0.7.0.1
 */