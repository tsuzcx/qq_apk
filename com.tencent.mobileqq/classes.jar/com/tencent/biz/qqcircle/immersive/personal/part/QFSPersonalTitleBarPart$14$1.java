package com.tencent.biz.qqcircle.immersive.personal.part;

import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qcircle.api.event.QCircleAddblackUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleRight.SetCircleUnCareRsp;

class QFSPersonalTitleBarPart$14$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleRight.SetCircleUnCareRsp>
{
  QFSPersonalTitleBarPart$14$1(QFSPersonalTitleBarPart.14 param14) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleRight.SetCircleUnCareRsp paramSetCircleUnCareRsp)
  {
    if (QLog.isColorLevel())
    {
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("black person: isSuccess");
      paramBaseRequest.append(paramBoolean);
      paramBaseRequest.append("retCode:");
      paramBaseRequest.append(paramLong);
      paramBaseRequest.append("    errMsg:");
      paramBaseRequest.append(paramString);
      QLog.d("QFSPersonalTitleBarPart", 1, paramBaseRequest.toString());
    }
    if ((paramBoolean) && (paramLong == 0L))
    {
      QCircleToast.a(QCircleToast.d, 2131895623, 0);
      this.a.a.a(QFSPersonalTitleBarPart.g(this.a.a).c);
      SimpleEventBus.getInstance().dispatchEvent(new QCircleAddblackUpdateEvent(1, QFSPersonalTitleBarPart.g(this.a.a).c));
      QFSPersonalTitleBarPart.a(this.a.a.g(), QFSPersonalTitleBarPart.g(this.a.a).c, 0, 1);
      return;
    }
    QCircleToast.a(QCircleToast.c, 2131895815, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTitleBarPart.14.1
 * JD-Core Version:    0.7.0.1
 */