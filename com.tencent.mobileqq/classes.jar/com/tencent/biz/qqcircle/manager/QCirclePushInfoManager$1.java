package com.tencent.biz.qqcircle.manager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call.OnRspCallBack;
import feedcloud.FeedCloudMeta.StFeed;

class QCirclePushInfoManager$1
  implements Call.OnRspCallBack
{
  QCirclePushInfoManager$1(QCirclePushInfoManager paramQCirclePushInfoManager, FeedCloudMeta.StFeed paramStFeed) {}
  
  @SuppressLint({"DefaultLocale"})
  public void a(boolean paramBoolean, long paramLong, String paramString, Object paramObject1, Object paramObject2, Bundle paramBundle)
  {
    if (paramObject2 != null)
    {
      paramObject1 = this.a;
      if (paramObject1 == null) {
        return;
      }
      paramObject1 = paramObject1.id.get();
      if ((paramBoolean) && (paramLong == 0L))
      {
        QLog.d("QCirclePushTimesManager", 1, String.format("DoPush -> undoPush success! feedId = %s", new Object[] { paramObject1 }));
        QCircleToast.a(QCircleToast.d, 2131895938, 1);
        QCirclePushInfoManager.a().c(this.a.id.get());
        paramString = new QCircleFeedEvent(paramObject1, 7);
        paramString.setTargetPage(9);
        SimpleEventBus.getInstance().dispatchEvent(paramString);
        return;
      }
      QLog.d("QCirclePushTimesManager", 1, String.format("DoPush -> undoPush failed! feedId = %s , retCode = %d , errMsg = %s", new Object[] { paramObject1, Long.valueOf(paramLong), paramString }));
      QCircleToast.a(QCircleToast.c, 2131895936, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCirclePushInfoManager.1
 * JD-Core Version:    0.7.0.1
 */