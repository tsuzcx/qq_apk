package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class QCircleGetNewUserPymkPageRequest
  extends QCircleBaseRequest
{
  public FeedCloudRead.StGetFeedListReq mRequest = new FeedCloudRead.StGetFeedListReq();
  public String mTransferData;
  
  public QCircleGetNewUserPymkPageRequest(int paramInt1, int paramInt2)
  {
    this.mRequest.source.set(paramInt1);
    QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
    localStFeedListBusiReqData.pymkSourcePage.set(paramInt2);
    this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(localStFeedListBusiReqData.toByteArray()));
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
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetNewUserPymkPageFeedList";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
  
  public byte[] getRequestByteKey()
  {
    return getRequestByteData();
  }
  
  public void setTransferData(String paramString)
  {
    if (this.mRequest != null)
    {
      QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
      localStFeedListBusiReqData.schemaTrans.set(paramString);
      this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(localStFeedListBusiReqData.toByteArray()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetNewUserPymkPageRequest
 * JD-Core Version:    0.7.0.1
 */