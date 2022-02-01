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

public class LargestLimitedMemoryCache
  extends LimitedMemoryCache
{
  private final Map<Bitmap, Integer> valueSizes = Collections.synchronizedMap(new HashMap());
  
  public LargestLimitedMemoryCache(int paramInt)
  {
    super(paramInt);
  }
  
  public void clear()
  {
    this.valueSizes.clear();
    super.clear();
  }
  
  public Reference<Bitmap> createReference(Bitmap paramBitmap)
  {
    return new WeakReference(paramBitmap);
  }
  
  public int getSize(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public boolean put(String paramString, Bitmap paramBitmap)
  {
    if (super.put(paramString, paramBitmap))
    {
      this.valueSizes.put(paramBitmap, Integer.valueOf(getSize(paramBitmap)));
      return true;
    }
    return false;
  }
  
  public Bitmap remove(String paramString)
  {
    Bitmap localBitmap = super.get(paramString);
    if (localBitmap != null) {
      this.valueSizes.remove(localBitmap);
    }
    return super.remove(paramString);
  }
  
  public Bitmap removeNext()
  {
    Bitmap localBitmap = null;
    Object localObject1 = this.valueSizes.entrySet();
    for (;;)
    {
      synchronized (this.valueSizes)
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
            if (localInteger.intValue() > ((Integer)localObject1).intValue())
            {
              localBitmap = (Bitmap)localEntry.getKey();
              localObject1 = localInteger;
            }
          }
        }
        else
        {
          this.valueSizes.remove(localBitmap);
          return localBitmap;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.LargestLimitedMemoryCache
 * JD-Core Version:    0.7.0.1
 */