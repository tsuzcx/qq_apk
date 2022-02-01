package com.tencent.biz.qqcircle.immersive.personal.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudRead.StGetMainPageReq;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

public class QFSGetMainPageRequest
  extends QCircleBaseRequest
  implements IQFSPersonalFeedRequest
{
  private final FeedCloudRead.StGetMainPageReq mRequest;
  private String uin;
  
  private QFSGetMainPageRequest(FeedCloudRead.StGetMainPageReq paramStGetMainPageReq)
  {
    this.mRequest = paramStGetMainPageReq;
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetMainPageRsp localStGetMainPageRsp = new FeedCloudRead.StGetMainPageRsp();
    try
    {
      localStGetMainPageRsp.mergeFrom(paramArrayOfByte);
      return localStGetMainPageRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetMainPageRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainpage";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public void setAttachInfo(String paramString)
  {
    this.mRequest.feedAttchInfo.set(paramString);
  }
  
  public void setUin(String paramString)
  {
    this.uin = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageRequest
 * JD-Core Version:    0.7.0.1
 */