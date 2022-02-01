package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

final class MessageSvcPbGetGroupMsg$1
  implements Runnable
{
  MessageSvcPbGetGroupMsg$1(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive,cost:");
      localStringBuilder.append(System.currentTimeMillis() - BaseMessageManagerForTroopAndDisc.f);
      QLog.d("Q.msg.MessageHandler.trooptroop_pull_msg", 2, localStringBuilder.toString());
    }
    try
    {
      this.a.a(this.b, this.c, this.d, false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgResp_PB exception ! ", localException);
      }
      this.a.m(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MessageSvcPbGetGroupMsg.1
 * JD-Core Version:    0.7.0.1
 */