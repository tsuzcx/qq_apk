package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stDramaFeed;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import java.util.ArrayList;

public class WSDramaFeedsDownFetcher
  extends WSAbsDramaFeedsFetcher
{
  public boolean b(WSDramaFeedsParams paramWSDramaFeedsParams, IFetchDataRspListener<stDramaFeed> paramIFetchDataRspListener)
  {
    int i = paramWSDramaFeedsParams.c();
    ArrayList localArrayList = a(paramWSDramaFeedsParams, i, i + 4, paramIFetchDataRspListener);
    if (localArrayList != null) {
      paramIFetchDataRspListener.a(localArrayList, false, false, WSEpisodeResultUtil.a(paramWSDramaFeedsParams.h(), false, true, false));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaFeedsDownFetcher
 * JD-Core Version:    0.7.0.1
 */