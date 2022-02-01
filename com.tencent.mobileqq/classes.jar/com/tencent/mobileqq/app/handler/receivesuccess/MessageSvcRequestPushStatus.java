package com.tencent.mobileqq.app.handler.receivesuccess;

import MessageSvcPack.RequestPushStatus;
import com.tencent.biz.qrcode.logindev.LoginDevicesManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class MessageSvcRequestPushStatus
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("MessageSvc.RequestPushStatus".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject != null)
      {
        paramToServiceMsg = (RequestPushStatus)paramObject;
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("RequestPushStatus status:");
          paramFromServiceMsg.append(paramToServiceMsg.cStatus);
          paramFromServiceMsg.append("supportdataline:");
          paramFromServiceMsg.append(paramToServiceMsg.cDataLine);
          QLog.d("Q.msg.MessageHandler", 2, paramFromServiceMsg.toString());
        }
        paramFromServiceMsg = (RegisterProxySvcPackHandler)paramMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
        int i;
        if (paramToServiceMsg.cStatus == 1)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.MessageHandler", 4, "PConline now");
          }
          paramMessageHandler.j();
          i = 1;
        }
        else
        {
          if (paramToServiceMsg.cStatus == 2)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("Q.msg.MessageHandler", 4, "PCoffline now");
            }
            paramMessageHandler.b(0);
          }
          i = 0;
        }
        if ((i == 1) && (QFileAssistantUtils.c(paramMessageHandler.a)))
        {
          QFileAssistantUtils.a(paramMessageHandler.a, 0, true);
          QFileAssistantUtils.b(paramMessageHandler.a);
        }
        int j = (byte)((LoginDevicesManager)paramMessageHandler.a.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER)).a(paramToServiceMsg.vecInstanceList);
        paramFromServiceMsg.b(i);
        paramFromServiceMsg.e(paramToServiceMsg.cDataLine);
        paramFromServiceMsg.f(paramToServiceMsg.cPrintable);
        paramFromServiceMsg.g(paramToServiceMsg.cViewFile);
        paramFromServiceMsg.a(paramToServiceMsg.nPCVer);
        paramFromServiceMsg.b(paramToServiceMsg.nClientType);
        paramFromServiceMsg.c(paramToServiceMsg.nInstanceId);
        paramFromServiceMsg.a(j);
        paramFromServiceMsg.c();
        paramFromServiceMsg.h(i);
        paramMessageHandler = (DataLineHandler)paramMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        paramMessageHandler.b(paramToServiceMsg.vecInstanceList);
        paramMessageHandler.a().a(i, paramToServiceMsg.cDataLine, paramToServiceMsg.cPrintable, paramToServiceMsg.cViewFile, paramToServiceMsg.nPCVer);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "RequestPushStatus ret, but data is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MessageSvcRequestPushStatus
 * JD-Core Version:    0.7.0.1
 */