package com.tencent.biz.qqcircle.datacenter;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qcircle.api.event.QCircleFeedOptEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.mobileqq.winkpublish.event.PublishUploadTaskResultEvent;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;

class QCircleSimpleEventFeedWorker$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedDetailRsp>
{
  QCircleSimpleEventFeedWorker$1(QCircleSimpleEventFeedWorker paramQCircleSimpleEventFeedWorker, PublishUploadTaskResultEvent paramPublishUploadTaskResultEvent) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedDetailRsp.feed != null))
    {
      QCircleSimpleEventFeedWorker.a(this.b, paramStGetFeedDetailRsp, this.a);
      SimpleEventBus.getInstance().dispatchEvent(new QCircleSelectTabEvent(1));
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedOptEvent(1));
    }
    QLog.d("QCircleSimpleEventFeedWorker", 1, new Object[] { "fetch real feed success:", Boolean.valueOf(paramBoolean), "  retCode code:", Long.valueOf(paramLong) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.datacenter.QCircleSimpleEventFeedWorker.1
 * JD-Core Version:    0.7.0.1
 */