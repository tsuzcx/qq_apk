package com.tencent.mobileqq.app.handler.receiveerror;

import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.handler.receivesuccess.InfoSyncResp;
import com.tencent.mobileqq.app.handler.receivesuccess.MsgProxyCmdResp;
import com.tencent.mobileqq.app.handler.receivesuccess.SendClientMsgResp;
import com.tencent.mobileqq.app.message.AbsSubAccountMessageProcessor;
import com.tencent.mobileqq.app.message.ProcessorDispatcher;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class Error
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<<---handleError serviceCmd:");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramFromServiceMsg.getServiceCmd();
    if (ProcessorDispatcher.a().containsKey(localObject))
    {
      paramMessageHandler.a((String)localObject, paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ((!"MessageSvc.PbGetMsg".equalsIgnoreCase((String)localObject)) && (!"RegPrxySvc.PbGetMsg".equalsIgnoreCase((String)localObject)))
    {
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
      if ("PbMessageSvc.PbMsgReadedReport".equalsIgnoreCase((String)localObject))
      {
        paramMessageHandler.o(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ((!"MessageSvc.PullGroupMsgSeq".equalsIgnoreCase((String)localObject)) && (!"PbMessageSvc.PbUnReadMsgSeq".equalsIgnoreCase((String)localObject)))
      {
        if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase((String)localObject))
        {
          paramMessageHandler.h(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("MessageSvc.DelRoamMsg".equalsIgnoreCase((String)localObject))
        {
          paramMessageHandler.j(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ((!"RegPrxySvc.infoLogin".equalsIgnoreCase((String)localObject)) && (!"RegPrxySvc.getOffMsg".equalsIgnoreCase((String)localObject)))
        {
          if ("RegPrxySvc.infoSync".equalsIgnoreCase((String)localObject))
          {
            InfoSyncResp.a(paramMessageHandler, paramToServiceMsg, paramFromServiceMsg, null);
            return;
          }
          if ("MessageSvc.PbReceiptRead".equalsIgnoreCase((String)localObject))
          {
            paramMessageHandler.q(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          if ("StreamSvr.UploadStreamMsg".equals(localObject))
          {
            short s = paramToServiceMsg.extraData.getShort("PackSeq");
            paramMessageHandler.notifyUI(3011, false, new Object[] { new MessageFactoryReceiver.UploadStreamStruct(paramToServiceMsg.extraData.getString("filepath"), s, paramToServiceMsg.extraData.getShort("flowLayer"), null, 0) });
          }
        }
        else
        {
          MsgProxyCmdResp.a(paramMessageHandler, paramFromServiceMsg, null);
        }
      }
      else if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null))
      {
        if ("getThirdQQUnreadNum".equals(paramToServiceMsg.extraData.getString("action")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<<---handleError - get thirdqq unread number");
          }
          paramMessageHandler.C().b(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        paramMessageHandler.k(paramToServiceMsg, paramFromServiceMsg);
      }
    }
    else
    {
      if ("RegPrxySvc.PbGetMsg".equalsIgnoreCase((String)localObject))
      {
        paramFromServiceMsg = paramMessageHandler.e;
        com.tencent.mobileqq.app.handler.RegisterProxyHandler.l = true;
      }
      paramMessageHandler.c(paramToServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receiveerror.Error
 * JD-Core Version:    0.7.0.1
 */