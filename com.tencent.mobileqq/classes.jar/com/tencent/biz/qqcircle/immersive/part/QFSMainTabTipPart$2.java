package com.tencent.biz.qqcircle.immersive.part;

import android.os.Handler;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import qqcircle.QQCircleSwitch.GetCirclePopupSwitchRsp;

class QFSMainTabTipPart$2
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.GetCirclePopupSwitchRsp>
{
  QFSMainTabTipPart$2(QFSMainTabTipPart paramQFSMainTabTipPart) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.GetCirclePopupSwitchRsp paramGetCirclePopupSwitchRsp)
  {
    this.a.G().post(new QFSMainTabTipPart.2.1(this, paramGetCirclePopupSwitchRsp, paramBaseRequest, paramBoolean, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSMainTabTipPart.2
 * JD-Core Version:    0.7.0.1
 */