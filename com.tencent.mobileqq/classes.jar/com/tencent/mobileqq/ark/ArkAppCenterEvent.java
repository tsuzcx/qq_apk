package com.tencent.mobileqq.ark;

import anjr;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ArkAppCenterEvent
{
  private static ArkAppCenterEvent.DictObservers a = new ArkAppCenterEvent.DictObservers();
  
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
          ((anjr)localEntry.getValue()).a(paramInt, paramString, paramObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCenterEvent
 * JD-Core Version:    0.7.0.1
 */