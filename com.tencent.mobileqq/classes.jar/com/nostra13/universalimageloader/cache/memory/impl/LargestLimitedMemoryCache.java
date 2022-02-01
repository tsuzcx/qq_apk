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
  
  protected Reference<Bitmap> createReference(Bitmap paramBitmap)
  {
    return new WeakReference(paramBitmap);
  }
  
  protected int getSize(Bitmap paramBitmap)
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
  
  protected Bitmap removeNext()
  {
    Object localObject1 = this.valueSizes.entrySet();
    synchronized (this.valueSizes)
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
          if (localInteger.intValue() > ((Integer)localObject3).intValue())
          {
            localObject1 = (Bitmap)localEntry.getKey();
            localObject3 = localInteger;
          }
        }
      }
      this.valueSizes.remove(localObject1);
      return localObject1;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.LargestLimitedMemoryCache
 * JD-Core Version:    0.7.0.1
 */