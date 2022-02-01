package com.tencent.biz.qcircleshadow.local.requests;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoFollowReq;
import feedcloud.FeedCloudWrite.StDoFollowRsp;

public class QCircleDoFollowRequest
  extends QCircleBaseRequest
{
  private FeedCloudWrite.StDoFollowReq mRequest = new FeedCloudWrite.StDoFollowReq();
  
  public QCircleDoFollowRequest(FeedCloudMeta.StUser paramStUser, int paramInt, FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    this(paramStUser, paramInt, paramStCommonExt, false);
  }
  
  public QCircleDoFollowRequest(FeedCloudMeta.StUser paramStUser, int paramInt, FeedCloudCommon.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    this.mRequest.user.set(paramStUser);
    this.mRequest.followType.set(paramInt);
    if (paramStCommonExt != null) {
      this.mRequest.extInfo.set(paramStCommonExt);
    }
    paramStUser = this.mRequest.followMethod;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramStUser.set(paramInt);
      return;
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudWrite.StDoFollowRsp localStDoFollowRsp = new FeedCloudWrite.StDoFollowRsp();
    localStDoFollowRsp.mergeFrom(paramArrayOfByte);
    return localStDoFollowRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoFollow";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.requests.QCircleDoFollowRequest
 * JD-Core Version:    0.7.0.1
 */