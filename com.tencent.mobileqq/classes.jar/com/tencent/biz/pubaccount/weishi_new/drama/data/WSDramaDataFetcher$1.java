package com.tencent.biz.pubaccount.weishi_new.drama.data;

import UserGrowth.stGetSimpleRecommendDramaRsp;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;

class WSDramaDataFetcher$1
  extends ServiceCallback<stGetSimpleRecommendDramaRsp, WSDramaDataFetcher.ResponseModel>
{
  WSDramaDataFetcher$1(WSDramaDataFetcher paramWSDramaDataFetcher, IFetchDataRspListener paramIFetchDataRspListener, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected WSDramaDataFetcher.ResponseModel a(WSRequest<stGetSimpleRecommendDramaRsp> paramWSRequest, stGetSimpleRecommendDramaRsp paramstGetSimpleRecommendDramaRsp, RspHeaderBean paramRspHeaderBean)
  {
    return WSDramaDataFetcher.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaDataFetcher, paramWSRequest, paramstGetSimpleRecommendDramaRsp);
  }
  
  protected void a(WSDramaDataFetcher.ResponseModel paramResponseModel)
  {
    super.a(paramResponseModel);
    WSDramaDataFetcher.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaDataFetcher, paramResponseModel, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener);
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    super.b(paramWSServiceErrorInfo);
    WSDramaDataFetcher.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaDataFetcher, this.jdField_a_of_type_Boolean, this.b, paramWSServiceErrorInfo, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaDataFetcher.1
 * JD-Core Version:    0.7.0.1
 */