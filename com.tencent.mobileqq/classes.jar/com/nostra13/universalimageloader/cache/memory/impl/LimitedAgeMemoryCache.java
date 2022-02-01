package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LimitedAgeMemoryCache
  implements MemoryCache
{
  private final MemoryCache cache;
  private final Map<String, Long> loadingDates = Collections.synchronizedMap(new HashMap());
  private final long maxAge;
  
  public LimitedAgeMemoryCache(MemoryCache paramMemoryCache, long paramLong)
  {
    this.cache = paramMemoryCache;
    this.maxAge = (1000L * paramLong);
  }
  
  public void clear()
  {
    this.cache.clear();
    this.loadingDates.clear();
  }
  
  public Bitmap get(String paramString)
  {
    Long localLong = (Long)this.loadingDates.get(paramString);
    if ((localLong != null) && (System.currentTimeMillis() - localLong.longValue() > this.maxAge))
    {
      this.cache.remove(paramString);
      this.loadingDates.remove(paramString);
    }
    return this.cache.get(paramString);
  }
  
  public Collection<String> keys()
  {
    return this.cache.keys();
  }
  
  public boolean put(String paramString, Bitmap paramBitmap)
  {
    boolean bool = this.cache.put(paramString, paramBitmap);
    if (bool) {
      this.loadingDates.put(paramString, Long.valueOf(System.currentTimeMillis()));
    }
    return bool;
  }
  
  public Bitmap remove(String paramString)
  {
    this.loadingDates.remove(paramString);
    return this.cache.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.LimitedAgeMemoryCache
 * JD-Core Version:    0.7.0.1
 */