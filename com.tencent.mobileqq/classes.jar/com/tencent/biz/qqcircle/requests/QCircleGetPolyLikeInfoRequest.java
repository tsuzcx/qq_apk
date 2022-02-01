package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import feedcloud.FeedCloudRead.StGetBusiInfoReq;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StBusiInfoReqData;

public class QCircleGetPolyLikeInfoRequest
  extends QCircleBaseRequest
{
  public final FeedCloudRead.StGetBusiInfoReq mReq = new FeedCloudRead.StGetBusiInfoReq();
  
  public QCircleGetPolyLikeInfoRequest()
  {
    QQCircleFeedBase.StBusiInfoReqData localStBusiInfoReqData = new QQCircleFeedBase.StBusiInfoReqData();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(0L));
    localStBusiInfoReqData.rewardInfo.set(localArrayList);
    this.mReq.busiReqData.set(ByteStringMicro.copyFrom(localStBusiInfoReqData.toByteArray()));
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetBusiInfoRsp localStGetBusiInfoRsp = new FeedCloudRead.StGetBusiInfoRsp();
    try
    {
      localStGetBusiInfoRsp.mergeFrom(paramArrayOfByte);
      return localStGetBusiInfoRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetBusiInfoRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetRewardInfo";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
  
  public byte[] getRequestByteKey()
  {
    return new FeedCloudRead.StGetBusiInfoReq().toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetPolyLikeInfoRequest
 * JD-Core Version:    0.7.0.1
 */