package com.tencent.biz.qqcircle.richframework.sender.iml.req;

import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleUndoPushUpdateEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor;
import com.tencent.biz.qqcircle.utils.QCircleProtoUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPushList;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;

public class QCircleUndoPushReqInterceptor
  extends QCircleFakeInterceptor
{
  public QCircleUndoPushReqInterceptor(boolean paramBoolean, Object paramObject)
  {
    super(paramBoolean, paramObject);
  }
  
  public void a(QCircleBaseRequest paramQCircleBaseRequest, Object paramObject, BaseSenderChain paramBaseSenderChain)
  {
    if ((paramQCircleBaseRequest instanceof QCircleDoRecommendRequest))
    {
      QLog.d("QCircleUndoPushReqInterceptor", 1, "撤销推假操作");
      paramBaseSenderChain = (QCircleDoRecommendRequest)paramQCircleBaseRequest;
      paramQCircleBaseRequest = paramBaseSenderChain.getStFeed();
      if ((paramQCircleBaseRequest != null) && (paramQCircleBaseRequest.busiData.get() != null))
      {
        paramObject = paramQCircleBaseRequest.id.get();
        QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData = new QQCircleFeedBase.StFeedBusiReqData();
        try
        {
          localStFeedBusiReqData.mergeFrom(paramQCircleBaseRequest.busiData.get().toByteArray());
          paramBaseSenderChain.setUndoPushCount(localStFeedBusiReqData.pushList.hasClickCount.get());
          paramBaseSenderChain = QCirclePushInfoManager.a().a(paramObject);
          QCircleProtoUtil.a(paramBaseSenderChain);
          QCirclePushInfoManager.a().b(paramObject, paramBaseSenderChain);
          QCircleFeedDataCenter.a().a(new FeedBlockData(paramQCircleBaseRequest), true);
          paramQCircleBaseRequest = new QCircleUndoPushUpdateEvent(paramObject);
          SimpleEventBus.getInstance().dispatchEvent(paramQCircleBaseRequest);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramQCircleBaseRequest)
        {
          paramQCircleBaseRequest.printStackTrace();
        }
      }
    }
  }
  
  public void a(QCircleBaseRequest paramQCircleBaseRequest, Object paramObject1, BaseSenderChain paramBaseSenderChain, Object paramObject2)
  {
    if ((paramQCircleBaseRequest instanceof QCircleDoRecommendRequest))
    {
      QLog.d("QCircleUndoPushReqInterceptor", 1, "回退推假操作");
      paramQCircleBaseRequest = (QCircleDoRecommendRequest)paramQCircleBaseRequest;
      paramObject1 = paramQCircleBaseRequest.getStFeed();
      if (paramObject1 != null)
      {
        paramBaseSenderChain = paramObject1.id.get();
        paramObject2 = QCirclePushInfoManager.a().a(paramBaseSenderChain);
        if (paramObject2 != null)
        {
          int i = paramObject2.hasClickCount.get() + paramQCircleBaseRequest.getUndoPushCount();
          QCircleProtoUtil.a(paramObject2, i);
          QCirclePushInfoManager.a().a(paramBaseSenderChain, paramObject2);
          QCircleFeedDataCenter.a().a(new FeedBlockData(paramObject1), true);
          paramQCircleBaseRequest = new QCirclePushUpdateEvent(QCirclePluginGlobalInfo.c(), paramBaseSenderChain, i);
          SimpleEventBus.getInstance().dispatchEvent(paramQCircleBaseRequest);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.req.QCircleUndoPushReqInterceptor
 * JD-Core Version:    0.7.0.1
 */