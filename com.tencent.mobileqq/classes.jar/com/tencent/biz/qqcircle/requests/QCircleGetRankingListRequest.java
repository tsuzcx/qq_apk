package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudRead.StGetRankingListReq;
import feedcloud.FeedCloudRead.StGetRankingListRsp;
import qqcircle.QQCircleFeedBase.StGetRankingListBusiReqData;

public class QCircleGetRankingListRequest
  extends QCircleBaseRequest
{
  private FeedCloudRead.StGetRankingListReq mReq = new FeedCloudRead.StGetRankingListReq();
  
  public QCircleGetRankingListRequest(int paramInt, String paramString)
  {
    this.mReq.listType.set(5);
    this.mReq.count.set(paramInt);
    this.mReq.listTime.set((int)(System.currentTimeMillis() / 1000L));
    QQCircleFeedBase.StGetRankingListBusiReqData localStGetRankingListBusiReqData = new QQCircleFeedBase.StGetRankingListBusiReqData();
    localStGetRankingListBusiReqData.tagName.set(paramString);
    this.mReq.busiReqData.set(ByteStringMicro.copyFrom(localStGetRankingListBusiReqData.toByteArray()));
  }
  
  public QCircleGetRankingListRequest(String paramString)
  {
    this(3, paramString);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetRankingListRsp localStGetRankingListRsp = new FeedCloudRead.StGetRankingListRsp();
    try
    {
      localStGetRankingListRsp.mergeFrom(paramArrayOfByte);
      return localStGetRankingListRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetRankingListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetRankingList";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetRankingListRequest
 * JD-Core Version:    0.7.0.1
 */