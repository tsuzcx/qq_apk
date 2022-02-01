package com.tencent.mobileqq.app.handler.receivesuccess;

import MessageSvcPack.SvcResponseSetRoamMsg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class SetRoamMsgResp
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      paramToServiceMsg = (SvcResponseSetRoamMsg)paramObject;
      boolean bool;
      if ((paramToServiceMsg != null) && (paramToServiceMsg.cReplyCode == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      paramMessageHandler.a(1005, bool, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.SetRoamMsgResp
 * JD-Core Version:    0.7.0.1
 */