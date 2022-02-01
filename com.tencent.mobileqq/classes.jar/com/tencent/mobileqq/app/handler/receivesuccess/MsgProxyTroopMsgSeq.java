package com.tencent.mobileqq.app.handler.receivesuccess;

import MessageSvcPack.SvcResponsePullGroupMsgSeq;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;

public class MsgProxyTroopMsgSeq
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("RegPrxySvc.PullGroupMsgSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      long l = System.currentTimeMillis();
      paramObject = (SvcResponsePullGroupMsgSeq)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyTroopMsgSeq.");
      }
      paramMessageHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      MsgAutoMonitorUtil.getInstance().addProxySeqTime_Grp(System.currentTimeMillis() - l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MsgProxyTroopMsgSeq
 * JD-Core Version:    0.7.0.1
 */