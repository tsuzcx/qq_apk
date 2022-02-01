package com.tencent.mobileqq.app.handler.receivesuccess;

import PushNotifyPack.RequestPushNotify;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.AbsSubAccountMessageProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class MessageSvcPushNotify
{
  public static void a(MessageHandler paramMessageHandler, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("MessageSvc.PushNotify".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      boolean bool2;
      String str2;
      if ((paramObject instanceof RequestPushNotify))
      {
        RequestPushNotify localRequestPushNotify = (RequestPushNotify)paramObject;
        paramMessageHandler.a.userActiveStatus = localRequestPushNotify.wUserActive;
        String str1;
        boolean bool1;
        if ((localRequestPushNotify.wGeneralFlag & 0x8) == 8)
        {
          str1 = Long.toString(localRequestPushNotify.lBindedUin);
          if ((localRequestPushNotify.wGeneralFlag & 0x10) == 16) {
            paramMessageHandler.a.getMsgHandler().a().a(localRequestPushNotify);
          }
          bool1 = true;
        }
        else
        {
          str1 = null;
          bool1 = false;
        }
        if (localRequestPushNotify.ping_flag == 1L) {
          paramMessageHandler.a(localRequestPushNotify.lUin, localRequestPushNotify.svrip, paramFromServiceMsg.getRequestSsoSeq());
        }
        if ((localRequestPushNotify.wGeneralFlag & 0x20) == 32) {
          NoDisturbUtil.a(true);
        } else {
          NoDisturbUtil.a(false);
        }
        bool2 = bool1;
        str2 = str1;
        if (QLog.isColorLevel())
        {
          if (bool1) {
            str2 = "SUB_ACCOUNT";
          } else {
            str2 = "Q.msg.MessageHandler";
          }
          QLog.d(str2, 2, String.format("MessageSvc.PushNotify, notify.wUserActive: %d isSubAccount: %s, cmd: %s, wGeneralFlag:%d, bytesServerBuf: %s, ping_flag%d", new Object[] { Integer.valueOf(localRequestPushNotify.wUserActive), Boolean.valueOf(bool1), localRequestPushNotify.strCmd, Integer.valueOf(localRequestPushNotify.wGeneralFlag), localRequestPushNotify.bytes_server_buf, Long.valueOf(localRequestPushNotify.ping_flag) }));
          bool2 = bool1;
          str2 = str1;
        }
      }
      else
      {
        str2 = null;
        bool2 = false;
      }
      if (bool2)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("subaccount push and start get subaccount msg, subUin=");
          paramFromServiceMsg.append(str2);
          QLog.d("SUB_ACCOUNT", 2, paramFromServiceMsg.toString());
        }
        if (str2 != null) {
          ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).loadServerMessage(paramMessageHandler.a, str2, true);
        }
      }
      else if (paramMessageHandler.a.mAutomator.a())
      {
        paramMessageHandler.a(paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MessageSvcPushNotify
 * JD-Core Version:    0.7.0.1
 */