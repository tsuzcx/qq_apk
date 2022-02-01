package com.tencent.mobileqq.app.handler.receivesuccess;

import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbC2CReadedReportResp;
import msf.msgsvc.msg_svc.PbDiscussReadedReportResp;
import msf.msgsvc.msg_svc.PbGroupReadedReportResp;
import msf.msgsvc.msg_svc.PbMsgReadedReportResp;

public class MsgReadReportRespPB
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l;
    if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      l = paramToServiceMsg.extraData.getLong("msgSeq");
      if (paramMessageHandler.a(l) == null) {
        return;
      }
      paramToServiceMsg = new msg_svc.PbMsgReadedReportResp();
    }
    try
    {
      paramToServiceMsg = (msg_svc.PbMsgReadedReportResp)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (QLog.isColorLevel())
      {
        if (paramToServiceMsg.c2c_read_report.result.has())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("<ReadReport_All>C2C replyCode:");
          paramFromServiceMsg.append(paramToServiceMsg.c2c_read_report.result.get());
          paramFromServiceMsg.append("reqSeq:");
          paramFromServiceMsg.append(l);
          QLog.d("Q.msg.MessageHandler", 2, paramFromServiceMsg.toString());
        }
        if ((paramToServiceMsg.dis_read_report.has()) && (((msg_svc.PbDiscussReadedReportResp)paramToServiceMsg.dis_read_report.get(0)).result.has()))
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("<ReadReport_All>Dis replyCode:");
          paramFromServiceMsg.append(((msg_svc.PbDiscussReadedReportResp)paramToServiceMsg.dis_read_report.get(0)).result.get());
          paramFromServiceMsg.append("reqSeq:");
          paramFromServiceMsg.append(l);
          QLog.d("Q.msg.MessageHandler", 2, paramFromServiceMsg.toString());
        }
        if ((paramToServiceMsg.grp_read_report.has()) && (((msg_svc.PbGroupReadedReportResp)paramToServiceMsg.grp_read_report.get(0)).result.has()))
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("<ReadReport_All>GRP replyCode:");
          paramFromServiceMsg.append(((msg_svc.PbGroupReadedReportResp)paramToServiceMsg.grp_read_report.get(0)).result.get());
          paramFromServiceMsg.append(" reqSeq:");
          paramFromServiceMsg.append(l);
          QLog.d("Q.msg.MessageHandler", 2, paramFromServiceMsg.toString());
        }
      }
      paramMessageHandler.a(l);
      return;
    }
    catch (Exception paramMessageHandler)
    {
      label318:
      break label318;
    }
    if (QLog.isColorLevel())
    {
      paramMessageHandler = new StringBuilder();
      paramMessageHandler.append("<ReadReport>handleMsgReadedReportResp_PB : server did not return a valid response,reqSeq ");
      paramMessageHandler.append(l);
      QLog.e("Q.msg.MessageHandler", 2, paramMessageHandler.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MsgReadReportRespPB
 * JD-Core Version:    0.7.0.1
 */