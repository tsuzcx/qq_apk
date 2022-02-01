package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.qphone.base.remote.FromServiceMsg;

public class StreamSvrRespUploadStreamMsg
{
  public static void a(MessageHandler paramMessageHandler, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("StreamSvr.RespUploadStreamMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject == null)
      {
        paramMessageHandler.notifyUI(3011, false, null);
        return;
      }
      paramMessageHandler.notifyUI(3011, true, new Object[] { (MessageFactoryReceiver.UploadStreamStruct)paramObject });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.StreamSvrRespUploadStreamMsg
 * JD-Core Version:    0.7.0.1
 */