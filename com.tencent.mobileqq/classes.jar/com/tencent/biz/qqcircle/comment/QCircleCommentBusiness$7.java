package com.tencent.biz.qqcircle.comment;

import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoCommentRsp;
import java.util.Map;

class QCircleCommentBusiness$7
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoCommentRsp>
{
  QCircleCommentBusiness$7(QCircleCommentBusiness paramQCircleCommentBusiness, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StFeed paramStFeed, int paramInt) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoCommentRsp paramStDoCommentRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStDoCommentRsp != null))
    {
      QLog.d("QCircleCommentBusiness", 1, "deleteFeedComment Success");
      paramStDoCommentRsp.comment.id.set(this.a.id.get());
      QCircleCommentBusiness.a(this.d).put(this.b.id.get(), Integer.valueOf(this.d.b(this.b.id.get()) - 1 - this.a.vecReply.size()));
      SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentUpdateEvent(4, this.b.id.get(), this.a, this.d.b(this.b.id.get()), this.c));
      paramBaseRequest = this.d;
      paramString = this.b;
      QCircleCommentBusiness.a(paramBaseRequest, paramString, paramBaseRequest.b(paramString.id.get()));
      return;
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("deleteFeedComment error:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append("  errorMsg:");
    paramBaseRequest.append(paramString);
    QLog.e("QCircleCommentBusiness", 1, paramBaseRequest.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentBusiness.7
 * JD-Core Version:    0.7.0.1
 */