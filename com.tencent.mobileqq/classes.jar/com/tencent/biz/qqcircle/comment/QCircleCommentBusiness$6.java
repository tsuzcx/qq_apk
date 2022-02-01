package com.tencent.biz.qqcircle.comment;

import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudWrite.StDoCommentRsp;
import java.util.Map;

class QCircleCommentBusiness$6
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoCommentRsp>
{
  QCircleCommentBusiness$6(QCircleCommentBusiness paramQCircleCommentBusiness, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoCommentRsp paramStDoCommentRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStDoCommentRsp != null))
    {
      QLog.d("QCircleCommentBusiness", 1, "addFeedComment Success");
      paramBaseRequest = this.b.id.get();
      this.b.id.set(paramStDoCommentRsp.comment.id.get());
      this.b.createTime.set(paramStDoCommentRsp.comment.createTime.get());
      this.b.likeInfo.set(paramStDoCommentRsp.comment.likeInfo.get());
      paramStDoCommentRsp.comment.set(this.b);
      QCircleCommentBusiness.a(this.e).put(this.a.id.get(), Integer.valueOf(this.e.b(this.a.id.get()) + 1));
      paramString = new QCircleCommentUpdateEvent(3, this.a.id.get(), this.b, this.e.b(this.a.id.get()), this.c);
      paramString.fakeCommentId = paramBaseRequest;
      SimpleEventBus.getInstance().dispatchEvent(paramString);
      paramBaseRequest = this.e;
      paramString = this.a;
      QCircleCommentBusiness.a(paramBaseRequest, paramString, paramBaseRequest.b(paramString.id.get()));
      if (this.d) {
        QCircleToast.a("评论已发送", 0);
      }
      return;
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("addFeedComment error:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append("  errorMsg:");
    paramBaseRequest.append(paramString);
    QLog.e("QCircleCommentBusiness", 1, paramBaseRequest.toString());
    SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentUpdateEvent(9, this.a.id.get(), this.b, null, this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentBusiness.6
 * JD-Core Version:    0.7.0.1
 */