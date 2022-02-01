package com.tencent.biz.pubaccount.readinjoyAd.ad.manager;

import java.util.Comparator;

class AdExposeFreshManager$2
  implements Comparator<AdExposeFreshManager.CacheAd>
{
  AdExposeFreshManager$2(AdExposeFreshManager paramAdExposeFreshManager) {}
  
  public int a(AdExposeFreshManager.CacheAd paramCacheAd1, AdExposeFreshManager.CacheAd paramCacheAd2)
  {
    try
    {
      double d1 = paramCacheAd2.a;
      double d2 = paramCacheAd1.a;
      return (int)(d1 - d2);
    }
    catch (Throwable paramCacheAd1)
    {
      AdExposeFreshManager.a("removeInvalidAd", paramCacheAd1.getMessage());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager.2
 * JD-Core Version:    0.7.0.1
 */