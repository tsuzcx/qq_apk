package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleEnvHub.ExposeTipsRsp;

final class QCircleTipsUtil$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleEnvHub.ExposeTipsRsp>
{
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleEnvHub.ExposeTipsRsp paramExposeTipsRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("getTipsConfigRequest isSuccess = ");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append(", retCode = ");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append("errMsg = ");
    paramBaseRequest.append(paramString);
    QLog.d("QCircleTipsUtil", 1, paramBaseRequest.toString());
    if ((paramBoolean) && (paramLong == 0L)) {
      QCircleTipsUtil.a(paramExposeTipsRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleTipsUtil.1
 * JD-Core Version:    0.7.0.1
 */