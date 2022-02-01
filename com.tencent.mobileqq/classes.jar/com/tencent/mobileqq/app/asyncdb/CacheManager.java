package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.app.asyncdb.cache.TroopStatisticsCache;

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
    switch (paramInt)
    {
    default: 
      return null;
    case 2: 
      return new RoamDateCache(this.a, this.dbDelayManager);
    }
    return new TroopStatisticsCache(this.a, this.dbDelayManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.CacheManager
 * JD-Core Version:    0.7.0.1
 */