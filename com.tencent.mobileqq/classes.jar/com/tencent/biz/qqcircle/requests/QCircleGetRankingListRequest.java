package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.ByteStringMicro;
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
    localStGetRankingListRsp.mergeFrom(paramArrayOfByte);
    return localStGetRankingListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetRankingList";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetRankingListRequest
 * JD-Core Version:    0.7.0.1
 */