package com.tencent.biz.qcircleshadow.local.requests;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleCounter.GroupInfoReq;
import qqcircle.QQCircleCounter.GroupInfoRsp;

public class QCircleTroopGreyRequest
  extends QCircleBaseRequest
{
  private QQCircleCounter.GroupInfoReq mReq = new QQCircleCounter.GroupInfoReq();
  
  public QCircleTroopGreyRequest(List<Long> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        long l = ((Long)paramList.next()).longValue();
        this.mReq.groupid.add(String.valueOf(l));
      }
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleCounter.GroupInfoRsp localGroupInfoRsp = new QQCircleCounter.GroupInfoRsp();
    localGroupInfoRsp.mergeFrom(paramArrayOfByte);
    return localGroupInfoRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circlecounter.CircleCounter.GetGroupInfo";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.requests.QCircleTroopGreyRequest
 * JD-Core Version:    0.7.0.1
 */