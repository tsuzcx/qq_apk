package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stDramaFeed;
import com.tencent.biz.pubaccount.weishi_new.data.IDataFetcher;

public class WSDramaFeesFetcherFactory
{
  public static IDataFetcher<WSDramaFeedsParams, stDramaFeed> a(int paramInt)
  {
    if (paramInt == -1) {
      return new WSDramaFeedsSingleFetcher();
    }
    if (paramInt == 1) {
      return new WSDramaFeedsUpFetcher();
    }
    return new WSDramaFeedsDownFetcher();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaFeesFetcherFactory
 * JD-Core Version:    0.7.0.1
 */