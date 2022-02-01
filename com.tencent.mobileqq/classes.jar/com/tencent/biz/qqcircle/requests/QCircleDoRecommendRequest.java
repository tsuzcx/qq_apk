package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudWrite.StDoPushReq;
import feedcloud.FeedCloudWrite.StDoPushRsp;
import java.util.ArrayList;
import java.util.List;

public class QCircleDoRecommendRequest
  extends QCircleBaseRequest
{
  private FeedCloudWrite.StDoPushReq mReq;
  private FeedCloudMeta.StFeed mStFeed;
  private int mUndoPushCount = 0;
  
  public QCircleDoRecommendRequest(FeedCloudMeta.StFeed paramStFeed, int paramInt1, FeedCloudMeta.StPushList paramStPushList, int paramInt2)
  {
    if (paramStFeed == null)
    {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
      return;
    }
    this.mReq = new FeedCloudWrite.StDoPushReq();
    this.mReq.feed.set(QCirclePluginUtil.a(paramStFeed));
    this.mReq.comboCount.set(paramInt1);
    if (paramStPushList != null) {
      this.mReq.push.set(paramStPushList);
    }
    this.mReq.pushType.set(paramInt2);
    Object localObject = new FeedCloudCommon.Entry();
    ((FeedCloudCommon.Entry)localObject).key.set("doPushTimestamp");
    ((FeedCloudCommon.Entry)localObject).value.set(String.valueOf(System.currentTimeMillis()));
    paramStPushList = new ArrayList();
    paramStPushList.add(localObject);
    localObject = new FeedCloudCommon.StCommonExt();
    ((FeedCloudCommon.StCommonExt)localObject).mapInfo.set(paramStPushList);
    this.mReq.extInfo.set((MessageMicro)localObject);
    this.mStFeed = paramStFeed;
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudWrite.StDoPushRsp localStDoPushRsp = new FeedCloudWrite.StDoPushRsp();
    try
    {
      localStDoPushRsp.mergeFrom(paramArrayOfByte);
      return localStDoPushRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStDoPushRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoPush";
  }
  
  public FeedCloudWrite.StDoPushReq getReq()
  {
    return this.mReq;
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
  
  public FeedCloudMeta.StFeed getStFeed()
  {
    return this.mStFeed;
  }
  
  public int getUndoPushCount()
  {
    return this.mUndoPushCount;
  }
  
  public void setReq(FeedCloudWrite.StDoPushReq paramStDoPushReq)
  {
    this.mReq = paramStDoPushReq;
  }
  
  public void setUndoPushCount(int paramInt)
  {
    this.mUndoPushCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest
 * JD-Core Version:    0.7.0.1
 */