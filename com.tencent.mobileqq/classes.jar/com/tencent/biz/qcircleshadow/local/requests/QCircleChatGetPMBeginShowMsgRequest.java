package com.tencent.biz.qcircleshadow.local.requests;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.QQCirclePrivateMsgAIO.StGetPMBeginShowMsgReq;
import qqcircle.QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp;

public class QCircleChatGetPMBeginShowMsgRequest
  extends QCircleBaseRequest
{
  private QQCirclePrivateMsgAIO.StGetPMBeginShowMsgReq mReq = new QQCirclePrivateMsgAIO.StGetPMBeginShowMsgReq();
  
  public QCircleChatGetPMBeginShowMsgRequest(String paramString)
  {
    this.mReq.userId.set(paramString);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp localStGetPMBeginShowMsgRsp = new QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp();
    localStGetPMBeginShowMsgRsp.mergeFrom(paramArrayOfByte);
    return localStGetPMBeginShowMsgRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleprivatemsgaio.CirclePrivateMsgAio.GetPMBeginShowMsgReq";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.requests.QCircleChatGetPMBeginShowMsgRequest
 * JD-Core Version:    0.7.0.1
 */