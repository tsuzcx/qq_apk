package com.tencent.biz.qqcircle.datacenter.impl;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestSender;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.richframework.data.idata.IDataStore;
import com.tencent.richframework.data.idata.ILoadDataByReq;
import com.tencent.richframework.sender.call.BaseCall;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import java.util.ArrayList;
import java.util.Map;

public abstract class QCircleNetListProvider<E>
  implements ILoadDataByReq<QCircleBaseRequest, E, Object>, ReqInterceptor<LoadInfo, BaseSenderChain>
{
  protected abstract IDataStore<E> a();
  
  abstract void a(QCircleRequestCall paramQCircleRequestCall);
  
  public void a(LoadInfo paramLoadInfo, BaseSenderChain paramBaseSenderChain)
  {
    if (a() == null) {
      return;
    }
    if (a().d())
    {
      paramBaseSenderChain.a(true, 0L, "", paramLoadInfo, new ArrayList(a().b().values()));
      return;
    }
    paramLoadInfo = (QCircleBaseRequest)getRequest(a().e());
    if (paramLoadInfo != null)
    {
      QCircleRequestCall localQCircleRequestCall = QCircleRequestSender.a().b();
      a(localQCircleRequestCall);
      localQCircleRequestCall.a(new QCircleNetListProvider.InnerRspHandleInterceptor(this, null)).a(paramBaseSenderChain).a(paramLoadInfo).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.datacenter.impl.QCircleNetListProvider
 * JD-Core Version:    0.7.0.1
 */