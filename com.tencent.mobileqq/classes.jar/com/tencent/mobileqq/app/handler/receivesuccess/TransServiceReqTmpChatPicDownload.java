package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class TransServiceReqTmpChatPicDownload
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject == null)
      {
        paramMessageHandler.d(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      paramMessageHandler.a(paramToServiceMsg, 3012, true, new Object[] { paramObject });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.TransServiceReqTmpChatPicDownload
 * JD-Core Version:    0.7.0.1
 */