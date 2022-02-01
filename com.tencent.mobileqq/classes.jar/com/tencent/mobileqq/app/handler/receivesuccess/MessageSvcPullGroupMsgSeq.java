package com.tencent.mobileqq.app.handler.receivesuccess;

import MessageSvcPack.SvcResponsePullGroupMsgSeq;
import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.AbsSubAccountMessageProcessor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class MessageSvcPullGroupMsgSeq
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ((("MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(str)) || ("PbMessageSvc.PbUnReadMsgSeq".equalsIgnoreCase(str))) && (paramToServiceMsg != null) && (paramToServiceMsg.extraData != null))
    {
      if ("getThirdQQUnreadNum".equals(paramToServiceMsg.extraData.getString("action")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<<---handle response - get thirdqq unread number");
        }
        try
        {
          paramMessageHandler.C().b(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "handle response - get thirdqq unread number exception ! ", paramObject);
          }
          paramMessageHandler.C().b(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
      }
      try
      {
        if (paramMessageHandler.isPbReq(paramToServiceMsg))
        {
          paramMessageHandler.i(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        paramMessageHandler.a(paramToServiceMsg, paramFromServiceMsg, (SvcResponsePullGroupMsgSeq)paramObject);
        return;
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgNumResp exception ! ", paramObject);
        }
        paramMessageHandler.k(paramToServiceMsg, paramFromServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MessageSvcPullGroupMsgSeq
 * JD-Core Version:    0.7.0.1
 */