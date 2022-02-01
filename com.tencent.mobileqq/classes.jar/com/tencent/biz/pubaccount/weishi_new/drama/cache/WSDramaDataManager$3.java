package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stDramaFeed;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.List;
import java.util.Map;

class WSDramaDataManager$3
  implements IFetchDataRspListener<stDramaFeed>
{
  WSDramaDataManager$3(WSDramaDataManager paramWSDramaDataManager, WSDramaFeedsParams paramWSDramaFeedsParams, IFetchDataListener paramIFetchDataListener) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    IFetchDataListener localIFetchDataListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheIFetchDataListener;
    if (localIFetchDataListener != null) {
      localIFetchDataListener.a(paramInt, paramString);
    }
  }
  
  public void a(List<stDramaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    paramObject = new StringBuilder();
    paramObject.append("[WSDramaDataManager.java][getSingleEpisodeFeed] isPreloadData:");
    paramObject.append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaFeedsParams.c());
    WSLog.a("WSDramaDataManager-nel-log", paramObject.toString());
    WSDramaDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaDataManager).a(paramList, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaFeedsParams.a());
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaFeedsParams.c()) {
      return;
    }
    paramList = (stDramaFeed)WSDramaDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaDataManager).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaFeedsParams.a()).get(Integer.valueOf(Math.max(1, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaFeedsParams.a())));
    paramObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheIFetchDataListener;
    if (paramObject != null) {
      paramObject.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaDataManager.3
 * JD-Core Version:    0.7.0.1
 */