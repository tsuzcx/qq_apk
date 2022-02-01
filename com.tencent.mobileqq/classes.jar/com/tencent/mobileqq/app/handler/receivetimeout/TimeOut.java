package com.tencent.mobileqq.app.handler.receivetimeout;

import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.handler.receivesuccess.InfoSyncResp;
import com.tencent.mobileqq.app.handler.receivesuccess.MsgProxyCmdResp;
import com.tencent.mobileqq.app.handler.receivesuccess.SendClientMsgResp;
import com.tencent.mobileqq.app.message.AbsSubAccountMessageProcessor;
import com.tencent.mobileqq.app.message.ProcessorDispatcher;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class TimeOut
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<<---handleTimeOut serviceCmd:");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramFromServiceMsg.getServiceCmd();
    if (ProcessorDispatcher.a().containsKey(localObject))
    {
      paramMessageHandler.b((String)localObject, paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("MessageSvc.PbGetMsg".equalsIgnoreCase((String)localObject))
    {
      paramMessageHandler.b(paramToServiceMsg);
      return;
    }
    if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase((String)localObject))
    {
      paramMessageHandler.e(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("TransService.ReqGetSign".equalsIgnoreCase((String)localObject))
    {
      paramMessageHandler.d(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("MessageSvc.PbSendMsg".equalsIgnoreCase((String)localObject))
    {
      paramMessageHandler.f(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0xa89".equalsIgnoreCase((String)localObject))
    {
      paramMessageHandler.p(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("AccostSvc.ClientMsg".equalsIgnoreCase((String)localObject))
    {
      SendClientMsgResp.a(paramMessageHandler, paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("PbMessageSvc.PbUnReadMsgSeq".equalsIgnoreCase((String)localObject))
    {
      if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null))
      {
        if ("getThirdQQUnreadNum".equals(paramToServiceMsg.extraData.getString("action")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<<---handle timeout - get thirdqq unread number");
          }
          paramMessageHandler.C().a(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        paramMessageHandler.l(paramToServiceMsg, paramFromServiceMsg);
      }
    }
    else
    {
      if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase((String)localObject))
      {
        paramMessageHandler.g(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("MessageSvc.DelRoamMsg".equalsIgnoreCase((String)localObject))
      {
        paramMessageHandler.i(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ((!"RegPrxySvc.infoLogin".equalsIgnoreCase((String)localObject)) && (!"RegPrxySvc.getOffMsg".equalsIgnoreCase((String)localObject)))
      {
        if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase((String)localObject))
        {
          paramMessageHandler.o(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("RegPrxySvc.infoSync".equalsIgnoreCase((String)localObject))
        {
          InfoSyncResp.a(paramMessageHandler, paramToServiceMsg, paramFromServiceMsg, null);
          return;
        }
        if ("MessageSvc.PbReceiptRead".equalsIgnoreCase((String)localObject)) {
          paramMessageHandler.q(paramToServiceMsg, paramFromServiceMsg);
        }
      }
      else
      {
        MsgProxyCmdResp.a(paramMessageHandler, paramFromServiceMsg, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivetimeout.TimeOut
 * JD-Core Version:    0.7.0.1
 */