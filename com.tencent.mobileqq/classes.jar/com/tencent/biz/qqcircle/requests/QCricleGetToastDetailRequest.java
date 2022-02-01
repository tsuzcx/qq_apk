package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudToastshowsvr.StGetToastDetailReq;
import feedcloud.FeedCloudToastshowsvr.StGetToastDetailRsp;

public class QCricleGetToastDetailRequest
  extends QCircleBaseRequest
{
  FeedCloudToastshowsvr.StGetToastDetailReq mRequest = new FeedCloudToastshowsvr.StGetToastDetailReq();
  
  public QCricleGetToastDetailRequest(String paramString1, String paramString2)
  {
    this.mRequest.userId.set(paramString1);
    this.mRequest.toastId.set(paramString2);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudToastshowsvr.StGetToastDetailRsp localStGetToastDetailRsp = new FeedCloudToastshowsvr.StGetToastDetailRsp();
    try
    {
      localStGetToastDetailRsp.mergeFrom(paramArrayOfByte);
      return localStGetToastDetailRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetToastDetailRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetToastDetail";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCricleGetToastDetailRequest
 * JD-Core Version:    0.7.0.1
 */