package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudRead.StGetFollowTagListReq;
import feedcloud.FeedCloudRead.StGetFollowTagListRsp;

public class QCircleFollowTagListRequest
  extends QCircleBaseRequest
{
  private int mListNum = 20;
  public final FeedCloudRead.StGetFollowTagListReq mRequest = new FeedCloudRead.StGetFollowTagListReq();
  
  public QCircleFollowTagListRequest(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      this.mRequest.attachInfo.set(paramString1);
    }
    this.mRequest.count.set(this.mListNum);
    this.mRequest.userId.set(paramString2);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetFollowTagListRsp localStGetFollowTagListRsp = new FeedCloudRead.StGetFollowTagListRsp();
    try
    {
      localStGetFollowTagListRsp.mergeFrom(paramArrayOfByte);
      return localStGetFollowTagListRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetFollowTagListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFollowTagList";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleFollowTagListRequest
 * JD-Core Version:    0.7.0.1
 */