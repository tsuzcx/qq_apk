package com.qflutter.qqface.cache;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BitmapCache
{
  public static final int CACHE_FORMAT_BITMAP = 0;
  public static final int CACHE_FORMAT_BYTES = 1;
  public static final int CACHE_FORMAT_BYTE_BUFFER = 3;
  private ConcurrentHashMap<String, BitmapRef> mCache = new ConcurrentHashMap();
  
  public static String getKey(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public void addCache(String paramString, Bitmap paramBitmap)
  {
    String str = getKey(paramString, 0);
    BitmapRef localBitmapRef = (BitmapRef)this.mCache.get(str);
    paramString = localBitmapRef;
    if (localBitmapRef == null)
    {
      paramString = new BitmapRef(paramBitmap);
      this.mCache.put(str, paramString);
    }
    paramString.incRef();
  }
  
  public void addCache(String paramString, ByteBuffer paramByteBuffer)
  {
    String str = getKey(paramString, 3);
    BitmapRef localBitmapRef = (BitmapRef)this.mCache.get(str);
    paramString = localBitmapRef;
    if (localBitmapRef == null)
    {
      paramString = new BitmapRef(paramByteBuffer);
      this.mCache.put(str, paramString);
    }
    paramString.incRef();
  }
  
  public void addCache(String paramString, byte[] paramArrayOfByte)
  {
    String str = getKey(paramString, 1);
    BitmapRef localBitmapRef = (BitmapRef)this.mCache.get(str);
    paramString = localBitmapRef;
    if (localBitmapRef == null)
    {
      paramString = new BitmapRef(paramArrayOfByte);
      this.mCache.put(str, paramString);
    }
    paramString.incRef();
  }
  
  public void clearCache()
  {
    Iterator localIterator = this.mCache.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      BitmapRef localBitmapRef = (BitmapRef)this.mCache.get(str);
      if (localBitmapRef != null) {
        localBitmapRef.release();
      }
      this.mCache.remove(str);
    }
  }
  
  public void removeCache(String paramString, int paramInt)
  {
    paramString = getKey(paramString, paramInt);
    BitmapRef localBitmapRef = (BitmapRef)this.mCache.get(paramString);
    if (localBitmapRef != null)
    {
      localBitmapRef.decRef();
      if (localBitmapRef.canRelease())
      {
        localBitmapRef.release();
        this.mCache.remove(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qqface.cache.BitmapCache
 * JD-Core Version:    0.7.0.1
 */