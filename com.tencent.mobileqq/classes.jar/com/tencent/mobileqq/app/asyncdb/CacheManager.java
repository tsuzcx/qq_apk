package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.pic.api.IPicFactory;
import com.tencent.mobileqq.qroute.QRoute;

public class CacheManager
  extends BaseCacheManager
{
  private QQAppInterface a;
  
  public CacheManager(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  protected BaseCache createCacheByName(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3) {
        return null;
      }
      return ((IPicFactory)QRoute.api(IPicFactory.class)).getCache(this.a, this.dbDelayManager);
    }
    return new RoamDateCache(this.a, this.dbDelayManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.CacheManager
 * JD-Core Version:    0.7.0.1
 */