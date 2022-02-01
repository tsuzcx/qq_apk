package com.tencent.biz.qqcircle.fragments.person;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleProfile.SetProfileRsp;

class QCirclePersonalBottomView$5
  implements VSDispatchObserver.onVSRspCallBack<QQCircleProfile.SetProfileRsp>
{
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleProfile.SetProfileRsp paramSetProfileRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("QCircleSetProfileRequest isSuccess:");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append(" retCode:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append(" errorMsg:");
    paramBaseRequest.append(paramString);
    QLog.d("QCirclePersonalBottomView", 1, paramBaseRequest.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView.5
 * JD-Core Version:    0.7.0.1
 */