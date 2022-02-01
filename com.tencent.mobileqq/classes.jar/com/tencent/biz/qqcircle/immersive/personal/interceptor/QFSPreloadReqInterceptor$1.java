package com.tencent.biz.qqcircle.immersive.personal.interceptor;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;

class QFSPreloadReqInterceptor$1
  extends BasePreLoadTask<Object>
{
  QFSPreloadReqInterceptor$1(QFSPreloadReqInterceptor paramQFSPreloadReqInterceptor, QCircleBaseRequest paramQCircleBaseRequest) {}
  
  public void onRemove()
  {
    String str = this.b.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRemove key = ");
    localStringBuilder.append(QFSPreloadReqInterceptor.a(this.b));
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  public void startLoadData(OnPreLoadListener<Object> paramOnPreLoadListener)
  {
    VSNetworkHelper.getInstance().sendRequest(RFApplication.getApplication(), this.a, new QFSPreloadReqInterceptor.1.1(this, paramOnPreLoadListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSPreloadReqInterceptor.1
 * JD-Core Version:    0.7.0.1
 */