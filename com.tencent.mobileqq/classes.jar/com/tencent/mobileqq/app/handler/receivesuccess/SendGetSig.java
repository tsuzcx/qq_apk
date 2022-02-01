package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.SigStruct;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class SendGetSig
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("TransService.ReqGetSign".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      paramObject = (MessageFactoryReceiver.SigStruct)paramObject;
      if (paramObject == null)
      {
        paramMessageHandler.c(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      ((IPicTransFile)paramMessageHandler.n.getRuntimeService(IPicTransFile.class, "")).setSig(paramObject.a, paramObject.b);
      paramMessageHandler.a(5002, true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.SendGetSig
 * JD-Core Version:    0.7.0.1
 */