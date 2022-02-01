package com.tencent.biz.qqcircle.debug.mocklbs;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleConfig.GetRainbowKVConfRsp;

class QCircleMockLbsPart$2
  implements VSDispatchObserver.onVSRspCallBack<QQCircleConfig.GetRainbowKVConfRsp>
{
  QCircleMockLbsPart$2(QCircleMockLbsPart paramQCircleMockLbsPart) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleConfig.GetRainbowKVConfRsp paramGetRainbowKVConfRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("GetRainbowKVConfRsp isSuccess：");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append(" errormsg:");
    paramBaseRequest.append(paramString);
    paramBaseRequest.append(" retCode:");
    paramBaseRequest.append(paramLong);
    QLog.i("QCircleMockLbsPart", 1, paramBaseRequest.toString());
    QCircleMockLbsPart.a(this.a, paramBoolean, paramGetRainbowKVConfRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.debug.mocklbs.QCircleMockLbsPart.2
 * JD-Core Version:    0.7.0.1
 */