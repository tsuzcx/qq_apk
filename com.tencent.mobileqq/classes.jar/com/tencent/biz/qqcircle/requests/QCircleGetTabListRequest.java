package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudRead.StGetBusiInfoReq;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StBusiInfoData;
import qqcircle.QQCircleFeedBase.StBusiInfoReqData;
import uwz;

public class QCircleGetTabListRequest
  extends QCircleBaseRequest
{
  private boolean mJustQureyRewardInfo;
  public final FeedCloudRead.StGetBusiInfoReq mReq = new FeedCloudRead.StGetBusiInfoReq();
  
  public QCircleGetTabListRequest(FeedCloudMeta.StGPSV2 paramStGPSV2)
  {
    QQCircleFeedBase.StBusiInfoReqData localStBusiInfoReqData = new QQCircleFeedBase.StBusiInfoReqData();
    if (uwz.a().a() != null) {
      localStBusiInfoReqData.busiMap.set(uwz.a().a().busiMap.get());
    }
    if (paramStGPSV2 != null) {
      localStBusiInfoReqData.gpsInfo.set(paramStGPSV2);
    }
    paramStGPSV2 = new ArrayList();
    paramStGPSV2.add(Long.valueOf(0L));
    localStBusiInfoReqData.rewardInfo.set(paramStGPSV2);
    this.mReq.busiReqData.set(ByteStringMicro.copyFrom(localStBusiInfoReqData.toByteArray()));
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetBusiInfoRsp localStGetBusiInfoRsp = new FeedCloudRead.StGetBusiInfoRsp();
    localStGetBusiInfoRsp.mergeFrom(paramArrayOfByte);
    return localStGetBusiInfoRsp;
  }
  
  public String getCmdName()
  {
    if (this.mJustQureyRewardInfo) {
      return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetRewardInfo";
    }
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetBusiInfo";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
  
  public byte[] getRequestByteKey()
  {
    return new FeedCloudRead.StGetBusiInfoReq().toByteArray();
  }
  
  public void setJustQueryRewardInfo(boolean paramBoolean)
  {
    this.mJustQureyRewardInfo = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest
 * JD-Core Version:    0.7.0.1
 */