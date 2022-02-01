package com.tencent.mobileqq.app.handler.receivesuccess;

import QQService.SvcReqMSFLoginNotify;
import com.tencent.biz.qrcode.logindev.LoginDevicesManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class StatSvcSvcReqMSFLoginNotify
{
  public static void a(MessageHandler paramMessageHandler, FromServiceMsg paramFromServiceMsg)
  {
    if ("StatSvc.SvcReqMSFLoginNotify".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      paramFromServiceMsg = (SvcReqMSFLoginNotify)paramMessageHandler.decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcReqMSFLoginNotify", new SvcReqMSFLoginNotify());
      if (paramFromServiceMsg != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("SvcReqMSFLoginNotify status:");
          ((StringBuilder)localObject).append(paramFromServiceMsg.cStatus);
          ((StringBuilder)localObject).append("iPlatform:");
          ((StringBuilder)localObject).append(paramFromServiceMsg.iPlatform);
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = (RegisterProxySvcPackHandler)paramMessageHandler.n.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
        byte b;
        if ((paramFromServiceMsg.iPlatform == 110L) && (paramFromServiceMsg.cTablet == 1))
        {
          if (paramFromServiceMsg.cStatus == 1)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("Q.msg.MessageHandler", 4, "ipad online now");
            }
            paramMessageHandler.p();
            b = 1;
          }
          else
          {
            if (paramFromServiceMsg.cStatus == 2)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("Q.msg.MessageHandler", 4, "ipad offline now");
              }
              paramMessageHandler.g(1);
            }
            b = 0;
          }
          ((RegisterProxySvcPackHandler)localObject).c(b);
          paramMessageHandler.a(paramFromServiceMsg, b, 1);
        }
        else
        {
          int i;
          if (paramFromServiceMsg.iPlatform == 1029L)
          {
            if (paramFromServiceMsg.cStatus == 1)
            {
              b = 1;
            }
            else
            {
              i = paramFromServiceMsg.cStatus;
              b = 0;
            }
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("mac online push status:");
              localStringBuilder.append(b);
              localStringBuilder.append(",cDataline:");
              localStringBuilder.append(1);
              QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
            }
            ((RegisterProxySvcPackHandler)localObject).b(b);
            ((RegisterProxySvcPackHandler)localObject).h(b);
            paramMessageHandler.a(paramFromServiceMsg, b, 0);
          }
          else if (paramFromServiceMsg.iClientType == 78082L)
          {
            if (paramFromServiceMsg.cStatus == 1)
            {
              i = 1;
            }
            else
            {
              i = paramFromServiceMsg.cStatus;
              i = 0;
            }
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("watch online push status:");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(",cDataline:");
              ((StringBuilder)localObject).append(1);
              QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
        paramMessageHandler.notifyUI(6016, true, new Object[] { Byte.valueOf((byte)((LoginDevicesManager)paramMessageHandler.n.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER)).a(paramFromServiceMsg.vecInstanceList)) });
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "RequestPushStatus ret, but data is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.StatSvcSvcReqMSFLoginNotify
 * JD-Core Version:    0.7.0.1
 */