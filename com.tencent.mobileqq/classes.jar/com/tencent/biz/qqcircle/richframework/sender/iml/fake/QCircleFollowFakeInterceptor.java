package com.tencent.biz.qqcircle.richframework.sender.iml.fake;

import com.tencent.biz.qqcircle.datacenter.convert.QFSUserFollowDataConverter;
import com.tencent.biz.qqcircle.datacenter.data.QFSUserFollowData;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import cooperation.qqcircle.helpers.QCircleFollowManager;

public class QCircleFollowFakeInterceptor
  extends QCircleFakeInterceptor
{
  public QCircleFollowFakeInterceptor(boolean paramBoolean, Object paramObject)
  {
    super(paramBoolean, paramObject);
  }
  
  public void a(QCircleBaseRequest paramQCircleBaseRequest, Object paramObject, BaseSenderChain paramBaseSenderChain)
  {
    if ((paramObject instanceof QCircleFollowFakeInterceptor.FakeFollowRsp))
    {
      paramQCircleBaseRequest = (QCircleFollowFakeInterceptor.FakeFollowRsp)paramObject;
      QCircleFollowManager.getInstance().setFakeUinFollowed(paramQCircleBaseRequest.a, paramQCircleBaseRequest.c);
      QFSUserFollowDataConverter.b(new QFSUserFollowData(paramQCircleBaseRequest.a, paramQCircleBaseRequest.c));
      paramQCircleBaseRequest = new QCircleFollowUpdateEvent(paramQCircleBaseRequest.c, paramQCircleBaseRequest.a);
      if (paramBaseSenderChain.a() != null) {
        paramQCircleBaseRequest.mHashCode = paramBaseSenderChain.a().hashCode();
      }
      SimpleEventBus.getInstance().dispatchEvent(paramQCircleBaseRequest);
    }
  }
  
  public void a(QCircleBaseRequest paramQCircleBaseRequest, Object paramObject1, BaseSenderChain paramBaseSenderChain, Object paramObject2)
  {
    if ((paramObject2 instanceof QCircleFollowFakeInterceptor.FakeFollowRsp))
    {
      paramQCircleBaseRequest = (QCircleFollowFakeInterceptor.FakeFollowRsp)paramObject2;
      QCircleFollowManager.getInstance().clearFakeUinFollowed(paramQCircleBaseRequest.a);
      QFSUserFollowDataConverter.b(new QFSUserFollowData(paramQCircleBaseRequest.a, paramQCircleBaseRequest.b));
      paramObject1 = new StringBuilder();
      paramObject1.append("resetFake uin:");
      paramObject1.append(paramQCircleBaseRequest.a);
      paramObject1.append("preFollowState:");
      paramObject1.append(paramQCircleBaseRequest.b);
      paramObject1.append(" newFollowState:");
      paramObject1.append(paramQCircleBaseRequest.c);
      QLog.d("QCircleFollowFakeInterceptor", 1, paramObject1.toString());
      paramQCircleBaseRequest = new QCircleFollowUpdateEvent(paramQCircleBaseRequest.b, paramQCircleBaseRequest.a);
      if (paramBaseSenderChain.a() != null) {
        paramQCircleBaseRequest.mHashCode = paramBaseSenderChain.a().hashCode();
      }
      SimpleEventBus.getInstance().dispatchEvent(paramQCircleBaseRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.fake.QCircleFollowFakeInterceptor
 * JD-Core Version:    0.7.0.1
 */