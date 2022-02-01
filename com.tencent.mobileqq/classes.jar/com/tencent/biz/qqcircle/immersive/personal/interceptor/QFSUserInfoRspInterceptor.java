package com.tencent.biz.qqcircle.immersive.personal.interceptor;

import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.datacenter.data.QFSUserFollowData;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

public class QFSUserInfoRspInterceptor
  implements RspInterceptor<QCircleBaseRequest, BaseSenderChain>
{
  public void a(boolean paramBoolean, long paramLong, String paramString, QCircleBaseRequest paramQCircleBaseRequest, Object paramObject, BaseSenderChain paramBaseSenderChain)
  {
    if ((paramBoolean) && (paramLong == 0L) && ((paramObject instanceof FeedCloudRead.StGetMainPageRsp)))
    {
      Object localObject = (FeedCloudRead.StGetMainPageRsp)paramObject;
      paramBaseSenderChain.b(true, paramLong, paramString, paramQCircleBaseRequest, QFSPersonalInfo.a((FeedCloudRead.StGetMainPageRsp)localObject));
      localObject = new QFSUserFollowData(((FeedCloudRead.StGetMainPageRsp)localObject).user.id.get(), ((FeedCloudRead.StGetMainPageRsp)localObject).user.followState.get(), ((FeedCloudRead.StGetMainPageRsp)localObject).fansCount.get(), ((FeedCloudRead.StGetMainPageRsp)localObject).followCount.get());
      QCircleFeedDataCenter.a().a(localObject, true);
    }
    paramBaseSenderChain.a(paramBoolean, paramLong, paramString, paramQCircleBaseRequest, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUserInfoRspInterceptor
 * JD-Core Version:    0.7.0.1
 */