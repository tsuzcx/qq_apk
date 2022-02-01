package com.tencent.biz.qqcircle.richframework.sender.iml.req;

import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.MergeReqInterceptor;
import feedcloud.FeedCloudMeta.StFeed;

public class QCirclePolyLikeMergeReqInterceptor
  extends MergeReqInterceptor<QCircleDoLikeRequest, BaseSenderChain>
{
  public long a(QCircleDoLikeRequest paramQCircleDoLikeRequest)
  {
    return 500L;
  }
  
  public QCircleDoLikeRequest a(QCircleDoLikeRequest paramQCircleDoLikeRequest1, QCircleDoLikeRequest paramQCircleDoLikeRequest2)
  {
    return null;
  }
  
  public String b(QCircleDoLikeRequest paramQCircleDoLikeRequest)
  {
    return paramQCircleDoLikeRequest.getStFeed().id.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.req.QCirclePolyLikeMergeReqInterceptor
 * JD-Core Version:    0.7.0.1
 */