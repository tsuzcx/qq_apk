package com.tencent.mobileqq.app.handler.receivesuccess;

import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class MessageSvcPbGetGroupMsg
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("MessageSvc.PbGetGroupMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramToServiceMsg.extraData.getBoolean("key_from_parallel_pull", false))
      {
        ThreadManager.post(new MessageSvcPbGetGroupMsg.1(paramMessageHandler, paramToServiceMsg, paramFromServiceMsg, paramObject), 8, null, false);
        return;
      }
      try
      {
        paramMessageHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject, false);
        return;
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgResp_PB exception ! ", paramObject);
        }
        paramMessageHandler.l(paramToServiceMsg, paramFromServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MessageSvcPbGetGroupMsg
 * JD-Core Version:    0.7.0.1
 */