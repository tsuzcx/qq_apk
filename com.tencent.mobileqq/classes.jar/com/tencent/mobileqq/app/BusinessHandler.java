package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public abstract class BusinessHandler
  extends BaseBusinessHandler
{
  public final AppInterface a;
  public final QQAppInterface b;
  
  public BusinessHandler(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (this.b = ((QQAppInterface)paramAppInterface);; this.b = null)
    {
      this.a = paramAppInterface;
      return;
    }
  }
  
  public BusinessHandler(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.a = paramQQAppInterface;
  }
  
  public static MessageMicro a(String paramString, byte[] paramArrayOfByte, Class paramClass)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramArrayOfByte = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom(paramArrayOfByte);
      if ((!paramArrayOfByte.uint32_result.has()) || (paramArrayOfByte.uint32_result.get() != 0) || (!paramArrayOfByte.bytes_bodybuffer.has()) || (paramArrayOfByte.bytes_bodybuffer.get() == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e(paramString, 2, "sso check fail " + paramArrayOfByte.uint32_result.get());
        }
        return null;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e(paramString, 2, "merge fail " + paramArrayOfByte.toString());
      }
      return null;
    }
    try
    {
      paramClass = (MessageMicro)paramClass.newInstance();
      paramClass.mergeFrom(paramArrayOfByte.bytes_bodybuffer.get().toByteArray());
      return paramClass;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e(paramString, 2, "rspBody merge fail " + paramArrayOfByte.toString());
      }
      return null;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public List a(int paramInt)
  {
    return this.a.getBusinessObserver(paramInt);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.a.sendToService(paramToServiceMsg);
  }
  
  protected boolean a(FromServiceMsg paramFromServiceMsg)
  {
    return (!paramFromServiceMsg.isSuccess()) && ((paramFromServiceMsg.getServiceCmd().equals("EncounterSvc.ReqGetEncounter")) || (paramFromServiceMsg.getServiceCmd().equals("RoamClientSvr.GetQualify")) || (paramFromServiceMsg.getServiceCmd().equals("NeighborSvc.ReqGetPoint")));
  }
  
  protected final boolean a(ToServiceMsg paramToServiceMsg)
  {
    boolean bool = false;
    if (paramToServiceMsg != null) {
      bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
    }
    return bool;
  }
  
  protected void b(FromServiceMsg paramFromServiceMsg)
  {
    if (a(paramFromServiceMsg))
    {
      if (QLog.isColorLevel()) {
        QLog.d("msgCmdFilter", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + c());
      }
      ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), c(), 1000277, "[地点漫游]拉取后台数据失败" + paramFromServiceMsg.getServiceCmd(), true);
    }
  }
  
  public final void b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      this.a.sendToService(paramToServiceMsg);
    }
  }
  
  public String c()
  {
    return this.a.getCurrentAccountUin();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BusinessHandler
 * JD-Core Version:    0.7.0.1
 */