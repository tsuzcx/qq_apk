package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class MessageSvcPbGetMsg
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("MessageSvc.PbGetMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      try
      {
        if ((paramMessageHandler.a.mAutomator != null) && (!paramMessageHandler.a.mAutomator.d()))
        {
          paramMessageHandler.h(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        paramMessageHandler.a("c2c_processor").a(1002, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MessageHandler", 2, "handleGetC2CMessageResp_PB exception ! ", paramFromServiceMsg);
        }
        paramMessageHandler.c(paramToServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MessageSvcPbGetMsg
 * JD-Core Version:    0.7.0.1
 */