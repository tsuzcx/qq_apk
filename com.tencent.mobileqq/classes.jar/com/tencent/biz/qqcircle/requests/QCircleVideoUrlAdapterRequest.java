package com.tencent.biz.qqcircle.requests;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StVideo;
import mqq.app.AppRuntime;
import qqcircle.QQCircleVideourlexchange.StGetVideoAdaptReq;
import qqcircle.QQCircleVideourlexchange.StGetVideoAdaptRsp;

public class QCircleVideoUrlAdapterRequest
  extends QCircleBaseRequest
{
  private final QQCircleVideourlexchange.StGetVideoAdaptReq mReq = new QQCircleVideourlexchange.StGetVideoAdaptReq();
  
  public QCircleVideoUrlAdapterRequest(FeedCloudMeta.StVideo paramStVideo)
  {
    this.mReq.videos.add(paramStVideo);
    this.mReq.userID.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleVideourlexchange.StGetVideoAdaptRsp localStGetVideoAdaptRsp = new QQCircleVideourlexchange.StGetVideoAdaptRsp();
    localStGetVideoAdaptRsp.mergeFrom(paramArrayOfByte);
    return localStGetVideoAdaptRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.videourlexchange.VideoURLExchange.GetVideoAdaptInfo";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleVideoUrlAdapterRequest
 * JD-Core Version:    0.7.0.1
 */