package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stGetFollowedDramasRsp;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;

class WSGetFollowDramaFetcher$1
  extends ServiceCallback<stGetFollowedDramasRsp, WSGetFollowDramaFetcher.ResponseModel>
{
  WSGetFollowDramaFetcher$1(WSGetFollowDramaFetcher paramWSGetFollowDramaFetcher, IFetchDataListener paramIFetchDataListener) {}
  
  protected WSGetFollowDramaFetcher.ResponseModel a(WSRequest<stGetFollowedDramasRsp> paramWSRequest, stGetFollowedDramasRsp paramstGetFollowedDramasRsp, RspHeaderBean paramRspHeaderBean)
  {
    return WSGetFollowDramaFetcher.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSGetFollowDramaFetcher, paramWSRequest, paramstGetFollowedDramasRsp);
  }
  
  protected void a(WSGetFollowDramaFetcher.ResponseModel paramResponseModel)
  {
    WSGetFollowDramaFetcher.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSGetFollowDramaFetcher, paramResponseModel, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheIFetchDataListener);
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    WSGetFollowDramaFetcher.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSGetFollowDramaFetcher, paramWSServiceErrorInfo, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheIFetchDataListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSGetFollowDramaFetcher.1
 * JD-Core Version:    0.7.0.1
 */