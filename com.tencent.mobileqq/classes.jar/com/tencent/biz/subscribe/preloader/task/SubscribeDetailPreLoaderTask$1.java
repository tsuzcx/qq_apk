package com.tencent.biz.subscribe.preloader.task;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;

class SubscribeDetailPreLoaderTask$1
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetFeedDetailRsp>
{
  SubscribeDetailPreLoaderTask$1(SubscribeDetailPreLoaderTask paramSubscribeDetailPreLoaderTask, OnPreLoadListener paramOnPreLoadListener) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    paramBaseRequest = this.a;
    if (paramBaseRequest != null) {
      paramBaseRequest.onLoaded(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramStGetFeedDetailRsp });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.preloader.task.SubscribeDetailPreLoaderTask.1
 * JD-Core Version:    0.7.0.1
 */