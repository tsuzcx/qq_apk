package com.tencent.ditto.area;

import android.support.v4.util.LruCache;
import com.tencent.ditto.utils.DittoLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MeasureCacheable
{
  public static final LruCache<MeasureCacheable.CanvasMeasureCacheKey, MeasureCacheable.TextMeasureCacheItem> mMeasureCache = new LruCache(2048);
  
  public static void removeMeasureCache(Integer paramInteger)
  {
    if (paramInteger == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = mMeasureCache.snapshot().entrySet().iterator();
      while (localIterator.hasNext())
      {
        MeasureCacheable.CanvasMeasureCacheKey localCanvasMeasureCacheKey = (MeasureCacheable.CanvasMeasureCacheKey)((Map.Entry)localIterator.next()).getKey();
        if ((localCanvasMeasureCacheKey != null) && (paramInteger.equals(localCanvasMeasureCacheKey.cacheKey))) {
          mMeasureCache.remove(localCanvasMeasureCacheKey);
        }
      }
    }
  }
  
  public void addMeasureCache(Integer paramInteger, int paramInt1, int paramInt2, MeasureCacheable.TextMeasureCacheItem paramTextMeasureCacheItem)
  {
    if ((paramTextMeasureCacheItem == null) || (paramInteger == null)) {
      return;
    }
    paramInteger = new MeasureCacheable.CanvasMeasureCacheKey(paramInteger, paramInt1, paramInt2);
    mMeasureCache.put(paramInteger, paramTextMeasureCacheItem);
  }
  
  public MeasureCacheable.TextMeasureCacheItem getMeasureCache(Integer paramInteger, int paramInt1, int paramInt2)
  {
    if (paramInteger == null) {
      return null;
    }
    try
    {
      paramInteger = new MeasureCacheable.CanvasMeasureCacheKey(paramInteger, paramInt1, paramInt2);
      paramInteger = (MeasureCacheable.TextMeasureCacheItem)mMeasureCache.get(paramInteger);
      return paramInteger;
    }
    catch (Exception paramInteger)
    {
      for (;;)
      {
        DittoLog.e("DITTO_UI", "", paramInteger);
        paramInteger = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ditto.area.MeasureCacheable
 * JD-Core Version:    0.7.0.1
 */