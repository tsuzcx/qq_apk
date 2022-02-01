package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UsingFreqLimitedMemoryCache
  extends LimitedMemoryCache
{
  private final Map<Bitmap, Integer> usingCounts = Collections.synchronizedMap(new HashMap());
  
  public UsingFreqLimitedMemoryCache(int paramInt)
  {
    super(paramInt);
  }
  
  public void clear()
  {
    this.usingCounts.clear();
    super.clear();
  }
  
  protected Reference<Bitmap> createReference(Bitmap paramBitmap)
  {
    return new WeakReference(paramBitmap);
  }
  
  public Bitmap get(String paramString)
  {
    paramString = super.get(paramString);
    if (paramString != null)
    {
      Integer localInteger = (Integer)this.usingCounts.get(paramString);
      if (localInteger != null) {
        this.usingCounts.put(paramString, Integer.valueOf(localInteger.intValue() + 1));
      }
    }
    return paramString;
  }
  
  protected int getSize(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public boolean put(String paramString, Bitmap paramBitmap)
  {
    if (super.put(paramString, paramBitmap))
    {
      this.usingCounts.put(paramBitmap, Integer.valueOf(0));
      return true;
    }
    return false;
  }
  
  public Bitmap remove(String paramString)
  {
    Bitmap localBitmap = super.get(paramString);
    if (localBitmap != null) {
      this.usingCounts.remove(localBitmap);
    }
    return super.remove(paramString);
  }
  
  protected Bitmap removeNext()
  {
    Object localObject1 = this.usingCounts.entrySet();
    synchronized (this.usingCounts)
    {
      Iterator localIterator = ((Set)localObject1).iterator();
      localObject1 = null;
      Object localObject3 = null;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localObject1 == null)
        {
          localObject1 = (Bitmap)localEntry.getKey();
          localObject3 = (Integer)localEntry.getValue();
        }
        else
        {
          Integer localInteger = (Integer)localEntry.getValue();
          if (localInteger.intValue() < ((Integer)localObject3).intValue())
          {
            localObject1 = (Bitmap)localEntry.getKey();
            localObject3 = localInteger;
          }
        }
      }
      this.usingCounts.remove(localObject1);
      return localObject1;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache
 * JD-Core Version:    0.7.0.1
 */