package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudWrite.StDoLikeRsp;

class QCircleCommentPraiseLayout$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoLikeRsp>
{
  QCircleCommentPraiseLayout$1(QCircleCommentPraiseLayout paramQCircleCommentPraiseLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramBaseRequest = QCircleCommentPraiseLayout.a(this.e);
      paramString = "";
      if (paramBaseRequest != null) {
        paramBaseRequest = QCircleCommentPraiseLayout.a(this.e).id.get();
      } else {
        paramBaseRequest = "";
      }
      if (QCircleCommentPraiseLayout.b(this.e) != null) {
        paramString = QCircleCommentPraiseLayout.b(this.e).id.get();
      }
      if ((QCircleCommentPraiseLayout.c(this.e) == 1) && (QCircleCommentPraiseLayout.a(this.e) != null))
      {
        QCircleCommentPraiseLayout.a(this.e).likeInfo.status.set(this.a);
        QCircleCommentPraiseLayout.a(this.e).likeInfo.count.set(this.b);
      }
      else if ((QCircleCommentPraiseLayout.c(this.e) == 2) && (QCircleCommentPraiseLayout.b(this.e) != null))
      {
        QCircleCommentPraiseLayout.b(this.e).likeInfo.status.set(this.a);
        QCircleCommentPraiseLayout.b(this.e).likeInfo.count.set(this.b);
      }
      SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentPraiseUpdateEvent(QCircleCommentPraiseLayout.c(this.e), this.a, QCircleCommentPraiseLayout.d(this.e).id.get(), paramBaseRequest, paramString, this.b));
    }
    else
    {
      this.e.a(this.c, this.d);
      QCircleToastUtil.a(paramLong, paramString, 0);
      QLog.d("QCircleCommentPraiseLay", 4, "zan failed");
    }
    QCircleCommentPraiseLayout.a(this.e, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout.1
 * JD-Core Version:    0.7.0.1
 */