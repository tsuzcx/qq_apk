package com.etrump.mixlayout.api;

import com.etrump.mixlayout.ETEngine;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ETFontUtil
{
  public static boolean enableAnimation = true;
  
  public static void clearMap(ETEngine paramETEngine)
  {
    if (paramETEngine != null)
    {
      if (paramETEngine.mDescriptorMap == null) {
        return;
      }
      Iterator localIterator = paramETEngine.mDescriptorMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        paramETEngine.native_decorationDeleteDescriptor(((Long)((Map.Entry)localObject).getKey()).longValue());
        if (((WeakReference)((Map.Entry)localObject).getValue()).get() != null)
        {
          localObject = (IETDecoration)((WeakReference)((Map.Entry)localObject).getValue()).get();
          if (localObject != null) {
            ((IETDecoration)localObject).setNativeDescriptorHandle(0L);
          }
        }
      }
      paramETEngine.mDescriptorMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.api.ETFontUtil
 * JD-Core Version:    0.7.0.1
 */