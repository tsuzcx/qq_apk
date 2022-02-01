package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.events.QCircleSyncToTroopSettingEvent;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import qqcircle.QQCircleProfile.SetUserSwitchRsp;

class QCirclePrivacySettingContentPart$2$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleProfile.SetUserSwitchRsp>
{
  QCirclePrivacySettingContentPart$2$1(QCirclePrivacySettingContentPart.2 param2, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleProfile.SetUserSwitchRsp paramSetUserSwitchRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleSyncToTroopSettingEvent(this.a));
      return;
    }
    QCircleToastUtil.a(paramLong, paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePrivacySettingContentPart.2.1
 * JD-Core Version:    0.7.0.1
 */