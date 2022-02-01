package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stDramaFeed;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import java.util.ArrayList;

public class WSDramaFeedsUpFetcher
  extends WSAbsDramaFeedsFetcher
{
  public boolean a(WSDramaFeedsParams paramWSDramaFeedsParams, IFetchDataRspListener<stDramaFeed> paramIFetchDataRspListener)
  {
    int i = paramWSDramaFeedsParams.a();
    int j = i - 4;
    ArrayList localArrayList = a(paramWSDramaFeedsParams, Math.max(j, 1), i, paramIFetchDataRspListener);
    if (localArrayList != null)
    {
      paramWSDramaFeedsParams = paramWSDramaFeedsParams.c();
      boolean bool;
      if (j <= 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramIFetchDataRspListener.a(localArrayList, false, false, WSEpisodeResultUtil.a(paramWSDramaFeedsParams, false, false, bool));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaFeedsUpFetcher
 * JD-Core Version:    0.7.0.1
 */