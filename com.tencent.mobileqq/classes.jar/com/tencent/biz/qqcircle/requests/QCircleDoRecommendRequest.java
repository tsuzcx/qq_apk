package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudWrite.StDoPushReq;
import feedcloud.FeedCloudWrite.StDoPushRsp;
import uxx;

public class QCircleDoRecommendRequest
  extends QCircleBaseRequest
{
  private FeedCloudWrite.StDoPushReq mReq;
  
  public QCircleDoRecommendRequest(FeedCloudMeta.StFeed paramStFeed, int paramInt1, FeedCloudMeta.StPushList paramStPushList, int paramInt2)
  {
    if (paramStFeed == null)
    {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
      return;
    }
    this.mReq = new FeedCloudWrite.StDoPushReq();
    this.mReq.feed.set(uxx.a(paramStFeed));
    this.mReq.comboCount.set(paramInt1);
    if (paramStPushList != null) {
      this.mReq.push.set(paramStPushList);
    }
    this.mReq.pushType.set(paramInt2);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudWrite.StDoPushRsp localStDoPushRsp = new FeedCloudWrite.StDoPushRsp();
    localStDoPushRsp.mergeFrom(paramArrayOfByte);
    return localStDoPushRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoPush";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest
 * JD-Core Version:    0.7.0.1
 */