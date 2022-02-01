package com.tencent.mobileqq.activity.qcircle;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import com.tencent.mobileqq.utils.IPUtils;
import com.tencent.qphone.base.util.BaseApplication;
import qqcircle.QQCircleSwitch.GetCircleTabBucketReq;
import qqcircle.QQCircleSwitch.GetCircleTabBucketRsp;

public class QCircleThirdTabConfig$QCircleTabBucketRequest
  extends QCircleBaseRequest
{
  private QQCircleSwitch.GetCircleTabBucketReq mReq = new QQCircleSwitch.GetCircleTabBucketReq();
  
  public QCircleThirdTabConfig$QCircleTabBucketRequest()
  {
    String str = IPUtils.a(BaseApplication.getContext());
    if (str != null) {
      this.mReq.userIp.set(str);
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleSwitch.GetCircleTabBucketRsp localGetCircleTabBucketRsp = new QQCircleSwitch.GetCircleTabBucketRsp();
    try
    {
      localGetCircleTabBucketRsp.mergeFrom(paramArrayOfByte);
      return localGetCircleTabBucketRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localGetCircleTabBucketRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleswitch.CircleSwitch.GetCircleTabBucket";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleThirdTabConfig.QCircleTabBucketRequest
 * JD-Core Version:    0.7.0.1
 */