package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;

class WSVerticalDataManager$1
  extends ServiceCallback<stSimpleGetFeedListRsp, WSVerticalDataManager.ResponseModel>
{
  WSVerticalDataManager$1(WSVerticalDataManager paramWSVerticalDataManager, boolean paramBoolean1, IFetchDataRspListener paramIFetchDataRspListener, boolean paramBoolean2, Object paramObject, long paramLong) {}
  
  protected WSVerticalDataManager.ResponseModel a(WSRequest<stSimpleGetFeedListRsp> paramWSRequest, stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, RspHeaderBean paramRspHeaderBean)
  {
    return WSVerticalDataManager.a(this.f, paramWSRequest, paramstSimpleGetFeedListRsp, paramRspHeaderBean, this.a, this.b, this.c, this.d, this.e);
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void a(WSVerticalDataManager.ResponseModel paramResponseModel)
  {
    super.a(paramResponseModel);
    WSVerticalDataManager.a(this.f, paramResponseModel, this.b);
  }
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    super.b(paramWSServiceErrorInfo);
    WSVerticalDataManager.a(this.f, this.a, this.c, paramWSServiceErrorInfo, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager.1
 * JD-Core Version:    0.7.0.1
 */