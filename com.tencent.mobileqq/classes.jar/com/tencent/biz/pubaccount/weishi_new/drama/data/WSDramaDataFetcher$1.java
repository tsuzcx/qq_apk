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
    return WSDramaDataFetcher.a(this.d, paramWSRequest, paramstGetSimpleRecommendDramaRsp);
  }
  
  protected void a(WSDramaDataFetcher.ResponseModel paramResponseModel)
  {
    super.a(paramResponseModel);
    WSDramaDataFetcher.a(this.d, paramResponseModel, this.a);
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    super.b(paramWSServiceErrorInfo);
    WSDramaDataFetcher.a(this.d, this.b, this.c, paramWSServiceErrorInfo, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaDataFetcher.1
 * JD-Core Version:    0.7.0.1
 */