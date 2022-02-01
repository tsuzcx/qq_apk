package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class OnlinePushPbPushGroupMsg
{
  public static void a(MessageHandler paramMessageHandler, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (("OnlinePush.PbPushGroupMsg".equalsIgnoreCase(str)) || ("OnlinePush.PbPushDisMsg".equalsIgnoreCase(str)) || ("OnlinePush.PbC2CMsgSync".equalsIgnoreCase(str)) || ("OnlinePush.PbPushC2CMsg".equalsIgnoreCase(str)) || ("OnlinePush.PbPushBindUinGroupMsg".equalsIgnoreCase(str))) {
      try
      {
        paramMessageHandler.b(paramFromServiceMsg, paramObject);
        return;
      }
      catch (Exception paramMessageHandler)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MessageHandler", 2, "handleMessagePush_PB exception ! ", paramMessageHandler);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.OnlinePushPbPushGroupMsg
 * JD-Core Version:    0.7.0.1
 */