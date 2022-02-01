package com.tencent.biz.pubaccount.weishi_new.aiolist;

import UserGrowth.stGetAIOFeedDetailRsp;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.GetAIOFeedDetailRequest;

final class WSAioListHelper$1
  extends ServiceCallback<stGetAIOFeedDetailRsp, stGetAIOFeedDetailRsp>
{
  WSAioListHelper$1(GetAIOFeedDetailRequest paramGetAIOFeedDetailRequest) {}
  
  protected stGetAIOFeedDetailRsp a(WSRequest<stGetAIOFeedDetailRsp> paramWSRequest, stGetAIOFeedDetailRsp paramstGetAIOFeedDetailRsp, RspHeaderBean paramRspHeaderBean)
  {
    return paramstGetAIOFeedDetailRsp;
  }
  
  protected void a(stGetAIOFeedDetailRsp paramstGetAIOFeedDetailRsp)
  {
    WSAioListHelper.a(this.a, paramstGetAIOFeedDetailRsp);
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    WsBeaconReportPresenter.a().a(this.a, paramWSServiceErrorInfo.a(), paramWSServiceErrorInfo.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.aiolist.WSAioListHelper.1
 * JD-Core Version:    0.7.0.1
 */