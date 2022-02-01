package com.tencent.biz.qqcircle.comment;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetCommentListRsp;

class QCircleCommentBusiness$5
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetCommentListRsp>
{
  QCircleCommentBusiness$5(QCircleCommentBusiness paramQCircleCommentBusiness, int paramInt, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    QCircleCommentBusiness.a(this.d, this.a, paramBoolean, paramLong, paramString, paramStGetCommentListRsp, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentBusiness.5
 * JD-Core Version:    0.7.0.1
 */