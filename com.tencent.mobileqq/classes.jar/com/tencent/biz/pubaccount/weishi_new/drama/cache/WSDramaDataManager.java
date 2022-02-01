package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stDramaFeed;
import com.tencent.biz.pubaccount.weishi_new.data.IDataFetcher;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSAllEpisodeIdsFetcher;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaDataFetcher;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaParams;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSEpisodeParams;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSDramaEpisodeEntity;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeItemData;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import java.util.List;

public class WSDramaDataManager
{
  private final WSDramaDataModule a = new WSDramaDataModule();
  private WSPlayerParam b;
  private WSDramaItemData c;
  
  public static WSDramaDataManager a()
  {
    return WSDramaDataManager.SingletonHolder.a();
  }
  
  public void a(WSDramaFeedsParams paramWSDramaFeedsParams, IFetchDataListener<stDramaFeed> paramIFetchDataListener)
  {
    paramWSDramaFeedsParams.a(this.a.c(paramWSDramaFeedsParams.d()));
    if (paramWSDramaFeedsParams.j()) {
      this.a.a(paramWSDramaFeedsParams.d(), paramWSDramaFeedsParams.c());
    }
    WSDramaFeesFetcherFactory.a(paramWSDramaFeedsParams.g()).a(paramWSDramaFeedsParams, new WSDramaDataManager.3(this, paramWSDramaFeedsParams, paramIFetchDataListener));
  }
  
  public void a(WSDramaItemData paramWSDramaItemData)
  {
    this.c = paramWSDramaItemData;
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    this.b = paramWSPlayerParam;
  }
  
  public void a(String paramString, IFetchDataRspListener<WSEpisodeItemData> paramIFetchDataRspListener)
  {
    if (this.a.b(paramString).size() > 0)
    {
      paramString = this.a.d(paramString);
      if (paramIFetchDataRspListener != null) {
        paramIFetchDataRspListener.a(paramString.a(), false, false, paramString.b());
      }
      return;
    }
    new WSAllEpisodeIdsFetcher().a(new WSEpisodeParams(paramString), new WSDramaDataManager.2(this, paramString, paramIFetchDataRspListener));
  }
  
  public void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, IFetchDataRspListener<WSDramaItemData> paramIFetchDataRspListener)
  {
    new WSDramaDataFetcher().a(new WSDramaParams(paramBoolean1, paramBoolean2, paramString1), new WSDramaDataManager.1(this, paramIFetchDataRspListener));
  }
  
  public WSPlayerParam b()
  {
    return this.b;
  }
  
  public WSDramaItemData c()
  {
    return this.c;
  }
  
  public void d()
  {
    this.b = null;
    this.c = null;
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaDataManager
 * JD-Core Version:    0.7.0.1
 */