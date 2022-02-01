package com.tencent.biz.pubaccount.readinjoyAd.ad.manager;

import java.util.Comparator;
import java.util.Map.Entry;

class AdReqFreshManager$1
  implements Comparator<Map.Entry<Long, Long>>
{
  AdReqFreshManager$1(AdReqFreshManager paramAdReqFreshManager) {}
  
  public int a(Map.Entry<Long, Long> paramEntry1, Map.Entry<Long, Long> paramEntry2)
  {
    return ((Long)paramEntry1.getValue()).compareTo((Long)paramEntry2.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager.1
 * JD-Core Version:    0.7.0.1
 */