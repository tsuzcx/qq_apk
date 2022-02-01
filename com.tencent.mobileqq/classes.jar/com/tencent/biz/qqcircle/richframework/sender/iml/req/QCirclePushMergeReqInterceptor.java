package com.tencent.biz.qqcircle.richframework.sender.iml.req;

import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.MergeReqInterceptor;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoPushReq;

public class QCirclePushMergeReqInterceptor
  extends MergeReqInterceptor<QCircleDoRecommendRequest, BaseSenderChain>
{
  public long a(QCircleDoRecommendRequest paramQCircleDoRecommendRequest)
  {
    return 1500L;
  }
  
  public QCircleDoRecommendRequest a(QCircleDoRecommendRequest paramQCircleDoRecommendRequest1, QCircleDoRecommendRequest paramQCircleDoRecommendRequest2)
  {
    FeedCloudWrite.StDoPushReq localStDoPushReq = paramQCircleDoRecommendRequest1.getReq();
    paramQCircleDoRecommendRequest2 = paramQCircleDoRecommendRequest2.getReq();
    int i = localStDoPushReq.comboCount.get();
    int j = paramQCircleDoRecommendRequest2.comboCount.get();
    localStDoPushReq.comboCount.set(i + j);
    paramQCircleDoRecommendRequest1.setReq(localStDoPushReq);
    return paramQCircleDoRecommendRequest1;
  }
  
  public String b(QCircleDoRecommendRequest paramQCircleDoRecommendRequest)
  {
    FeedCloudWrite.StDoPushReq localStDoPushReq = paramQCircleDoRecommendRequest.getReq();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQCircleDoRecommendRequest.getCmdName());
    localStringBuilder.append(localStDoPushReq.feed.id.get());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.req.QCirclePushMergeReqInterceptor
 * JD-Core Version:    0.7.0.1
 */