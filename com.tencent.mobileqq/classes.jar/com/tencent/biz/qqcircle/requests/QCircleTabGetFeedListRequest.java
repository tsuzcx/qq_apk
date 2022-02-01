package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

public class QCircleTabGetFeedListRequest
  extends QCircleBaseRequest
{
  private final QCircleTabGetFeedListRequest.Builder mBuilder;
  public FeedCloudRead.StGetFeedListReq mRequest;
  
  public QCircleTabGetFeedListRequest(QCircleTabGetFeedListRequest.Builder paramBuilder)
  {
    this.mBuilder = paramBuilder;
    this.mRequest = paramBuilder.a();
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetFeedListRsp localStGetFeedListRsp = new FeedCloudRead.StGetFeedListRsp();
    try
    {
      localStGetFeedListRsp.mergeFrom(paramArrayOfByte);
      return localStGetFeedListRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetFeedListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedList";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
  
  public byte[] getRequestByteKey()
  {
    return this.mBuilder.b().toByteArray();
  }
  
  public int getRequestSource()
  {
    return QCircleTabGetFeedListRequest.Builder.a(this.mBuilder).c();
  }
  
  public void setAttachInfo(String paramString)
  {
    QCircleTabGetFeedListRequest.Builder.a(this.mBuilder, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest
 * JD-Core Version:    0.7.0.1
 */