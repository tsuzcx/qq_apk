package com.nostra13.universalimageloader.utils;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class MemoryCacheUtils
{
  private static final String URI_AND_SIZE_SEPARATOR = "_";
  private static final String WIDTH_AND_HEIGHT_SEPARATOR = "x";
  
  public static Comparator<String> createFuzzyKeyComparator()
  {
    return new MemoryCacheUtils.1();
  }
  
  public static List<String> findCacheKeysForImageUri(String paramString, MemoryCache paramMemoryCache)
  {
    ArrayList localArrayList = new ArrayList();
    paramMemoryCache = paramMemoryCache.keys().iterator();
    while (paramMemoryCache.hasNext())
    {
      String str = (String)paramMemoryCache.next();
      if (str.startsWith(paramString)) {
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
  
  public static List<Bitmap> findCachedBitmapsForImageUri(String paramString, MemoryCache paramMemoryCache)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMemoryCache.keys().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.startsWith(paramString)) {
        localArrayList.add(paramMemoryCache.get(str));
      }
    }
    return localArrayList;
  }
  
  public static String generateKey(String paramString, ImageSize paramImageSize)
  {
    return paramString + "_" + paramImageSize.getWidth() + "x" + paramImageSize.getHeight();
  }
  
  public static void removeFromCache(String paramString, MemoryCache paramMemoryCache)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMemoryCache.keys().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.startsWith(paramString)) {
        localArrayList.add(str);
      }
    }
    paramString = localArrayList.iterator();
    while (paramString.hasNext()) {
      paramMemoryCache.remove((String)paramString.next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.MemoryCacheUtils
 * JD-Core Version:    0.7.0.1
 */