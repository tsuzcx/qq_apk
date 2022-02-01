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
  private final WSDramaDataModule jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaDataModule = new WSDramaDataModule();
  private WSDramaItemData jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaItemData;
  private WSPlayerParam jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
  
  public static WSDramaDataManager a()
  {
    return WSDramaDataManager.SingletonHolder.a();
  }
  
  public WSDramaItemData a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaItemData;
  }
  
  public WSPlayerParam a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = null;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaItemData = null;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaDataModule.a();
  }
  
  public void a(WSDramaFeedsParams paramWSDramaFeedsParams, IFetchDataListener<stDramaFeed> paramIFetchDataListener)
  {
    paramWSDramaFeedsParams.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaDataModule.a(paramWSDramaFeedsParams.a()));
    if (paramWSDramaFeedsParams.d()) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaDataModule.a(paramWSDramaFeedsParams.a(), paramWSDramaFeedsParams.a());
    }
    WSDramaFeesFetcherFactory.a(paramWSDramaFeedsParams.b()).a(paramWSDramaFeedsParams, new WSDramaDataManager.3(this, paramWSDramaFeedsParams, paramIFetchDataListener));
  }
  
  public void a(WSDramaItemData paramWSDramaItemData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaItemData = paramWSDramaItemData;
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = paramWSPlayerParam;
  }
  
  public void a(String paramString, IFetchDataRspListener<WSEpisodeItemData> paramIFetchDataRspListener)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaDataModule.a(paramString).size() > 0)
    {
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaDataModule.a(paramString);
      if (paramIFetchDataRspListener != null) {
        paramIFetchDataRspListener.a(paramString.a(), false, false, paramString.a());
      }
      return;
    }
    new WSAllEpisodeIdsFetcher().a(new WSEpisodeParams(paramString), new WSDramaDataManager.2(this, paramString, paramIFetchDataRspListener));
  }
  
  public void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, IFetchDataRspListener<WSDramaItemData> paramIFetchDataRspListener)
  {
    new WSDramaDataFetcher().a(new WSDramaParams(paramBoolean1, paramBoolean2, paramString1), new WSDramaDataManager.1(this, paramIFetchDataRspListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaDataManager
 * JD-Core Version:    0.7.0.1
 */