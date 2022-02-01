package com.tencent.biz.qqcircle.flutter;

import android.os.Bundle;
import com.qflutter.qqcircle.TencentQQCirclePlugin;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.event.QCircleFlutterUpdateFuelEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call.OnRspCallBack;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoPushReq;
import feedcloud.FeedCloudWrite.StDoPushRsp;
import java.util.HashMap;
import java.util.Map;

final class QQCircleMethodMine$5
  implements Call.OnRspCallBack
{
  QQCircleMethodMine$5(FeedCloudMeta.StFeed paramStFeed, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, Object paramObject1, Object paramObject2, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramString = (QCircleDoRecommendRequest)paramObject1;
      if ((paramString.getReq() != null) && (this.a != null) && (paramString.getReq().feed.id.get().equals(this.a.id.get())))
      {
        paramString = (FeedCloudWrite.StDoPushRsp)paramObject2;
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFlutterUpdateFuelEvent(HostDataTransUtils.getAccount(), paramString.myFuel.get()));
        return;
      }
      QLog.d("QQCircleMethodMine", 1, "unExceptOnReceive");
      return;
    }
    paramString = new HashMap();
    paramString.put("feedId", this.a.id.get());
    paramString.put("hasClickCount", Integer.valueOf(QQCircleMethodMine.access$600() + this.b));
    paramString.put("totalClickCount", Integer.valueOf(QQCircleMethodMine.access$700() + this.b));
    paramString.put("eventType", "pushFeed");
    TencentQQCirclePlugin.sendEvent("tencent_qqcircle/dataChange", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QQCircleMethodMine.5
 * JD-Core Version:    0.7.0.1
 */