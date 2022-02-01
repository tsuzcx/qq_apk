package com.tencent.biz.qqcircle.datacenter.impl;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.datacenter.request.QCircleRecommendListRequest;
import com.tencent.biz.qqcircle.rank.QCircleRankEventCollector;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetCloudSealFeedReq;
import feedcloud.FeedCloudRead.StGetCloudSealFeedRsp;

class QCircleSealFeedProvider$SealRspInterceptor
  implements ReqInterceptor<Object, BaseSenderChain<Object>>, RspInterceptor<Object, BaseSenderChain<Object>>
{
  public void a(Object paramObject, BaseSenderChain<Object> paramBaseSenderChain)
  {
    if ((paramObject instanceof QCircleRecommendListRequest)) {
      ((QCircleRecommendListRequest)paramObject).mRequest.extInfo.set(QCircleRankEventCollector.getInstance().getExtCommonInfo());
    }
    paramBaseSenderChain.a(paramObject);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, Object paramObject1, Object paramObject2, BaseSenderChain<Object> paramBaseSenderChain)
  {
    if ((paramObject2 instanceof FeedCloudRead.StGetCloudSealFeedRsp))
    {
      FeedCloudRead.StGetCloudSealFeedRsp localStGetCloudSealFeedRsp = (FeedCloudRead.StGetCloudSealFeedRsp)paramObject2;
      if (localStGetCloudSealFeedRsp.sealClientInfo.has())
      {
        String str2;
        try
        {
          String str1 = localStGetCloudSealFeedRsp.sealClientInfo.get().toStringUtf8();
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("sealClientInfo toString error");
          localStringBuilder.append(localException.getMessage());
          QLog.e("QCircleSealFeedProvider", 1, localStringBuilder.toString());
          str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
          QCircleRankEventCollector.getInstance().setAlgorithmExtraParams(str2);
        }
      }
      QCircleRankEventCollector.getInstance().setExtCommonInfo((FeedCloudCommon.StCommonExt)localStGetCloudSealFeedRsp.extInfo.get());
    }
    paramBaseSenderChain.a(paramBoolean, paramLong, paramString, paramObject1, paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.datacenter.impl.QCircleSealFeedProvider.SealRspInterceptor
 * JD-Core Version:    0.7.0.1
 */