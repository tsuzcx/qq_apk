package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class LruMemoryCache
  implements MemoryCache
{
  private final LinkedHashMap<String, Bitmap> map;
  private final int maxSize;
  private int size;
  
  public LruMemoryCache(int paramInt)
  {
    if (paramInt > 0)
    {
      this.maxSize = paramInt;
      this.map = new LinkedHashMap(0, 0.75F, true);
      return;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private int sizeOf(String paramString, Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  private void trimToSize(int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if ((this.size >= 0) && ((!this.map.isEmpty()) || (this.size == 0)))
        {
          if ((this.size > paramInt) && (!this.map.isEmpty()))
          {
            Object localObject3 = (Map.Entry)this.map.entrySet().iterator().next();
            if (localObject3 == null) {
              return;
            }
            localObject1 = (String)((Map.Entry)localObject3).getKey();
            localObject3 = (Bitmap)((Map.Entry)localObject3).getValue();
            this.map.remove(localObject1);
            this.size -= sizeOf((String)localObject1, (Bitmap)localObject3);
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(getClass().getName());
          ((StringBuilder)localObject1).append(".sizeOf() is reporting inconsistent results!");
          throw new IllegalStateException(((StringBuilder)localObject1).toString());
        }
      }
      finally {}
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void clear()
  {
    trimToSize(-1);
  }
  
  public final Bitmap get(String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = (Bitmap)this.map.get(paramString);
        return paramString;
      }
      finally {}
    }
    throw new NullPointerException("key == null");
  }
  
  public Collection<String> keys()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.map.keySet());
      return localHashSet;
    }
    finally {}
  }
  
  public final boolean put(String paramString, Bitmap paramBitmap)
  {
    if ((paramString != null) && (paramBitmap != null)) {
      try
      {
        this.size += sizeOf(paramString, paramBitmap);
        paramBitmap = (Bitmap)this.map.put(paramString, paramBitmap);
        if (paramBitmap != null) {
          this.size -= sizeOf(paramString, paramBitmap);
        }
        trimToSize(this.maxSize);
        return true;
      }
      finally {}
    }
    throw new NullPointerException("key == null || value == null");
  }
  
  public final Bitmap remove(String paramString)
  {
    if (paramString != null) {
      try
      {
        Bitmap localBitmap = (Bitmap)this.map.remove(paramString);
        if (localBitmap != null) {
          this.size -= sizeOf(paramString, localBitmap);
        }
        return localBitmap;
      }
      finally {}
    }
    throw new NullPointerException("key == null");
  }
  
  public final String toString()
  {
    try
    {
      String str = String.format("LruCache[maxSize=%d]", new Object[] { Integer.valueOf(this.maxSize) });
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache
 * JD-Core Version:    0.7.0.1
 */