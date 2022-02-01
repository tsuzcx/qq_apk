package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.List;
import qqcircle.QQCirclePrivateMsgShow.StBatchGetPMGiftInfoReq;
import qqcircle.QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp;

public class QCircleChatBatchGetPMGiftInfoRequest
  extends QCircleBaseRequest
{
  private QQCirclePrivateMsgShow.StBatchGetPMGiftInfoReq mReq = new QQCirclePrivateMsgShow.StBatchGetPMGiftInfoReq();
  
  public QCircleChatBatchGetPMGiftInfoRequest(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.mReq.uids.set(paramList);
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp localStBatchGetPMGiftInfoRsp = new QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp();
    try
    {
      localStBatchGetPMGiftInfoRsp.mergeFrom(paramArrayOfByte);
      return localStBatchGetPMGiftInfoRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStBatchGetPMGiftInfoRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleprivatemsgshow.CirclePrivateMsgShow.BatchGetPMGiftInfo";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleChatBatchGetPMGiftInfoRequest
 * JD-Core Version:    0.7.0.1
 */