package com.tencent.biz.qqcircle.requests;

import bjdm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import qqcircle.QQCircleBase.StAppInfo;
import qqcircle.QQCircleBase.StNetworkInfo;
import qqcircle.QQCircleReport.StHeartbeatSignalReq;
import qqcircle.QQCircleReport.StHeartbeatSignalRsp;
import tzy;

public class QCircleHeartbeatSignalReportRequest
  extends QCircleBaseRequest
{
  private QQCircleReport.StHeartbeatSignalReq mReq = new QQCircleReport.StHeartbeatSignalReq();
  
  public QCircleHeartbeatSignalReportRequest(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    this.mReq.uin.set(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    this.mReq.interval_time_ms.set(paramLong);
    this.mReq.sig_optype.set(paramInt);
    Object localObject = new QQCircleBase.StAppInfo();
    ((QQCircleBase.StAppInfo)localObject).app_version.set("8.3.5.4555");
    ((QQCircleBase.StAppInfo)localObject).qua.set(bjdm.a());
    ((QQCircleBase.StAppInfo)localObject).platform.set("android");
    this.mReq.app_info.set((MessageMicro)localObject);
    localObject = new QQCircleBase.StNetworkInfo();
    ((QQCircleBase.StNetworkInfo)localObject).network_type.set(tzy.b());
    this.mReq.network_info.set((MessageMicro)localObject);
    localObject = new ArrayList();
    if (paramArrayOfByte != null) {
      ((ArrayList)localObject).add(tzy.a("SessionID", paramArrayOfByte));
    }
    this.mReq.byteExtinfo.set((List)localObject);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleReport.StHeartbeatSignalRsp localStHeartbeatSignalRsp = new QQCircleReport.StHeartbeatSignalRsp();
    localStHeartbeatSignalRsp.mergeFrom(paramArrayOfByte);
    return localStHeartbeatSignalRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.circlereport.clientreport.ClientReport.HeartbeatSignal";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleHeartbeatSignalReportRequest
 * JD-Core Version:    0.7.0.1
 */