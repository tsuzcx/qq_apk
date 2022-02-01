package com.tencent.mobileqq.app;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class BusinessHandlerUtil
{
  private static final int MM_APP_ID = 1000277;
  
  protected static void checkReportErrorToMM(FromServiceMsg paramFromServiceMsg, String paramString)
  {
    if (reportErrorToMM(paramFromServiceMsg))
    {
      if (QLog.isColorLevel()) {
        QLog.d("msgCmdFilter", 2, "report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ", error code=" + paramFromServiceMsg.getBusinessFailCode() + ", uin=" + paramString);
      }
      String str = HardCodeUtil.a(2131701341) + paramFromServiceMsg.getServiceCmd();
      ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), paramString, 1000277, str, true);
    }
  }
  
  public static <T extends MessageMicro<T>> T decodeOIDB(String paramString, byte[] paramArrayOfByte, Class<T> paramClass)
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
  
  protected static boolean reportErrorToMM(FromServiceMsg paramFromServiceMsg)
  {
    return (!paramFromServiceMsg.isSuccess()) && ((paramFromServiceMsg.getServiceCmd().equals("EncounterSvc.ReqGetEncounter")) || (paramFromServiceMsg.getServiceCmd().equals("RoamClientSvr.GetQualify")) || (paramFromServiceMsg.getServiceCmd().equals("NeighborSvc.ReqGetPoint")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BusinessHandlerUtil
 * JD-Core Version:    0.7.0.1
 */