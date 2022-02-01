package com.tencent.biz.qqcircle.comment;

import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoTopRsp;

class QCircleCommentBusiness$11
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoTopRsp>
{
  QCircleCommentBusiness$11(QCircleCommentBusiness paramQCircleCommentBusiness, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoTopRsp paramStDoTopRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStDoTopRsp != null))
    {
      QLog.d("QCircleCommentBusiness", 1, "cancelStickyFeedComment Success");
      QCircleCommentBusiness.a(this.d, this.a.id.get(), "");
      paramBaseRequest = SimpleEventBus.getInstance();
      paramString = this.a.id.get();
      paramStDoTopRsp = this.b;
      paramBaseRequest.dispatchEvent(new QCircleCommentUpdateEvent(8, paramString, paramStDoTopRsp, this.d.b(paramStDoTopRsp.id.get()), this.c));
      return;
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("cancelStickyFeedComment error:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append("  errorMsg:");
    paramBaseRequest.append(paramString);
    QLog.e("QCircleCommentBusiness", 1, paramBaseRequest.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentBusiness.11
 * JD-Core Version:    0.7.0.1
 */