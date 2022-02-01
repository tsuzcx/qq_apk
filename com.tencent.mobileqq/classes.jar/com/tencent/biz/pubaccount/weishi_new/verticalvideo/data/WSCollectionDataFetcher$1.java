package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stGetCollectionRsp;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;

class WSCollectionDataFetcher$1
  extends ServiceCallback<stGetCollectionRsp, WSCollectionDataFetcher.ResponseModel>
{
  WSCollectionDataFetcher$1(WSCollectionDataFetcher paramWSCollectionDataFetcher, WSCollectionRequestParams paramWSCollectionRequestParams, IFetchDataRspListener paramIFetchDataRspListener) {}
  
  protected WSCollectionDataFetcher.ResponseModel a(WSRequest<stGetCollectionRsp> paramWSRequest, stGetCollectionRsp paramstGetCollectionRsp, RspHeaderBean paramRspHeaderBean)
  {
    return WSCollectionDataFetcher.a(this.c, paramstGetCollectionRsp, this.a);
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void a(WSCollectionDataFetcher.ResponseModel paramResponseModel)
  {
    super.a(paramResponseModel);
    if (this.b != null)
    {
      int i = WSCollectionDataFetcher.a(this.c, paramResponseModel.b, paramResponseModel.c);
      this.b.a(paramResponseModel.a, false, paramResponseModel.b, Integer.valueOf(i));
    }
  }
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    super.b(paramWSServiceErrorInfo);
    IFetchDataRspListener localIFetchDataRspListener = this.b;
    if (localIFetchDataRspListener != null) {
      localIFetchDataRspListener.a(paramWSServiceErrorInfo.a(), paramWSServiceErrorInfo.b(), this.a.a, this.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSCollectionDataFetcher.1
 * JD-Core Version:    0.7.0.1
 */