package com.tencent.biz.qqcircle.manager;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleSwitch.SetCircleSwitchRsp;

class QCircleSwitchConfigManager$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.SetCircleSwitchRsp>
{
  QCircleSwitchConfigManager$1(QCircleSwitchConfigManager paramQCircleSwitchConfigManager) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.SetCircleSwitchRsp paramSetCircleSwitchRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("onReceive success isBarrageOpen = ");
      paramBaseRequest.append(this.a.b());
      QLog.i("QCircleBarrageSwitchManager", 1, paramBaseRequest.toString());
      return;
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("onReceive setBarrageClosed error retCode = ");
    paramBaseRequest.append(paramLong);
    QLog.e("QCircleBarrageSwitchManager", 1, paramBaseRequest.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleSwitchConfigManager.1
 * JD-Core Version:    0.7.0.1
 */