package com.tencent.biz.qqcircle.richframework.sender.iml.rsp;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.qqcircle.utils.QCircleProtoUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudWrite.StDoPushReq;
import feedcloud.FeedCloudWrite.StDoPushRsp;

public class QCirclePushRspInterceptor
  implements RspInterceptor<QCircleDoRecommendRequest, BaseSenderChain>
{
  public String a()
  {
    return "QCirclePushRspInterceptor";
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QCircleDoRecommendRequest paramQCircleDoRecommendRequest, Object paramObject, BaseSenderChain paramBaseSenderChain)
  {
    paramBaseSenderChain.a(paramBoolean, paramLong, paramString, paramQCircleDoRecommendRequest, paramObject);
    if (!(paramObject instanceof FeedCloudWrite.StDoPushRsp)) {
      return;
    }
    paramObject = (FeedCloudWrite.StDoPushRsp)paramObject;
    if ((paramBoolean) && (paramLong == 0L) && (paramQCircleDoRecommendRequest != null))
    {
      if ((paramQCircleDoRecommendRequest.getReq() == null) || (TextUtils.isEmpty(paramQCircleDoRecommendRequest.getReq().feed.id.get()))) {
        QLog.d(a(), 4, "interceptReturnRsp params error");
      }
      paramString = paramQCircleDoRecommendRequest.getReq().feed.id.get();
      paramBaseSenderChain = QCirclePushInfoManager.a().a(paramString);
      if (paramBaseSenderChain != null)
      {
        int i = paramBaseSenderChain.hasClickCount.get();
        int j = paramObject.consumeFuel.get() + i;
        QCircleProtoUtil.a(paramBaseSenderChain, j);
        QCirclePushInfoManager.a().a(paramString, paramBaseSenderChain);
        QCircleFeedDataCenter.a().a(new FeedBlockData(paramQCircleDoRecommendRequest.getReq().feed), true);
        paramQCircleDoRecommendRequest = new QCirclePushUpdateEvent(QCirclePluginGlobalInfo.c(), paramString, j);
        SimpleEventBus.getInstance().dispatchEvent(paramQCircleDoRecommendRequest);
        if (i == 0) {
          QCirclePushInfoManager.a().b(paramString);
        }
      }
      else
      {
        QLog.e(a(), 4, "interceptReturnRsp pushInfo is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.rsp.QCirclePushRspInterceptor
 * JD-Core Version:    0.7.0.1
 */