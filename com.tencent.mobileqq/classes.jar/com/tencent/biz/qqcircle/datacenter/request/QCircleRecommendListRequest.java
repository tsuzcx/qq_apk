package com.tencent.biz.qqcircle.datacenter.request;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetCloudSealFeedReq;
import feedcloud.FeedCloudRead.StGetCloudSealFeedRsp;

public class QCircleRecommendListRequest
  extends QCircleBaseRequest
{
  public FeedCloudRead.StGetCloudSealFeedReq mRequest = new FeedCloudRead.StGetCloudSealFeedReq();
  
  public QCircleRecommendListRequest(String paramString, FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (paramStCommonExt != null) {
      this.mRequest.extInfo.set(paramStCommonExt);
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.mRequest.attachInfo.set(paramString);
    }
    this.mRequest.listNum.set(50);
  }
  
  public FeedCloudRead.StGetCloudSealFeedRsp decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetCloudSealFeedRsp localStGetCloudSealFeedRsp = new FeedCloudRead.StGetCloudSealFeedRsp();
    try
    {
      localStGetCloudSealFeedRsp.mergeFrom(paramArrayOfByte);
      return localStGetCloudSealFeedRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetCloudSealFeedRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCloudSealFeed";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.datacenter.request.QCircleRecommendListRequest
 * JD-Core Version:    0.7.0.1
 */