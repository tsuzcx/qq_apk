package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StVideo;
import qqcircle.QQCircleVideourlexchange.StGetVideoAdaptReq;
import qqcircle.QQCircleVideourlexchange.StGetVideoAdaptRsp;

public class QCircleVideoUrlAdapterRequest
  extends QCircleBaseRequest
{
  private final QQCircleVideourlexchange.StGetVideoAdaptReq mReq = new QQCircleVideourlexchange.StGetVideoAdaptReq();
  
  public QCircleVideoUrlAdapterRequest(FeedCloudMeta.StVideo paramStVideo)
  {
    this.mReq.videos.add(paramStVideo);
    this.mReq.userID.set(HostDataTransUtils.getAccount());
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleVideourlexchange.StGetVideoAdaptRsp localStGetVideoAdaptRsp = new QQCircleVideourlexchange.StGetVideoAdaptRsp();
    try
    {
      localStGetVideoAdaptRsp.mergeFrom(paramArrayOfByte);
      return localStGetVideoAdaptRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetVideoAdaptRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.videourlexchange.VideoURLExchange.GetVideoAdaptInfo";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleVideoUrlAdapterRequest
 * JD-Core Version:    0.7.0.1
 */