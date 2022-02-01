package com.tencent.biz.qqcircle.polylike;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoLikeRsp;
import qqcircle.QQCircleFeedBase.StPolyLike;

class QCirclePolyRequestManager$3
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoLikeRsp>
{
  QCirclePolyRequestManager$3(QCirclePolyRequestManager paramQCirclePolyRequestManager, int paramInt, FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike1, QQCircleFeedBase.StPolyLike paramStPolyLike2) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    String str = QCirclePolyRequestManager.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceive: dispatch Success:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" | TraceId:");
    localStringBuilder.append(paramBaseRequest.getTraceId());
    localStringBuilder.append(" | SeqId:");
    localStringBuilder.append(paramBaseRequest.getCurrentSeq());
    localStringBuilder.append(" | retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" | retMessage:");
    localStringBuilder.append(paramString);
    QLog.d(str, 1, localStringBuilder.toString());
    if ((paramBoolean) && (paramLong == 0L))
    {
      QCirclePolyRequestManager.b(this.e, true);
      if (!QCirclePolyRequestManager.b(this.e))
      {
        int i = this.a;
        if (i != 21) {
          this.e.a(this.b, i, this.c, this.d);
        }
      }
      if (this.a == 21) {
        QCirclePolyRequestManager.a(this.e, paramStDoLikeRsp);
      }
      QCirclePolyRequestManager.a(this.e, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyRequestManager.3
 * JD-Core Version:    0.7.0.1
 */