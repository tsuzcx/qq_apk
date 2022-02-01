package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.events.QCircleGoToCardSettingEvent;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import qqcircle.QQCircleProfile.SetUserSwitchRsp;

class QCirclePrivacySettingContentPart$1$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleProfile.SetUserSwitchRsp>
{
  QCirclePrivacySettingContentPart$1$1(QCirclePrivacySettingContentPart.1 param1, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleProfile.SetUserSwitchRsp paramSetUserSwitchRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleGoToCardSettingEvent(this.a));
      return;
    }
    QCircleToastUtil.a(paramLong, paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePrivacySettingContentPart.1.1
 * JD-Core Version:    0.7.0.1
 */