package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stGetDramaFeedsRsp;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;

class WSDramaEpisodeDataFetcher$1
  extends ServiceCallback<stGetDramaFeedsRsp, WSDramaEpisodeDataFetcher.ResponseModel>
{
  WSDramaEpisodeDataFetcher$1(WSDramaEpisodeDataFetcher paramWSDramaEpisodeDataFetcher, WSDramaFeedsParams paramWSDramaFeedsParams, IFetchDataRspListener paramIFetchDataRspListener) {}
  
  protected WSDramaEpisodeDataFetcher.ResponseModel a(WSRequest<stGetDramaFeedsRsp> paramWSRequest, stGetDramaFeedsRsp paramstGetDramaFeedsRsp, RspHeaderBean paramRspHeaderBean)
  {
    return WSDramaEpisodeDataFetcher.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaEpisodeDataFetcher, paramWSRequest, paramstGetDramaFeedsRsp, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaFeedsParams);
  }
  
  protected void a(WSDramaEpisodeDataFetcher.ResponseModel paramResponseModel)
  {
    WSDramaEpisodeDataFetcher.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaEpisodeDataFetcher, paramResponseModel, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener);
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    WSDramaEpisodeDataFetcher.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaEpisodeDataFetcher, paramWSServiceErrorInfo, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSDramaFeedsParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaEpisodeDataFetcher.1
 * JD-Core Version:    0.7.0.1
 */