package com.tencent.biz.qqcircle.comment;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudWrite.StDoReplyRsp;
import java.util.Map;

class QCircleCommentBusiness$8
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoReplyRsp>
{
  QCircleCommentBusiness$8(QCircleCommentBusiness paramQCircleCommentBusiness, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoReplyRsp paramStDoReplyRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStDoReplyRsp != null))
    {
      QLog.d("QCircleCommentBusiness", 1, "addCommentReply Success");
      paramBaseRequest = this.c.id.get();
      this.c.id.set(paramStDoReplyRsp.reply.id.get());
      this.c.createTime.set(paramStDoReplyRsp.reply.createTime.get());
      this.c.likeInfo.set(paramStDoReplyRsp.reply.likeInfo.get());
      paramStDoReplyRsp.reply.set(this.c);
      QCircleCommentBusiness.a(this.e).put(this.a.id.get(), Integer.valueOf(this.e.b(this.a.id.get()) + 1));
      paramString = new QCircleCommentUpdateEvent(5, this.a.id.get(), this.b, this.c, this.e.b(this.a.id.get()), this.d);
      paramString.fakeReplyId = paramBaseRequest;
      SimpleEventBus.getInstance().dispatchEvent(paramString);
      return;
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("addCommentReply error:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append("  errorMsg:");
    paramBaseRequest.append(paramString);
    QLog.e("QCircleCommentBusiness", 1, paramBaseRequest.toString());
    SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentUpdateEvent(10, this.a.id.get(), this.b, this.c, this.d));
    TextUtils.isEmpty(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentBusiness.8
 * JD-Core Version:    0.7.0.1
 */