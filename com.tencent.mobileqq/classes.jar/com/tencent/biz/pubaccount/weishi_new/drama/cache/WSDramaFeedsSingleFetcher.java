package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stDramaFeed;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import java.util.Map;

public class WSDramaFeedsSingleFetcher
  extends WSAbsDramaFeedsFetcher
{
  private void a(WSDramaFeedsParams paramWSDramaFeedsParams, IFetchDataRspListener<stDramaFeed> paramIFetchDataRspListener, Map<Integer, stDramaFeed> paramMap, int paramInt)
  {
    if (paramMap.get(Integer.valueOf(paramInt + 1)) == null)
    {
      paramWSDramaFeedsParams.a(true);
      paramWSDramaFeedsParams.a(0);
      a(paramWSDramaFeedsParams, paramIFetchDataRspListener);
    }
  }
  
  public boolean a(WSDramaFeedsParams paramWSDramaFeedsParams, IFetchDataRspListener<stDramaFeed> paramIFetchDataRspListener)
  {
    Map localMap = paramWSDramaFeedsParams.a();
    int i = paramWSDramaFeedsParams.a();
    stDramaFeed localstDramaFeed = (stDramaFeed)localMap.get(Integer.valueOf(i));
    if (localstDramaFeed == null)
    {
      paramWSDramaFeedsParams.a(0);
      a(paramWSDramaFeedsParams, paramIFetchDataRspListener);
      return false;
    }
    WSLog.a("WSDramaFeedsSingleFetcher-nel-log", "[WSAbsDramaFeedsFetcher.java][fetchFeedsFromCache]");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localstDramaFeed);
    paramIFetchDataRspListener.a(localArrayList, false, false, null);
    a(paramWSDramaFeedsParams, paramIFetchDataRspListener, localMap, i);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaFeedsSingleFetcher
 * JD-Core Version:    0.7.0.1
 */