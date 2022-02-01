package com.tencent.mobileqq.app.handler.receivesuccess;

import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class AccostSvcReqDeleteBlackList
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("AccostSvc.ReqDeleteBlackList".equals(paramFromServiceMsg.getServiceCmd()))
    {
      String str = paramToServiceMsg.extraData.getString("deleteUin");
      int i = paramToServiceMsg.extraData.getInt("fromType");
      if (paramFromServiceMsg.getResultCode() == 1000) {
        paramMessageHandler.b(str);
      }
      boolean bool;
      if (paramFromServiceMsg.getResultCode() == 1000) {
        bool = true;
      } else {
        bool = false;
      }
      paramMessageHandler.notifyUI(6002, bool, new Object[] { str, Integer.valueOf(i) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.AccostSvcReqDeleteBlackList
 * JD-Core Version:    0.7.0.1
 */