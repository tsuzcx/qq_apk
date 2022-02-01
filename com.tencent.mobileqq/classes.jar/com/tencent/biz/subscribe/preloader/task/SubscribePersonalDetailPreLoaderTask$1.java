package com.tencent.biz.subscribe.preloader.task;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;

class SubscribePersonalDetailPreLoaderTask$1
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetMainPageRsp>
{
  SubscribePersonalDetailPreLoaderTask$1(SubscribePersonalDetailPreLoaderTask paramSubscribePersonalDetailPreLoaderTask, OnPreLoadListener paramOnPreLoadListener) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEngineeringPreloadInterOnPreLoadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqEngineeringPreloadInterOnPreLoadListener.onLoaded(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramStGetMainPageRsp });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.preloader.task.SubscribePersonalDetailPreLoaderTask.1
 * JD-Core Version:    0.7.0.1
 */