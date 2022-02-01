package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class MsgProxyCmdResp
{
  public static void a(MessageHandler paramMessageHandler, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = paramFromServiceMsg.getServiceCmd();
    if (("RegPrxySvc.infoLogin".equalsIgnoreCase(paramObject)) || ("RegPrxySvc.getOffMsg".equalsIgnoreCase(paramObject)))
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        paramMessageHandler.notifyUI(4004, true, null);
        return;
      }
      if ((paramFromServiceMsg.getResultCode() != 1002) && (paramFromServiceMsg.getResultCode() != 1013))
      {
        if (paramFromServiceMsg.getResultCode() == -20009)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleMsgProxyCmdResp request overload protection!");
          }
          paramMessageHandler.notifyUI(4004, false, null);
          paramMessageHandler.notifyUI(4001, false, null);
          paramMessageHandler.notifyUI(4016, false, null);
          paramMessageHandler.notifyUI(4003, false, null);
          paramMessageHandler.notifyUI(4002, false, null);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleMsgProxyCmdResp request error!");
        }
        paramMessageHandler.notifyUI(4004, false, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleMsgProxyCmdResp request timeout!");
      }
      paramMessageHandler.notifyUI(4004, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MsgProxyCmdResp
 * JD-Core Version:    0.7.0.1
 */