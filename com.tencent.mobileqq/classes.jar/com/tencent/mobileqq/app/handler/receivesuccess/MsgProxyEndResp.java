package com.tencent.mobileqq.app.handler.receivesuccess;

import RegisterProxySvcPack.RegisterPushNotice;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.handler.RegisterProxyHandler;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class MsgProxyEndResp
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg arg2, Object paramObject)
  {
    if ("RegPrxySvc.NoticeEnd".equalsIgnoreCase(???.getServiceCmd()))
    {
      if (!(paramObject instanceof RegisterPushNotice))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleRegisterProxyEndResp RegPrxySvc.NoticeEnd ERROR");
        }
        return;
      }
      paramToServiceMsg = (RegisterPushNotice)paramObject;
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("registerproxy->handleRegisterProxyEndResp RegPrxySvc.NoticeEnd endseq=");
        ???.append(paramToServiceMsg.uEndSeq);
        ???.append(",timeoutflag=");
        ???.append(paramToServiceMsg.ulTimeOutFlag);
        QLog.d("Q.msg.MessageHandler", 2, new Object[] { ???.toString(), ", uInterval_forbid_pulldown=", Long.valueOf(paramToServiceMsg.uInterval_forbid_pulldown) });
      }
      long l;
      if (paramToServiceMsg.uEndSeq == paramMessageHandler.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.c)
      {
        l = 0L;
        paramMessageHandler.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_a_of_type_AndroidUtilPair = new Pair(paramToServiceMsg, Long.valueOf(0L));
        paramMessageHandler.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        paramMessageHandler.c(paramToServiceMsg.uInterval_forbid_pulldown);
      }
      else
      {
        if (paramToServiceMsg.uEndSeq != paramMessageHandler.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.d) {
          return;
        }
        paramMessageHandler.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_a_of_type_AndroidUtilPair = new Pair(paramToServiceMsg, Long.valueOf(1L));
        l = 1L;
      }
      if ((paramMessageHandler.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.e != 0) && (paramToServiceMsg.uEndSeq == paramMessageHandler.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.e))
      {
        paramMessageHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(false);
        paramMessageHandler.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.e = 0;
      }
      if (((paramMessageHandler.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.a()) && (paramMessageHandler.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.b())) || (!RegisterProxyHandler.b)) {
        synchronized (paramMessageHandler.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
        {
          if (paramMessageHandler.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_a_of_type_AndroidUtilPair != null)
          {
            paramMessageHandler.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_a_of_type_AndroidUtilPair = null;
            if ((l == 1L) || (!paramMessageHandler.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.c()) || (!paramMessageHandler.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.b()))
            {
              paramMessageHandler.c();
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyEndResp RegPrxySvc.NoticeEnd notify");
              }
              paramMessageHandler.notifyUI(4013, true, new Long[] { Long.valueOf(paramToServiceMsg.ulTimeOutFlag), Long.valueOf(l) });
            }
            paramMessageHandler.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
            paramMessageHandler.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MsgProxyEndResp
 * JD-Core Version:    0.7.0.1
 */