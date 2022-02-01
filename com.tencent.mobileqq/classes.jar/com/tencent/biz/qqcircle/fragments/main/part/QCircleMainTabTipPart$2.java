package com.tencent.biz.qqcircle.fragments.main.part;

import android.os.Handler;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import qqcircle.QQCircleSwitch.GetCirclePopupSwitchRsp;

class QCircleMainTabTipPart$2
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.GetCirclePopupSwitchRsp>
{
  QCircleMainTabTipPart$2(QCircleMainTabTipPart paramQCircleMainTabTipPart) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.GetCirclePopupSwitchRsp paramGetCirclePopupSwitchRsp)
  {
    this.a.G().post(new QCircleMainTabTipPart.2.1(this, paramGetCirclePopupSwitchRsp, paramBaseRequest, paramBoolean, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.part.QCircleMainTabTipPart.2
 * JD-Core Version:    0.7.0.1
 */