package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stDramaFeed;
import com.tencent.biz.pubaccount.weishi_new.data.IDataFetcher;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public abstract class WSAbsDramaFeedsFetcher
  implements IDataFetcher<WSDramaFeedsParams, stDramaFeed>
{
  @Nullable
  protected ArrayList<stDramaFeed> a(WSDramaFeedsParams paramWSDramaFeedsParams, int paramInt1, int paramInt2, IFetchDataRspListener<stDramaFeed> paramIFetchDataRspListener)
  {
    ArrayList localArrayList = new ArrayList();
    Map localMap = paramWSDramaFeedsParams.a();
    while (paramInt1 <= paramInt2)
    {
      stDramaFeed localstDramaFeed = (stDramaFeed)localMap.get(Integer.valueOf(paramInt1));
      if (localstDramaFeed == null)
      {
        a(paramWSDramaFeedsParams, paramIFetchDataRspListener);
        return null;
      }
      localArrayList.add(localstDramaFeed);
      paramInt1 += 1;
    }
    return localArrayList;
  }
  
  protected void a(WSDramaFeedsParams paramWSDramaFeedsParams, IFetchDataRspListener<stDramaFeed> paramIFetchDataRspListener)
  {
    WSLog.a("WSAbsDramaFeedsFetcherLog-nel-log", "[WSAbsDramaFeedsFetcher.java][fetchFeedsFromServer]");
    new WSDramaEpisodeDataFetcher().a(paramWSDramaFeedsParams, paramIFetchDataRspListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSAbsDramaFeedsFetcher
 * JD-Core Version:    0.7.0.1
 */