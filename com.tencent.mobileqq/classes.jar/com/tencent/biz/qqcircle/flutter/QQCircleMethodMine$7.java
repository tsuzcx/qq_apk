package com.tencent.biz.qqcircle.flutter;

import com.qflutter.qqcircle.TencentQQCirclePlugin;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import feedcloud.FeedCloudWrite.StDoFollowRsp;
import java.util.HashMap;
import java.util.Map;

final class QQCircleMethodMine$7
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoFollowRsp>
{
  QQCircleMethodMine$7(String paramString, int paramInt) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("[onReceive] isSuccess=");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append(", retCode=");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append(", errMsg=");
    paramBaseRequest.append(paramString);
    paramBaseRequest.append(", uin=");
    paramBaseRequest.append(this.a);
    QLog.d("QQCircleMethodMine", 1, paramBaseRequest.toString());
    if ((paramBoolean) && (0L == paramLong))
    {
      paramBaseRequest = new HashMap();
      paramBaseRequest.put("userId", this.a);
      paramBaseRequest.put("followState", Integer.valueOf(this.b));
      TencentQQCirclePlugin.sendEvent("tencent_qqcircle/follow", paramBaseRequest);
      QCircleFollowManager.getInstance().setUinFollowed(this.a, this.b);
      paramBaseRequest = new QCircleFollowUpdateEvent(this.b, this.a);
      SimpleEventBus.getInstance().dispatchEvent(paramBaseRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QQCircleMethodMine.7
 * JD-Core Version:    0.7.0.1
 */