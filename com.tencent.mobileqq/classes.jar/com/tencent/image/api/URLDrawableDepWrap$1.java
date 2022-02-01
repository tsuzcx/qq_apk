package com.tencent.image.api;

import android.util.LruCache;

class URLDrawableDepWrap$1
  implements ICache
{
  LruCache<String, Object> mLruCache = new URLDrawableDepWrap.1.1(this, 104857600);
  
  URLDrawableDepWrap$1(URLDrawableDepWrap paramURLDrawableDepWrap) {}
  
  public void evictAll()
  {
    this.mLruCache.evictAll();
  }
  
  public Object get(String paramString)
  {
    return this.mLruCache.get(paramString);
  }
  
  public byte getNormalPriority()
  {
    return 0;
  }
  
  public Object put(String paramString, Object paramObject, byte paramByte)
  {
    return null;
  }
  
  public void remove(String paramString)
  {
    this.mLruCache.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.api.URLDrawableDepWrap.1
 * JD-Core Version:    0.7.0.1
 */