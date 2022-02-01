package com.tencent.biz.richframework.network.cache;

import xvv;

public class DiskCache
  extends LruCache
{
  private final String TAG = DiskCache.class.getName();
  
  public DiskCache(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  protected String getCacheTag()
  {
    xvv.b(this.TAG, "Get cache tag[Disk]: cache");
    return "protocal_cache";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.cache.DiskCache
 * JD-Core Version:    0.7.0.1
 */