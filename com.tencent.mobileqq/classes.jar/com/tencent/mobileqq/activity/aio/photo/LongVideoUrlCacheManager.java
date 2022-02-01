package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class LongVideoUrlCacheManager
{
  private static int b = 900000;
  public ConcurrentHashMap<Long, LongVideoUrlCacheManager.UrlsCacheBean> a = new ConcurrentHashMap();
  
  public static final LongVideoUrlCacheManager a()
  {
    return LongVideoUrlCacheManager.LazyStyle.a();
  }
  
  public LongVideoUrlCacheManager.UrlsCacheBean a(long paramLong)
  {
    if (this.a.containsKey(Long.valueOf(paramLong))) {
      return (LongVideoUrlCacheManager.UrlsCacheBean)this.a.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void a(long paramLong1, String[] paramArrayOfString, long paramLong2, MessageForShortVideo paramMessageForShortVideo, int paramInt, String paramString)
  {
    this.a.put(Long.valueOf(paramLong1), new LongVideoUrlCacheManager.UrlsCacheBean(this, paramArrayOfString, paramLong2, paramMessageForShortVideo, paramInt, paramString));
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(" LongVideoUrlCacheManager", 2, "LongVideoUrlCacheManager,clearCache");
    }
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.LongVideoUrlCacheManager
 * JD-Core Version:    0.7.0.1
 */