package com.tencent.biz.qqcircle.immersive.personal.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

public class QFSGetFeedListRequest
  extends QCircleBaseRequest
  implements IQFSPersonalFeedRequest
{
  protected FeedCloudRead.StGetFeedListReq mRequest;
  private String uin;
  
  private QFSGetFeedListRequest(FeedCloudRead.StGetFeedListReq paramStGetFeedListReq)
  {
    this.mRequest = paramStGetFeedListReq;
  }
  
  public FeedCloudRead.StGetFeedListRsp decode(byte[] paramArrayOfByte)
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
  
  public String getUin()
  {
    return this.uin;
  }
  
  public void setAttachInfo(String paramString)
  {
    this.mRequest.feedAttchInfo.set(paramString);
  }
  
  public void setRefreshAttachInfo(String paramString)
  {
    QQCircleFeedBase.StFeedListBusiRspData localStFeedListBusiRspData = new QQCircleFeedBase.StFeedListBusiRspData();
    if (!this.mRequest.busiReqData.has()) {
      localStFeedListBusiRspData = new QQCircleFeedBase.StFeedListBusiRspData();
    } else {
      try
      {
        localStFeedListBusiRspData.mergeFrom(this.mRequest.busiReqData.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    localStFeedListBusiRspData.refreshAttachInfo.set(paramString);
    this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(localStFeedListBusiRspData.toByteArray()));
  }
  
  public void setUin(String paramString)
  {
    this.uin = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest
 * JD-Core Version:    0.7.0.1
 */