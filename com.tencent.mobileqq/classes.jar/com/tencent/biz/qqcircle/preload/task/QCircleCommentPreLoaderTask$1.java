package com.tencent.biz.qqcircle.preload.task;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import feedcloud.FeedCloudRead.StGetCommentListRsp;

class QCircleCommentPreLoaderTask$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetCommentListRsp>
{
  QCircleCommentPreLoaderTask$1(QCircleCommentPreLoaderTask paramQCircleCommentPreLoaderTask, OnPreLoadListener paramOnPreLoadListener) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    paramBaseRequest = this.a;
    if (paramBaseRequest != null) {
      paramBaseRequest.onLoaded(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramStGetCommentListRsp });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.preload.task.QCircleCommentPreLoaderTask.1
 * JD-Core Version:    0.7.0.1
 */