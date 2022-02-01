package com.tencent.mobileqq.app.handler.receivesuccess;

import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class AccostSvcReqInsertBlackList
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("AccostSvc.ReqInsertBlackList".equals(paramFromServiceMsg.getServiceCmd()))
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getString("insertUin");
      if (paramFromServiceMsg.getResultCode() == 1000) {
        paramMessageHandler.b(paramToServiceMsg);
      }
      boolean bool;
      if (paramFromServiceMsg.getResultCode() == 1000) {
        bool = true;
      } else {
        bool = false;
      }
      paramMessageHandler.notifyUI(6001, bool, paramToServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.AccostSvcReqInsertBlackList
 * JD-Core Version:    0.7.0.1
 */