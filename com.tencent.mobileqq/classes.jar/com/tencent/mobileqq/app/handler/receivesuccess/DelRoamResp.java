package com.tencent.mobileqq.app.handler.receivesuccess;

import MessageSvcPack.SvcResponseDelRoamMsg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class DelRoamResp
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      paramToServiceMsg = (SvcResponseDelRoamMsg)paramObject;
      boolean bool;
      if ((paramToServiceMsg != null) && (paramToServiceMsg.cReplyCode == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleDelRoamResp isSuccess = ");
        paramFromServiceMsg.append(bool);
        paramFromServiceMsg.append(" , cReplyCode = ");
        if (paramToServiceMsg == null) {
          paramToServiceMsg = "null";
        } else {
          paramToServiceMsg = Byte.valueOf(paramToServiceMsg.cReplyCode);
        }
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.d("Q.msg.MessageHandler", 2, paramFromServiceMsg.toString());
      }
      paramMessageHandler.a(1003, bool, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.DelRoamResp
 * JD-Core Version:    0.7.0.1
 */