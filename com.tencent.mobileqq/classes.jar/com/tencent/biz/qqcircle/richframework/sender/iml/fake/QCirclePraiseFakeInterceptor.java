package com.tencent.biz.qqcircle.richframework.sender.iml.fake;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeManager;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import java.util.List;
import qqcircle.QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class QCirclePraiseFakeInterceptor
  extends QCircleFakeInterceptor
{
  public QCirclePraiseFakeInterceptor(boolean paramBoolean, Object paramObject)
  {
    super(paramBoolean, paramObject);
  }
  
  public void a(QCircleBaseRequest paramQCircleBaseRequest, Object paramObject, BaseSenderChain paramBaseSenderChain)
  {
    if ((paramQCircleBaseRequest instanceof QCircleDoLikeRequest))
    {
      paramQCircleBaseRequest = (QCircleDoLikeRequest)paramQCircleBaseRequest;
      boolean bool = paramQCircleBaseRequest.isPraise();
      paramBaseSenderChain = paramQCircleBaseRequest.getStFeed();
      if (paramBaseSenderChain == null) {
        return;
      }
      QQCircleFeedBase.StPolyLike localStPolyLike = QCirclePolyLikeManager.a(paramBaseSenderChain);
      int i = paramBaseSenderChain.likeInfo.count.get();
      int j;
      if (bool)
      {
        paramQCircleBaseRequest = QCirclePolyLikeManager.a("6");
        j = i + 1;
        i = 1;
      }
      else
      {
        paramObject = QCirclePolyLikeManager.a(paramBaseSenderChain);
        if (paramObject != null)
        {
          paramQCircleBaseRequest = paramObject;
          if (!TextUtils.equals(paramObject.polyLikeID.get(), "206008"))
          {
            paramQCircleBaseRequest = paramObject;
            if (TextUtils.equals(paramObject.polyLikeID.get(), "205993")) {}
          }
        }
        else
        {
          paramQCircleBaseRequest = QCirclePolyLikeManager.a("");
        }
        j = i - QCirclePolyLikeManager.b(paramBaseSenderChain);
        i = 0;
      }
      paramBaseSenderChain.likeInfo.count.set(j);
      paramBaseSenderChain.likeInfo.status.set(i);
      paramQCircleBaseRequest = new QCirclePolyPraiseUpdateEvent(paramBaseSenderChain.id.get(), localStPolyLike, paramQCircleBaseRequest, i, j);
      RFThreadManager.getUIHandler().post(new QCirclePraiseFakeInterceptor.1(this, paramQCircleBaseRequest));
      try
      {
        paramQCircleBaseRequest = new QQCircleFeedBase.StLikeBusiData();
        paramQCircleBaseRequest.mergeFrom(paramBaseSenderChain.likeInfo.busiData.get().toByteArray());
        if (bool) {
          paramQCircleBaseRequest.likeIDs.add("6");
        } else {
          paramQCircleBaseRequest.likeIDs.clear();
        }
        paramBaseSenderChain.likeInfo.busiData.set(ByteStringMicro.copyFrom(paramQCircleBaseRequest.toByteArray()));
        QCircleFeedDataCenter.a().a(new FeedBlockData(paramBaseSenderChain), true);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramQCircleBaseRequest)
      {
        paramQCircleBaseRequest.printStackTrace();
      }
    }
  }
  
  public void a(QCircleBaseRequest paramQCircleBaseRequest, Object paramObject1, BaseSenderChain paramBaseSenderChain, Object paramObject2)
  {
    if ((paramQCircleBaseRequest instanceof QCircleDoLikeRequest))
    {
      paramQCircleBaseRequest = (QCircleDoLikeRequest)paramQCircleBaseRequest;
      paramObject1 = paramQCircleBaseRequest.getStFeed();
      if (paramObject1 == null) {
        return;
      }
      boolean bool = paramQCircleBaseRequest.isPraise();
      try
      {
        paramBaseSenderChain = new QQCircleFeedBase.StLikeBusiData();
        paramBaseSenderChain.mergeFrom(paramObject1.likeInfo.busiData.get().toByteArray());
        paramObject2 = paramBaseSenderChain.curPolyLikeInfo;
        new QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData().curPolyLikeInfo.set(paramBaseSenderChain.curPolyLikeInfo);
        int i = paramObject1.likeInfo.count.get();
        int j;
        if (!bool)
        {
          paramQCircleBaseRequest = QCirclePolyLikeManager.a("6");
          paramBaseSenderChain.likeIDs.get().add("6");
          j = i + 1;
          i = 1;
        }
        else
        {
          paramQCircleBaseRequest = QCirclePolyLikeManager.a("");
          j = QCirclePolyLikeManager.b(paramObject1);
          paramBaseSenderChain.likeIDs.get().clear();
          j = i - j;
          i = 0;
        }
        paramObject1.likeInfo.count.set(j);
        paramObject1.likeInfo.status.set(i);
        paramQCircleBaseRequest = new QCirclePolyPraiseUpdateEvent(paramObject1.id.get(), paramObject2, paramQCircleBaseRequest, i, j);
        RFThreadManager.getUIHandler().post(new QCirclePraiseFakeInterceptor.2(this, paramQCircleBaseRequest));
        paramObject1.likeInfo.busiData.set(ByteStringMicro.copyFrom(paramBaseSenderChain.toByteArray()));
        QCircleFeedDataCenter.a().a(new FeedBlockData(paramObject1), true);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramQCircleBaseRequest)
      {
        paramQCircleBaseRequest.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.fake.QCirclePraiseFakeInterceptor
 * JD-Core Version:    0.7.0.1
 */