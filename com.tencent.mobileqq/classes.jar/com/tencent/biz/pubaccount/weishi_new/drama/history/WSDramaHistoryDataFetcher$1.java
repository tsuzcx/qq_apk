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
    return WSDramaHistoryDataFetcher.a(this.d, paramstGetHistoryDramaRsp);
  }
  
  protected void a(WSDramaHistoryDataFetcher.ResponseModel paramResponseModel)
  {
    super.a(paramResponseModel);
    WSDramaHistoryDataFetcher.a(this.d, this.a, this.b, paramResponseModel, this.c);
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    super.b(paramWSServiceErrorInfo);
    WSDramaHistoryDataFetcher.a(this.d, this.a, this.b, paramWSServiceErrorInfo, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.history.WSDramaHistoryDataFetcher.1
 * JD-Core Version:    0.7.0.1
 */