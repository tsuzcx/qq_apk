package com.tencent.biz.richframework.network.cache;

import com.tencent.biz.richframework.delegate.impl.RFLog;

public class DiskCache
  extends LruCache
{
  private static final String TAG = "DiskCache";
  
  public DiskCache(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  protected String getCacheTag()
  {
    RFLog.d("DiskCache", RFLog.DEV, "Get cache tag[Disk]: cache");
    return "protocal_cache";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.cache.DiskCache
 * JD-Core Version:    0.7.0.1
 */