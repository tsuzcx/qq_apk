package com.tencent.biz.qcircleshadow.local.requests;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import java.util.List;
import qqcircle.QQCircleCounter.CountInfoReq;
import qqcircle.QQCircleCounter.CountInfoRsp;

public class QCircleGetSimpleCountInfoRequest
  extends QCircleBaseRequest
{
  private QQCircleCounter.CountInfoReq mReq = new QQCircleCounter.CountInfoReq();
  
  public QCircleGetSimpleCountInfoRequest(String paramString)
  {
    FeedCloudCommon.StCommonExt localStCommonExt = new FeedCloudCommon.StCommonExt();
    FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
    localEntry.key.set("target_uin");
    localEntry.value.set(paramString);
    localStCommonExt.mapInfo.get().add(localEntry);
    this.mReq.extInfo.set(localStCommonExt);
    this.mReq.reqType.set(4);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleCounter.CountInfoRsp localCountInfoRsp = new QQCircleCounter.CountInfoRsp();
    localCountInfoRsp.mergeFrom(paramArrayOfByte);
    return localCountInfoRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circlecounter.CircleCounter.GetSimpleCountInfo";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.requests.QCircleGetSimpleCountInfoRequest
 * JD-Core Version:    0.7.0.1
 */