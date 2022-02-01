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
  
  public Reference<Bitmap> createReference(Bitmap paramBitmap)
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
  
  public int getSize(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public boolean put(String paramString, Bitmap paramBitmap)
  {
    boolean bool = false;
    if (super.put(paramString, paramBitmap))
    {
      this.usingCounts.put(paramBitmap, Integer.valueOf(0));
      bool = true;
    }
    return bool;
  }
  
  public Bitmap remove(String paramString)
  {
    Bitmap localBitmap = super.get(paramString);
    if (localBitmap != null) {
      this.usingCounts.remove(localBitmap);
    }
    return super.remove(paramString);
  }
  
  public Bitmap removeNext()
  {
    Bitmap localBitmap = null;
    Object localObject1 = this.usingCounts.entrySet();
    for (;;)
    {
      synchronized (this.usingCounts)
      {
        Iterator localIterator = ((Set)localObject1).iterator();
        localObject1 = null;
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (localBitmap == null)
          {
            localBitmap = (Bitmap)localEntry.getKey();
            localObject1 = (Integer)localEntry.getValue();
          }
          else
          {
            Integer localInteger = (Integer)localEntry.getValue();
            if (localInteger.intValue() < ((Integer)localObject1).intValue())
            {
              localBitmap = (Bitmap)localEntry.getKey();
              localObject1 = localInteger;
            }
          }
        }
        else
        {
          this.usingCounts.remove(localBitmap);
          return localBitmap;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache
 * JD-Core Version:    0.7.0.1
 */