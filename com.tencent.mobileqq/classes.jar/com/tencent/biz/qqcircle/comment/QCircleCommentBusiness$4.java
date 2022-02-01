package com.tencent.biz.qqcircle.comment;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetCommentListRsp;

class QCircleCommentBusiness$4
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetCommentListRsp>
{
  QCircleCommentBusiness$4(QCircleCommentBusiness paramQCircleCommentBusiness, int paramInt, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    QCircleCommentBusiness.a(this.e, this.a, paramBoolean, paramLong, paramString, paramStGetCommentListRsp, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentBusiness.4
 * JD-Core Version:    0.7.0.1
 */