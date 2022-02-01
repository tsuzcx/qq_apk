package com.tencent.mobileqq.app.handler.receivesuccess;

import AccostSvc.RespClientMsg;
import AccostSvc.RespHeader;
import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class SendClientMsgResp
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    long l3 = paramToServiceMsg.extraData.getLong("to");
    long l4 = paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append(l3);
    paramToServiceMsg.append("");
    paramToServiceMsg = paramToServiceMsg.toString();
    paramMessageHandler.n.getMessageFacade().a(paramToServiceMsg, 1001, l2, 32768, paramFromServiceMsg.getResultCode());
    paramMessageHandler.a(3001, false, new Object[] { String.valueOf(l3), Integer.valueOf(1001), Integer.valueOf(0), null, Long.valueOf(l4), Long.valueOf(l2) });
    if ((480000L == l4) && (paramMessageHandler.b(l1) != null)) {
      paramMessageHandler.c(l1);
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("AccostSvc.ClientMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      paramObject = (RespClientMsg)paramObject;
      if (paramObject == null)
      {
        a(paramMessageHandler, paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      paramToServiceMsg.extraData.getLong("startTime", 0L);
      long l2 = paramToServiceMsg.extraData.getLong("msgSeq");
      long l1 = paramToServiceMsg.extraData.getLong("uniseq");
      long l3 = paramToServiceMsg.extraData.getLong("to");
      long l4 = paramToServiceMsg.extraData.getLong("timeOut");
      paramMessageHandler.c(l2);
      if (paramObject.stHeader.eReplyCode == 0)
      {
        paramMessageHandler.n.getMsgCache().b(String.valueOf(paramToServiceMsg.extraData.getLong("to")), 1001, l1);
        l2 = paramToServiceMsg.extraData.getLong("to");
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append(l1);
        paramToServiceMsg.append("");
        paramMessageHandler.notifyUI(6003, true, new String[] { String.valueOf(l2), paramToServiceMsg.toString() });
        return;
      }
      int i = paramObject.stHeader.eReplyCode;
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append(l3);
      paramToServiceMsg.append("");
      paramToServiceMsg = paramToServiceMsg.toString();
      paramMessageHandler.n.getMessageFacade().a(paramToServiceMsg, 1001, l1, 32768, paramFromServiceMsg.getResultCode());
      paramMessageHandler.a(3001, false, new Object[] { String.valueOf(l3), Integer.valueOf(1001), Integer.valueOf(i), null, Long.valueOf(l4), Long.valueOf(l1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.SendClientMsgResp
 * JD-Core Version:    0.7.0.1
 */