package com.tencent.biz.qqcircle.comment;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetCommentListRsp;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

class QCircleCommentBusiness$3
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetCommentListRsp>
{
  QCircleCommentBusiness$3(QCircleCommentBusiness paramQCircleCommentBusiness, int paramInt, FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StBusiInfoCommentListData paramStBusiInfoCommentListData) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    QCircleCommentBusiness.a(this.d, this.a, paramBoolean, paramLong, paramString, paramStGetCommentListRsp, this.b, false, false, true, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentBusiness.3
 * JD-Core Version:    0.7.0.1
 */