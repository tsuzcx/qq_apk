package com.tencent.mobileqq.app.handler.receivesuccess;

import PushAdMsg.AdMsgInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.ADParser;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class PushADMessageResp
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("ADMsgSvc.PushMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      paramFromServiceMsg = (AdMsgInfo)paramObject;
      if ((paramFromServiceMsg != null) && (String.valueOf(paramFromServiceMsg.uDstUin).equalsIgnoreCase(paramToServiceMsg.getUin())))
      {
        long l = paramFromServiceMsg.utime;
        paramToServiceMsg = paramFromServiceMsg.strMsgContent;
        if (paramFromServiceMsg.uMsgType == 9)
        {
          paramObject = MessageRecordFactory.a(-2003);
          paramObject.selfuin = paramMessageHandler.a.getCurrentAccountUin();
          paramObject.frienduin = String.valueOf(AppConstants.QQBROADCAST_MSG_UIN);
          paramObject.senderuin = String.valueOf(AppConstants.QQBROADCAST_MSG_UIN);
          paramObject.msg = paramToServiceMsg;
          paramObject.time = l;
          paramObject.msgtype = -2003;
          paramObject.istroop = 0;
          if (!MessageHandlerUtils.a(paramMessageHandler.a, paramObject, false))
          {
            paramMessageHandler.a.getMessageFacade().a(paramObject, paramMessageHandler.a.getCurrentAccountUin());
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("0_");
            paramToServiceMsg.append(String.valueOf(paramFromServiceMsg.uSrcUin));
            paramMessageHandler.a("handlePushADMessageResp", 1000, true, paramToServiceMsg.toString(), 1, true, false, null);
          }
        }
        else if (paramFromServiceMsg.uMsgType == 513)
        {
          int i = ADParser.a(paramToServiceMsg);
          paramObject = ADParser.a(paramToServiceMsg);
          if (i != 0)
          {
            if (i == 1) {
              return;
            }
            if (i != 2) {
              return;
            }
          }
          if ((paramObject != null) && ((paramObject.equals("WAP")) || (paramObject.equals("WAPI")) || (paramObject.equals("TMTWAP")) || (paramObject.equals("TMTWAPI")) || (paramObject.equals("LOCAL"))))
          {
            paramObject = MessageRecordFactory.a(-2004);
            paramObject.selfuin = paramMessageHandler.a.getCurrentAccountUin();
            paramObject.frienduin = String.valueOf(AppConstants.QQBROADCAST_MSG_UIN);
            paramObject.senderuin = String.valueOf(AppConstants.QQBROADCAST_MSG_UIN);
            paramObject.msg = paramToServiceMsg;
            paramObject.time = l;
            paramObject.msgtype = -2004;
            paramObject.istroop = 0;
            if (!MessageHandlerUtils.a(paramMessageHandler.a, paramObject, false))
            {
              paramMessageHandler.a.getMessageFacade().a(paramObject, paramMessageHandler.a.getCurrentAccountUin());
              paramToServiceMsg = new StringBuilder();
              paramToServiceMsg.append("0_");
              paramToServiceMsg.append(String.valueOf(paramFromServiceMsg.uSrcUin));
              paramMessageHandler.a("handlePushADMessageResp", 1000, true, paramToServiceMsg.toString(), 1, true, false, null);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.PushADMessageResp
 * JD-Core Version:    0.7.0.1
 */