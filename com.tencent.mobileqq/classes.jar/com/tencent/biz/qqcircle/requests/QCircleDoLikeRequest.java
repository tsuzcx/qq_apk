package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoLikeReq;
import feedcloud.FeedCloudWrite.StDoLikeRsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData;

public class QCircleDoLikeRequest
  extends QCircleBaseRequest
{
  private boolean mIsPraise = false;
  private boolean mIsReward = false;
  private FeedCloudWrite.StDoLikeReq mReq;
  private FeedCloudMeta.StFeed mStFeed;
  
  public QCircleDoLikeRequest(FeedCloudMeta.StFeed paramStFeed, int paramInt, FeedCloudMeta.StLike paramStLike, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, boolean paramBoolean)
  {
    if (paramStFeed == null)
    {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
      return;
    }
    this.mReq = new FeedCloudWrite.StDoLikeReq();
    this.mReq.feed.set(QCirclePluginUtil.a(paramStFeed));
    this.mReq.likeType.set(paramInt);
    if (paramStLike != null)
    {
      paramStLike.vecUser.set(Arrays.asList(new FeedCloudMeta.StUser[] { QCirclePluginGlobalInfo.c() }));
      paramStLike.postUser.set(QCirclePluginGlobalInfo.c());
      this.mReq.like.set(paramStLike);
    }
    if (paramStComment != null) {
      this.mReq.comment.set(paramStComment);
    }
    if (paramStReply != null) {
      this.mReq.reply.set(paramStReply);
    }
    paramStFeed = new FeedCloudCommon.Entry();
    paramStFeed.key.set("ext_source");
    if (paramBoolean) {
      paramStFeed.value.set("2");
    } else {
      paramStFeed.value.set("1");
    }
    paramStLike = new FeedCloudCommon.StCommonExt();
    paramStComment = new ArrayList();
    paramStComment.add(paramStFeed);
    paramStLike.mapInfo.set(paramStComment);
    this.mReq.extInfo.set(paramStLike);
  }
  
  public QCircleDoLikeRequest(FeedCloudMeta.StFeed paramStFeed, int paramInt, FeedCloudMeta.StLike paramStLike, QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData paramStDoLikeReqDoPolyLikeBusiReqData, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramStFeed == null)
    {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
      return;
    }
    this.mIsReward = paramBoolean2;
    this.mReq = new FeedCloudWrite.StDoLikeReq();
    this.mReq.feed.set(QCirclePluginUtil.a(paramStFeed));
    this.mReq.feed.cover.set(paramStFeed.cover.get());
    this.mReq.feed.images.set(paramStFeed.images.get());
    this.mReq.likeType.set(paramInt);
    if (paramStLike != null)
    {
      paramStLike.vecUser.set(Arrays.asList(new FeedCloudMeta.StUser[] { QCirclePluginGlobalInfo.c() }));
      paramStLike.postUser.set(QCirclePluginGlobalInfo.c());
      this.mReq.like.set(paramStLike);
    }
    if (paramStDoLikeReqDoPolyLikeBusiReqData != null) {
      this.mReq.busiReqData.set(ByteStringMicro.copyFrom(paramStDoLikeReqDoPolyLikeBusiReqData.toByteArray()));
    }
    paramStLike = new FeedCloudCommon.Entry();
    paramStLike.key.set("ext_source");
    if (paramBoolean1) {
      paramStLike.value.set("2");
    } else {
      paramStLike.value.set("1");
    }
    paramStDoLikeReqDoPolyLikeBusiReqData = new FeedCloudCommon.StCommonExt();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramStLike);
    paramStDoLikeReqDoPolyLikeBusiReqData.mapInfo.set(localArrayList);
    this.mReq.extInfo.set(paramStDoLikeReqDoPolyLikeBusiReqData);
    this.mStFeed = paramStFeed;
  }
  
  public QCircleDoLikeRequest(FeedCloudMeta.StFeed paramStFeed, int paramInt, FeedCloudMeta.StLike paramStLike, QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData paramStDoLikeReqDoPolyLikeBusiReqData, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramStFeed == null)
    {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
      return;
    }
    this.mIsReward = paramBoolean2;
    this.mReq = new FeedCloudWrite.StDoLikeReq();
    this.mReq.feed.set(QCirclePluginUtil.a(paramStFeed));
    this.mReq.feed.cover.set(paramStFeed.cover.get());
    this.mReq.feed.images.set(paramStFeed.images.get());
    this.mReq.likeType.set(paramInt);
    if (paramStLike != null)
    {
      paramStLike.vecUser.set(Arrays.asList(new FeedCloudMeta.StUser[] { QCirclePluginGlobalInfo.c() }));
      paramStLike.postUser.set(QCirclePluginGlobalInfo.c());
      this.mReq.like.set(paramStLike);
    }
    if (paramStDoLikeReqDoPolyLikeBusiReqData != null) {
      this.mReq.busiReqData.set(ByteStringMicro.copyFrom(paramStDoLikeReqDoPolyLikeBusiReqData.toByteArray()));
    }
    paramStLike = new FeedCloudCommon.Entry();
    paramStLike.key.set("ext_source");
    if (paramBoolean1) {
      paramStLike.value.set("2");
    } else {
      paramStLike.value.set("1");
    }
    paramStDoLikeReqDoPolyLikeBusiReqData = new FeedCloudCommon.StCommonExt();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramStLike);
    paramStDoLikeReqDoPolyLikeBusiReqData.mapInfo.set(localArrayList);
    this.mReq.extInfo.set(paramStDoLikeReqDoPolyLikeBusiReqData);
    this.mStFeed = paramStFeed;
    this.mIsPraise = paramBoolean3;
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudWrite.StDoLikeRsp localStDoLikeRsp = new FeedCloudWrite.StDoLikeRsp();
    try
    {
      localStDoLikeRsp.mergeFrom(paramArrayOfByte);
      return localStDoLikeRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStDoLikeRsp;
  }
  
  public String getCmdName()
  {
    if (this.mIsReward) {
      return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoReward";
    }
    return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoLike";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
  
  public FeedCloudMeta.StFeed getStFeed()
  {
    return this.mStFeed;
  }
  
  public boolean isPraise()
  {
    return this.mIsPraise;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest
 * JD-Core Version:    0.7.0.1
 */