package com.tencent.mobileqq.app.handler.receivesuccess;

import MessageSvcPack.SvcResponsePullDisMsgSeq;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class MsgProxyDisMsgSeq
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("RegPrxySvc.PullDisMsgSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      paramObject = (SvcResponsePullDisMsgSeq)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyDisMsgSeq.");
      }
      paramMessageHandler.f(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MsgProxyDisMsgSeq
 * JD-Core Version:    0.7.0.1
 */