package com.tencent.biz.pubaccount.weishi_new.drama.history;

import UserGrowth.stGetHistoryDramaRsp;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;

class WSDramaHistoryDataFetcher$1
  extends ServiceCallback<stGetHistoryDramaRsp, WSDramaHistoryDataFetcher.ResponseModel>
{
  WSDramaHistoryDataFetcher$1(WSDramaHistoryDataFetcher paramWSDramaHistoryDataFetcher, boolean paramBoolean1, boolean paramBoolean2, IFetchDataRspListener paramIFetchDataRspListener) {}
  
  protected WSDramaHistoryDataFetcher.ResponseModel a(WSRequest<stGetHistoryDramaRsp> paramWSRequest, stGetHistoryDramaRsp paramstGetHistoryDramaRsp, RspHeaderBean paramRspHeaderBean)
  {
    return WSDramaHistoryDataFetcher.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryDataFetcher, paramstGetHistoryDramaRsp);
  }
  
  protected void a(WSDramaHistoryDataFetcher.ResponseModel paramResponseModel)
  {
    super.a(paramResponseModel);
    WSDramaHistoryDataFetcher.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryDataFetcher, this.jdField_a_of_type_Boolean, this.b, paramResponseModel, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener);
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    super.b(paramWSServiceErrorInfo);
    WSDramaHistoryDataFetcher.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryDataFetcher, this.jdField_a_of_type_Boolean, this.b, paramWSServiceErrorInfo, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.history.WSDramaHistoryDataFetcher.1
 * JD-Core Version:    0.7.0.1
 */