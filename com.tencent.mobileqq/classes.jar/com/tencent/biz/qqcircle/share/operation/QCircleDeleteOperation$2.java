package com.tencent.biz.qqcircle.share.operation;

import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWrite.StDelFeedRsp;

class QCircleDeleteOperation$2
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDelFeedRsp>
{
  QCircleDeleteOperation$2(QCircleDeleteOperation paramQCircleDeleteOperation, String paramString) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      QLog.d("QCircleDeleteShare", 1, "deleteFeed  success");
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(this.a, 3));
      return;
    }
    QLog.e("QCircleDeleteShare", 1, "deleteFeed  error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.operation.QCircleDeleteOperation.2
 * JD-Core Version:    0.7.0.1
 */