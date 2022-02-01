package com.tencent.biz.qqcircle.comment;

import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudWrite.StDoReplyRsp;
import java.util.Map;

class QCircleCommentBusiness$9
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoReplyRsp>
{
  QCircleCommentBusiness$9(QCircleCommentBusiness paramQCircleCommentBusiness, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoReplyRsp paramStDoReplyRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStDoReplyRsp != null))
    {
      QLog.d("QCircleCommentBusiness", 1, "deleteCommentReply Success");
      paramStDoReplyRsp.reply.id.set(this.a.id.get());
      QCircleCommentBusiness.a(this.e).put(this.b.id.get(), Integer.valueOf(this.e.b(this.b.id.get()) - 1));
      SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentUpdateEvent(6, this.b.id.get(), this.c, this.a, this.e.b(this.b.id.get()), this.d));
      return;
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("deleteCommentReply error:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append("  errorMsg:");
    paramBaseRequest.append(paramString);
    QLog.e("QCircleCommentBusiness", 1, paramBaseRequest.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentBusiness.9
 * JD-Core Version:    0.7.0.1
 */