package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stGetDramaFeedsRsp;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaEpisodeParams;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;

class WSDramaEpisodeDataFetcher$1
  extends ServiceCallback<stGetDramaFeedsRsp, WSDramaEpisodeDataFetcher.ResponseModel>
{
  WSDramaEpisodeDataFetcher$1(WSDramaEpisodeDataFetcher paramWSDramaEpisodeDataFetcher, WSDramaEpisodeParams paramWSDramaEpisodeParams, IFetchDataRspListener paramIFetchDataRspListener) {}
  
  protected WSDramaEpisodeDataFetcher.ResponseModel a(WSRequest<stGetDramaFeedsRsp> paramWSRequest, stGetDramaFeedsRsp paramstGetDramaFeedsRsp, RspHeaderBean paramRspHeaderBean)
  {
    return WSDramaEpisodeDataFetcher.a(this.c, paramWSRequest, paramstGetDramaFeedsRsp, this.a);
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void a(WSDramaEpisodeDataFetcher.ResponseModel paramResponseModel)
  {
    WSDramaEpisodeDataFetcher.a(this.c, paramResponseModel, this.b);
  }
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    WSDramaEpisodeDataFetcher.a(this.c, paramWSServiceErrorInfo, this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSDramaEpisodeDataFetcher.1
 * JD-Core Version:    0.7.0.1
 */